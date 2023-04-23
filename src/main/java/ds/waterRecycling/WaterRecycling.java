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
    //main method
    public static void main(String[] args) {
        //create new object of the class
        WaterRecycling recycling = new WaterRecycling();

        Properties prop = recycling.getProperties();

        recycling.registerService(prop);
        //Access point to the service is represented by port variables.
        int port = Integer.parseInt(prop.getProperty("service_port")); // #50053
        //build server
        try {

            Server server = ServerBuilder.forPort(port).addService(recycling).build().start();

            java.util.logging.Logger.getLogger("javax.jmdns").setLevel(java.util.logging.Level.SEVERE);

            System.out.println("Water Monitoring server started, listening on " + port);

            server.awaitTermination();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private Properties getProperties() {

        Properties prop = null;
        //receive connection properties from designated path
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

            //exception handling Input/Output
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }
    //method to register a service
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
            //confirm on console
            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

            // Wait a bit
            Thread.sleep(1000);

            // Unregister all services
            // jmdns.unregisterAllServices();
        //Exception handling
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // implement unary rpc checkTankLevel method
    @Override
    public void checkTankLevel(TankRequest request, StreamObserver<TankResponse> responseObserver) {

        System.out.println("Executing Check Tank Temperature method. ");

        //create random data to mock current tank level acquired by server
        Random rand = new Random();
        int currentLevel = rand.nextInt(1001); // generate random number for tank level between 1 & 1000

        int tankID = request.getTankId();

        // Code to confirm current tank levels of the user specified tank
        String confirmation = "TankID " + tankID + " current level is: " + currentLevel + " litres ";
        System.out.println(confirmation);

        /* Add a sleep to simulate a long-running process */
        try {
           Thread.sleep(500); // Sleep for 0.5 seconds
            // Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //build the response
        TankResponse response = TankResponse.newBuilder().setTankLevel(currentLevel).build();
        //send response to client
        responseObserver.onNext(response);
        //finish the call and log it onto console
        responseObserver.onCompleted();
        System.out.println("Check Tank level method completed.");
    }

    // implementation of Server-side streaming monitorTankLevels method
    @Override
    public void monitorTankLevels(MonitorLevels request, StreamObserver<LevelsResponse> responseObserver) {
        System.out.println("Executing Monitor Tank Levels method ");
        //receive tank id specified by user from client & log to console
        int tankId = request.getTankId();
        System.out.println("Received tankId: " + tankId);
        // create random numbers for streaming mock data
        Random rand = new Random();

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
        // Once all the responses have been sent, call completed, log confirmation to console
        responseObserver.onCompleted();
        System.out.println("Monitor Tank Levels method completed. ");
    }

    // implement Client-side streaming switchToRainwaterTank method
    public StreamObserver<RainwaterTank> switchToRainwaterTank(StreamObserver<RainwaterResponse> responseObserver) {
        return new StreamObserver<RainwaterTank>() {
            //create array lists to store stream of data received by server from client
            final ArrayList<Integer> tankID = new ArrayList<>();
            final ArrayList<Integer> tankLevel = new ArrayList<>();

            @Override
            public void onNext(RainwaterTank rainwaterTank) {
                //receive data by using getters and store into the arrays created above
                int id = rainwaterTank.getTankId();
                int level = rainwaterTank.getTankLevels();
                //log to console
                System.out.println("Checking Rainwater tank values: " + "Tank ID: " + rainwaterTank.getTankId()
                        + " Tank level: " + rainwaterTank.getTankLevels());
                tankID.add(id);
                tankLevel.add(level);
            }
            //Error handling
            @Override
            public void onError(Throwable t) {
                System.err.println("Switch to rainwater tank error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                //when stream complete, log to console
                System.out.println("Receiving data complete");
                String message = "";
                String message2;
                int highestLevel = 0;
                int currentTankUsed = 0;

                //implement logic to check incoming data for the highest level
                // Identify tank id with the highest level and set it as the response to return to client

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
                // build the response
                RainwaterResponse reply = RainwaterResponse.newBuilder().setCurrentTankUsed(currentTankUsed).build();
                //send the response to client
                responseObserver.onNext(reply);
                //complete
                responseObserver.onCompleted();
                System.out.println("Switch Rainwater tank method completed");
            }
        };
    }
}
