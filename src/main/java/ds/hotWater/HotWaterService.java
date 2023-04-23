package ds.hotWater;

import ds.hotWater.HotWaterServiceGrpc.HotWaterServiceImplBase;
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


public class HotWaterService extends HotWaterServiceImplBase {
    //main method
    public static void main(String[] args) throws InterruptedException, IOException {
        //create an object if HotWaterService & Properties
        HotWaterService hotwater = new HotWaterService();

        Properties prop = hotwater.getProperties();

        hotwater.registerService(prop);
        //Access point to the service is represented by port variables.
        int port = Integer.parseInt(prop.getProperty("service_port")); // #50051
        //build server
        try {

            Server server = ServerBuilder.forPort(port).addService(hotwater).build().start();

            System.out.println("Current server started, listening on " + port);

            java.util.logging.Logger.getLogger("javax.jmdns").setLevel(java.util.logging.Level.SEVERE);

            server.awaitTermination();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private Properties getProperties() {

        Properties prop = null;
        //receive connection properties from designated path
        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/hotWater.properties"))) {

            prop = new Properties();

            // load the properties file
            prop.load(input);

            // get the property value and print it out on the server console
            System.out.println("HotWater Service properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " + prop.getProperty("service_name"));
            System.out.println("\t service_description: " + prop.getProperty("service_description"));
            System.out.println("\t service_port: " + prop.getProperty("service_port"));
        //exception handling
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

            String service_type = prop.getProperty("service_type");// "_http._tcp.local.";
            String service_name = prop.getProperty("service_name");// "hotWaterService";
            int service_port = Integer.parseInt(prop.getProperty("service_port"));// #.50051;

            String service_description_properties = prop.getProperty("service_description");//

            // Register the service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
                    service_description_properties);
            jmdns.registerService(serviceInfo);
            //confirm on console
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
    //unary rpc method
    public void setTankTemperature(desiredTankTemp request, StreamObserver<TankTempConfirm> responseObserver) {
        //console log for confirmation
        System.out.println("Executing Set Tank Temperature method.");
        System.out.println("receiving user input temperature: " + request.getDesiredTemp());

        //create random data to mock current temperature acquired by server
        Random rand = new Random();
        int currentTemp = rand.nextInt(101);

        int newTemp = request.getDesiredTemp();

        // Code to set the tank temperature to the desired temperature - console log and response
        String confirmation = "Tank temperature is now setting to " + newTemp + " from " + currentTemp;
        //build the response
        TankTempConfirm response = TankTempConfirm.newBuilder().setConfirmation(confirmation).build();
        //send response to client
        responseObserver.onNext(response);
        //finish the call and log it onto console
        responseObserver.onCompleted();
        System.out.println("Set Tank Temperature method completed.");
    }
    //Client side streaming rpc
    @Override
    public StreamObserver<UsageDataRequest> sendUsageData(StreamObserver<UsageDataResponse> responseObserver) {
        return new StreamObserver<UsageDataRequest>() {
            //create array lists to store stream of data received by server from client
            final ArrayList<Integer> temp = new ArrayList<>();
            final ArrayList<Integer> level = new ArrayList<>();
            final ArrayList<Integer> flow = new ArrayList<>();
            final ArrayList<Integer> pressure = new ArrayList<>();

            //receive data by using getters and store into the arrays created above
            @Override
            public void onNext(UsageDataRequest request) {
                System.out.println("receiving hot water data values: " + "\n" + "Water temp: " + request.getHotWaterTemp() + "\n" + " Tank level: " + request.getTankLevel() + "\n" + " Flow rate: " + request.getFlowRate() + " Water pressure: " + request.getWaterPressure());
                temp.add(request.getHotWaterTemp());
                level.add(request.getTankLevel());
                flow.add(request.getFlowRate());
                pressure.add(request.getWaterPressure());
            }
            //Error handling
            @Override
            public void onError(Throwable t) {
                System.err.println("Send Usage data stream tank error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                //when stream complete, log to console
                System.out.print("receiving Hot Water data method complete \n");
                //create empty message strings to create parts of the recommendation
                String message = "";
                String message2 = "";
                String message3 = "";
                String message4 = "";

                //implement logic to verify incoming data and set up a recommendation accordingly, if no issue return confirmation of same
                for (int tempValue : temp) {
                    if (tempValue < 65) {
                        message = "\n" + "Check temperature! " + tempValue + "C recorded. ";
                        break;
                    } else {
                        message = "\n" + "Water Temp OK. ";
                    }
                }
                for (int waterLevel : level) {
                    if (waterLevel < 600) {
                        message2 = "\n" + "Check tank level! " + waterLevel + " litres recorded. ";
                        break;
                    } else {
                        message2 = "\n" + "Tank Level OK. ";
                    }
                }
                for (int flowRate : flow) {
                    if (flowRate < 9) {
                        message3 = "\n" + "Check flow Rate! " + flowRate + " gpm recorded. ";
                        break;
                    } else {
                        message3 = "\n" + "Flow Rate OK. ";
                    }
                }
                for (int waterPressure : pressure) {
                    if (waterPressure < 40) {
                        message4 = "\n" + "Water pressure issue! " + waterPressure + " psi recorded. ";
                        break;
                    } else {
                        message4 = "\n" + "Water Pressue OK. ";
                    }
                }
                //concatenate messages into the result variable that will be passed as recommendation, log to console
                String result = message + message2 + message3 + message4;
                System.out.println(result);
                // build the response
                UsageDataResponse reply = UsageDataResponse.newBuilder().setRecommendation(result).build();
                //send the response to client
                responseObserver.onNext(reply);
                //complete call
                responseObserver.onCompleted();
                System.out.println("Send Usage Data method completed.");
            }
        };
    }
}
