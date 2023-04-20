package ds.waterRecycling;

import ds.waterRecycling.WaterRecyclingGrpc.WaterRecyclingImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class WaterRecycling extends WaterRecyclingImplBase {

    public static void main(String[] args) {
        WaterRecycling monitoring = new WaterRecycling();

        Properties prop = monitoring.getProperties();

        monitoring.registerService(prop);

        int port = Integer.parseInt(prop.getProperty("service_port")); // #50053

        try {

            Server server = ServerBuilder.forPort(port).addService(monitoring).build().start();

            System.out.println("Water Monitoring server started, listening on " + port);

            server.awaitTermination();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private Properties getProperties() {

        Properties prop = null;

        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/recycling.properties"))) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Current Service properties ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " + prop.getProperty("service_name"));
            System.out.println("\t service_description: " + prop.getProperty("service_description"));
            System.out.println("\t service_port: " + prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    private void registerService(Properties prop) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            String service_type = prop.getProperty("service_type");// "_waterRecycling._tcp.local.";
            String service_name = prop.getProperty("service_name");// "Recycling_Service";
            int service_port = Integer.parseInt(prop.getProperty("service_port"));// #.50053;

            String service_description_properties = prop.getProperty("service_description");//

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
                    service_description_properties);
            jmdns.registerService(serviceInfo);

            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

            // Wait a bit
            Thread.sleep(1000);

            // Unregister all services
            // jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // implement unary rpc checkTankLevel method
    @Override
    public void checkTankLevel(TankRequest request, StreamObserver<TankResponse> responseObserver) {

        System.out.println("Executing Set Tank Temperature method. ");

        Random rand = new Random();
        int currentLevel = rand.nextInt(1001); // generate random number for tank level between 1 & 1000

        int tankID = request.getTankId();

        // Code to set the tank temperature to the desired temperature
        String confirmation = "TankID " + tankID + " current level is: " + currentLevel + " litres ";
        System.out.println(confirmation);

        TankResponse response = TankResponse.newBuilder().setTankLevel(currentLevel).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
        System.out.println("Set Tank Temperature method completed.");
    }

    // implement Server-side streaming monitorTankLevels method

    @Override
    public void monitorTankLevels(MonitorLevels request, StreamObserver<LevelsResponse> responseObserver) {
        System.out.println("Executing Monitor Tank Levels method ");
        int tankId = request.getTankId();
        System.out.println("Received tankId: " + tankId);
        // create random numbers for input
        Random rand = new Random();
        // Monitor the tank levels for the given tankId.

        // Send multiple responses to the client using the responseObserver.
        for (int i = 0; i < 5; i++) {
            try {
                LevelsResponse response = LevelsResponse.newBuilder().setTankId(tankId)
                        .setCurrentLevel(rand.nextInt(1000) + 1).build();
                responseObserver.onNext(response);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        // Once all the responses have been sent, call completed
        responseObserver.onCompleted();
        System.out.println("Monitor Tank Levels method completed. ");
    }

    // implement Client-side streaming switchToRainwaterTank method
    public StreamObserver<RainwaterTank> switchToRainwaterTank(StreamObserver<RainwaterResponse> responseObserver) {
        return new StreamObserver<RainwaterTank>() {

            final ArrayList<Integer> tankID = new ArrayList<>();
            final ArrayList<Integer> tankLevel = new ArrayList<>();

            @Override
            public void onNext(RainwaterTank rainwaterTank) {

                int id = rainwaterTank.getTankId();
                int level = rainwaterTank.getTankLevels();

                System.out.println("Checking Rainwater tank values: " + "Tank ID: " + rainwaterTank.getTankId()
                        + " Tank level: " + rainwaterTank.getTankLevels());
                tankID.add(id);
                tankLevel.add(level);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Switch to rainwater tank error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Receiving data complete");
                String message = "";
                String message2;
                int highestLevel = 0;
                int currentTankUsed = 0;

                for (int i = 0; i < tankLevel.size(); i++) {
                    if (tankLevel.get(i) > highestLevel) {
                        highestLevel = tankLevel.get(i);
                        currentTankUsed = tankID.get(i);
                    }
                    if (tankLevel.get(i) < 200) {
                        message = "Change to different tank, water level " + tankLevel.get(i) + " litres recorded. ";
                        break;
                    } else {
                        message = "Water levels OK. ";
                    }
                }
                if (highestLevel < 600) {
                    message2 = "Check tank level! " + highestLevel + " litres recorded. ";
                } else {
                    message2 = "Tank Level OK. ";
                }

                System.out.println(message + message2);
                RainwaterResponse reply = RainwaterResponse.newBuilder().setCurrentTankUsed(currentTankUsed).build();
                responseObserver.onNext(reply);

                //complete
                responseObserver.onCompleted();
                System.out.println("Switch Rainwater tank method completed");
            }
        };
    }
}
