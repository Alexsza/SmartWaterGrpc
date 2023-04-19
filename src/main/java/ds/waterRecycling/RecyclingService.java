package ds.waterRecycling;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.waterRecycling.*;
import ds.hotWater.UsageDataRequest;
import ds.hotWater.UsageDataResponse;
import ds.hotWater.desiredTankTemp;
import ds.waterMonitoring.*;
import ds.waterMonitoring.MonitoringServiceGrpc.MonitoringServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RecyclingService extends MonitoringServiceImplBase {

    public static void main(String[] args){
        RecyclingService monitoring = new RecyclingService();

        Properties prop = monitoring.getProperties();

        monitoring.registerService(prop);

        int port = Integer.valueOf(prop.getProperty("service_port")); // #50053

        try {

            Server server = ServerBuilder.forPort(port).addService(monitoring).build().start();

            System.out.println("Water Monitoring server started, listening on " + port);

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

        try (InputStream input = new FileInputStream("src/main/resources/recycling.properties")) {

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

            String service_type = prop.getProperty("service_type");// "_waterRecycling._tcp.local.";
            String service_name = prop.getProperty("service_name");// "Recycling_Service";
            int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50053;

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


    @Override
    public StreamObserver<SensorDataRequest> sendSensorData(StreamObserver<SensorDataResponse> responseObserver) {
        StreamObserver<SensorDataRequest> requestObserver = new StreamObserver<SensorDataRequest>() {
            private int totalWaterUsage = 0;
            private boolean waterLeakDetected = false;

            @Override
            public void onNext(SensorDataRequest request) {
                int waterUsage = request.getWaterUsage();
                totalWaterUsage += waterUsage;
                String areaName = request.getAreaName();
                System.out.println("Received data for area: " + areaName + ", water usage: " + waterUsage);

                if (waterUsage > 100) {
                    waterLeakDetected = true;
                }

                if (totalWaterUsage > 1000 || waterLeakDetected) {
                    String alertMessage = "Possible water leak detected in area " + areaName;
                    String recommendationMessage = "Please inspect the area manually";
                    SensorDataResponse response = SensorDataResponse.newBuilder()
                            .setAlert(alertMessage)
                            .setRecommendation(recommendationMessage)
                            .build();
                    responseObserver.onNext(response);
                }
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
        responseObserver.onNext(SensorDataResponse.newBuilder().build());
        responseObserver.onCompleted();
        return requestObserver;
    }

/*

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
*/


    public StreamObserver<RainwaterTank> SwitchToRainwaterTank(StreamObserver<RainwaterResponse> responseObserver) {
        return new StreamObserver<RainwaterTank>() {
            ArrayList<Integer> tankID = new ArrayList<Integer>();
            ArrayList<Integer> tankLevel = new ArrayList<Integer>();


            public void onNext(RainwaterTank request) {
                System.out.println("receiving Rainwater tank values: " + "Tank ID: " + request.getTankId() + " Tank level: " + request.getTankLevels());
                tankID.add(request.getTankId());
                tankLevel.add(request.getTankLevels());
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onCompleted() {
                System.out.println("receiving Hot Water data method complete");
                String message = "";
                String message2 = "";
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
                responseObserver.onCompleted();
            }
        };
    }

}
