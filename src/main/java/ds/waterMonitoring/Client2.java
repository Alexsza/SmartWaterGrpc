package ds.waterMonitoring;

import java.awt.Dimension;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ds.hotWater.*;

import ds.hotWater.TankTempConfirm;
import ds.hotWater.desiredTankTemp;
import ds.waterMonitoring.MonitoringServiceGrpc.MonitoringServiceStub;
import ds.waterMonitoring.MonitoringServiceGrpc.MonitoringServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client2 extends JFrame {

    private static String SERVICE_TYPE = "_waterMonitoring._tcp.local.";
    private static String SERVICE_NAME = "MonitoringService";
    private static String SERVICE_HOST = "localhost";
    private static int SERVICE_PORT = 50052;
    private static MonitoringServiceStub stub;
    private static ManagedChannel channel;

    private JLabel areaNameLabel, sensorDataLabel;
    private static JTextField userInputField;
    private JButton MonitorAreaButton, sendSensorDataButton;
    private static JTextArea textArea;

    public Client2() {
        super("Water Monitoring Service");

        areaNameLabel = new JLabel("Area Name");
        userInputField = new JTextField(10);
        MonitorAreaButton = new JButton("Monitor Area");
        // MonitorAreaButton.addActionListener(e -> MonitorArea());

        sensorDataLabel = new JLabel("Send Sensor Data");
        sendSensorDataButton = new JButton("Send Data");
        sendSensorDataButton.addActionListener(e -> sendSensorData());

        JPanel panel = new JPanel();
        panel.add(areaNameLabel);
        panel.add(userInputField);
        panel.add(MonitorAreaButton);
        panel.add(sensorDataLabel);
        panel.add(sendSensorDataButton);

        textArea = new JTextArea(10, 40);
        panel.add(new JScrollPane(textArea));

        add(panel);

        // Set the preferred size of the frame
        setPreferredSize(new Dimension(500, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo != null) {
                SERVICE_HOST = serviceInfo.getHostAddresses()[0];
                SERVICE_PORT = serviceInfo.getPort();
                System.out.println("Discovered service: " + SERVICE_HOST + ":" + SERVICE_PORT + " ("
                        + serviceInfo.getName() + ")");
            } else {
                System.out.println("Service not found");
            }
            jmdns.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a channel to connect to the server
        channel = ManagedChannelBuilder.forAddress(SERVICE_HOST, SERVICE_PORT).usePlaintext().build();

        // Create a stub for the service
        stub = MonitoringServiceGrpc.newStub(channel);

        // new instance of the class to create and display the GUI
        new Client2();
    }

    private void MonitorArea() {
        // code to monitor the area goes here
    }

    private void sendSensorData() {

        // Create a stream observer for the server responses
        StreamObserver<SensorDataResponse> responseObserver = new StreamObserver<SensorDataResponse>() {

            @Override
            public void onNext(SensorDataResponse response) {
                // Print the response in the text area
                textArea.append(response.getAlert() + "\n" + response.getRecommendation() + "\n");
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream completed");
            }
        };

        // Create a stream observer for the client requests
        StreamObserver<SensorDataRequest> requestObserver = stub.sendSensorData(responseObserver);

        // Send some sensor data
        SensorDataRequest request1 = SensorDataRequest.newBuilder().setAreaName("Area 1").setWaterUsage(100).build();
        requestObserver.onNext(request1);

        SensorDataRequest request2 = SensorDataRequest.newBuilder().setAreaName("Area 2").setWaterUsage(200).build();
        requestObserver.onNext(request2);

        // End the request stream
        requestObserver.onCompleted();

        // Shutdown the channel if it is not already shutdown
        if (!channel.isShutdown()) {
            channel.shutdown();
        }
    }
}