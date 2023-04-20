package ds.waterMonitoring;

import ds.waterMonitoring.MonitoringServiceGrpc.MonitoringServiceImplBase;
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
import java.util.Properties;
import java.util.Random;

public class MonitoringService extends MonitoringServiceImplBase {

    public static void main(String[] args) {
        MonitoringService monitoring = new MonitoringService();

        Properties prop = monitoring.getProperties();

        monitoring.registerService(prop);

        int port = Integer.parseInt(prop.getProperty("service_port")); // #50052

        try {

            Server server = ServerBuilder.forPort(port).addService(monitoring).build().start();

            System.out.println("Water Monitoring server started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // Auto-generated catch block
            System.out.println("Error 1");
            e.printStackTrace();
        } catch (InterruptedException e) {
            // Auto-generated catch block
            System.out.println("Error 2");
            e.printStackTrace();
        }

    }

    private Properties getProperties() {

        Properties prop = null;

        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/monitoring.properties"))) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Current Service properies");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " + prop.getProperty("service_name"));
            System.out.println("\t service_description: " + prop.getProperty("service_description"));
            System.out.println("\t service_port: " + prop.getProperty("service_port"));

        } catch (IOException ex) {
            System.out.println("Error 3");
            ex.printStackTrace();
        }

        return prop;
    }

    private void registerService(Properties prop) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            String service_type = prop.getProperty("service_type");// "_waterMonitoring._tcp.local";
            String service_name = prop.getProperty("service_name");// "MonitoringService";
            int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50052;

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
            System.out.println("Error 4");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // Auto-generated catch block
            System.out.println("Error 5");
            e.printStackTrace();
        }

    }

    @Override
    public void monitorArea(AreaRequest request, StreamObserver<AreaResponse> responseObserver) {
        System.out.println("Monitor Area started ");
        // Extract the area name from the request+
        String areaName = request.getAreaName();
        System.out.println("Receiving AreaName " + areaName);
        // Implement the logic to monitor the water usage in the specified area
        Random rand = new Random();
        // Monitor the tank levels for the given tankId.
        // Send multiple responses to the client using the responseObserver.
        for (int i = 0; i < 5; i++) {
            try {
                int usage = rand.nextInt(1000) + 1;
                String issue = "";
                if(usage < 10) {
                    issue = "Tank is not currently used, possible blockage in area: " + areaName;
                }else if(usage >950) {
                    issue = "Current usage level indicates water is running contiusouly in area: " + areaName;
                }else if(usage >750) {
                    issue = "Current usage is higher than normal, monitor area: " + areaName;
                }else {
                    issue = "Normal levels observed";
                }
                AreaResponse response = AreaResponse.newBuilder().setWaterUsage(usage).setIssues(issue)
                        .build();
                responseObserver.onNext(response);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        // Once all the responses have been sent, call completed
        responseObserver.onCompleted();
        System.out.println("Monitor Area is now completed.");
    }


    @Override
    public StreamObserver<SensorDataRequest> sendSensorData(StreamObserver<SensorDataResponse> responseObserver) {

        return new StreamObserver<SensorDataRequest>() {


            @Override
            public void onNext(SensorDataRequest request) {
                int waterUsage = request.getWaterUsage();
                String areaName = request.getAreaName();
                System.out.println("Received data for area: " + areaName + ", water usage: " + waterUsage);
                String alertMessage = "";
                String recommendationMessage = "";
                if (waterUsage > 950) {
                    alertMessage = "Possible water leak detected in area " + areaName + " water usage "
                            + waterUsage + " recorded. " + "\n";
                    recommendationMessage = "Check for open taps or continous water flow";

                } else if (waterUsage > 800) {
                    alertMessage = "Unusual high water usage in " + areaName + " water usage " + waterUsage
                            + " recorded. " + "\n";
                    recommendationMessage = "Please inspect the area visually to detect source of leak";
                }else {
                    recommendationMessage = "All good. ";
                }
                SensorDataResponse response = SensorDataResponse.newBuilder().setAlert(alertMessage)
                        .setRecommendation(recommendationMessage).build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Sensor data stream error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Sensor data stream completed");
                responseObserver.onCompleted();
            }
        };
    }
}
