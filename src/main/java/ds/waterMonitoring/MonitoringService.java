package ds.waterMonitoring;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.waterMonitoring.*;
import ds.waterMonitoring.MonitoringServiceGrpc.MonitoringServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class MonitoringService extends MonitoringServiceImplBase {

    public static void main(String[] args){
        MonitoringService monitoring = new MonitoringService();

        Properties prop = monitoring.getProperties();

        monitoring.registerService(prop);

        int port = Integer.valueOf(prop.getProperty("service_port")); // #50052

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

        try (InputStream input = new FileInputStream("src/main/resources/monitoring.properties")) {

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

            String service_type = prop.getProperty("service_type");// "_waterMonitoring._tcp.local";
            String service_name = prop.getProperty("service_name");// "MonitoringService";
            int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.50052;

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
/*
	public void MonitorArea(AreaRequest request, StreamObserver<AreaResponse> responseObserver) {

		System.out.println("receiving Set Tank Temperature method " + request.getDesiredTemp());

		Random rand = new Random();
		int currentTemp = rand.nextInt(101);

		String newArea = request.getAreaName();

		// Code to set the tank temperature to the desired temperature
		String confirmation = "Tank temperature is now setting to " + newArea + " from " + currentTemp;

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
}
