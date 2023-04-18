package ds.hotWater;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.hotWater.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HotWaterService extends HotWaterServiceGrpc.HotWaterServiceImplBase {

    public static void main(String[] args) throws InterruptedException, IOException {
        HotWaterService hotwater = new HotWaterService();

        Properties prop = hotwater.getProperties();

        hotwater.registerService(prop);

        int port = Integer.valueOf(prop.getProperty("service_port")); // #50051

        try {

            Server server = ServerBuilder.forPort(port).addService(hotwater).build().start();

            System.out.println("HotWater server started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private Properties getProperties() {

        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/hotWater.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("HotWater Service properies ...");
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

            String service_type = prop.getProperty("service_type");// "_http._tcp.local.";
            String service_name = prop.getProperty("service_name");// "example";
            // int service_port = 1234;
            int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50051;

            String service_description_properties = prop.getProperty("service_description");// "path=index.html";

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void setTankTemperature(desiredTankTemp request, StreamObserver<TankTempConfirm> responseObserver) {

        System.out.println("receiving Set Tank Temperature method " + request.getDesiredTemp());

        Random rand = new Random();
        int currentTemp = rand.nextInt(101);

        int newTemp = request.getDesiredTemp();

        // Code to set the tank temperature to the desired temperature
        String confirmation = "Tank temperature is now setting to " + newTemp + " from " + currentTemp;

        TankTempConfirm response = TankTempConfirm.newBuilder().setConfirmation(confirmation).build();

        responseObserver.onNext(response);

        try {
            Thread.sleep(5000); // wait for 5 seconds before shutting down the server
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        responseObserver.onCompleted();
    }



    @Override
    public StreamObserver<UsageDataRequest> sendUsageData(StreamObserver<UsageDataResponse> responseObserver) {
        return new StreamObserver<UsageDataRequest>() {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            ArrayList<Integer> level = new ArrayList<Integer>();
            ArrayList<Integer> flow = new ArrayList<Integer>();
            ArrayList<Integer> pressure = new ArrayList<Integer>();


            @Override
            public void onNext(UsageDataRequest request) {
                System.out.println("receiving hot water data values: " + "Water temp: " + request.getHotWaterTemp() + " Tank level: " + request.getTankLevel() + " Flow rate: " + request.getFlowRate() + " Water pressure: " + request.getWaterPressure());
                temp.add(request.getHotWaterTemp());
                level.add(request.getTankLevel());
                flow.add(request.getFlowRate());
                pressure.add(request.getWaterPressure());
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onCompleted() {
                System.out.printf("receiving Hot Water data method complete \n");
                String message = "";
                String message2 = "";
                String message3 = "";
                String message4 = "";

                for (int tempValue : temp) {
                    if (tempValue < 65) {
                        message = "Check temperature! " + tempValue + "C recorded. ";
                        break;
                    } else {
                        message = "Water Temp OK. ";
                    }
                }
                for (int waterLevel : level) {
                    if (waterLevel < 600) {
                        message2 = "Check tank level! " + waterLevel + " litres recorded. ";
                        break;
                    } else {
                        message2 = "Tank Level OK. ";
                    }
                }
                for (int flowRate : flow) {
                    if (flowRate < 9) {
                        message3 = "Check flow Rate! " + flowRate + " gpm recorded. ";
                        break;
                    } else {
                        message3 = "Flow Rate OK. ";
                    }
                }
                for (int waterPressure : pressure) {
                    if (waterPressure < 40) {
                        message4 = "Water pressure issue! " + waterPressure + " psi recorded. ";
                        break;
                    } else {
                        message4 = "Water Pressue OK. ";
                    }
                }
                String result = message + message2 + message3 + message4;
                System.out.println(result);
                UsageDataResponse reply = UsageDataResponse.newBuilder().setRecommendation(result).build();
                responseObserver.onNext(reply);
                responseObserver.onCompleted();
            }
        };
    }
}