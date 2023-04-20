package ds.waterMonitoring;

import java.awt.Dimension;
import java.net.InetAddress;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ds.waterMonitoring.MonitoringServiceGrpc.MonitoringServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client2 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static String SERVICE_HOST = "localhost";
    private static int SERVICE_PORT = 50052;
    private static MonitoringServiceStub asyncStub;

    private static String message = "";
    private int count=0;

    private static JTextField userInputField;
    private static JTextArea textArea;

    public Client2() {
        super("Water Monitoring Service");

        JLabel areaNameLabel = new JLabel("Area Name");
        userInputField = new JTextField(10);
        JButton monitorAreaButton = new JButton("Monitor Area");
        monitorAreaButton.addActionListener(e -> MonitorArea());

        JLabel sensorDataLabel = new JLabel("Send Sensor Data");
        JButton sendSensorDataButton = new JButton("Send Data");
        sendSensorDataButton.addActionListener(e -> sendSensorData());

        JPanel panel = new JPanel();
        panel.add(areaNameLabel);
        panel.add(userInputField);
        panel.add(monitorAreaButton);
        panel.add(sensorDataLabel);
        panel.add(sendSensorDataButton);

        textArea = new JTextArea(20, 80);
        panel.add(new JScrollPane(textArea));

        add(panel);

        // Set the preferred size of the frame
        setPreferredSize(new Dimension(1000, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            String SERVICE_NAME = "MonitoringService";
            String SERVICE_TYPE = "_waterMonitoring._tcp.local.";
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
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVICE_HOST, SERVICE_PORT).usePlaintext().build();

        // Create a stub for the service
        //	stub = MonitoringServiceGrpc.newBlockingStub(channel);

        asyncStub = MonitoringServiceGrpc.newStub(channel);

        // new instance of the class to create and display the GUI
        new Client2();

        //Timeout
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }

    private void MonitorArea() {
        System.out.println("Monitor Area commenced.");
        String userInput = userInputField.getText();
        textArea.setText("");
        count=0;

        // Create a request for the monitorTankLevels() method.
        AreaRequest request = AreaRequest.newBuilder().setAreaName(userInput).build();


        // Call the MonitorArea() method with the request and a StreamObserver to handle the responses.
        asyncStub.monitorArea(request, new StreamObserver<AreaResponse>() {
            public void onNext(AreaResponse response) {
                // Handle the response from the server.
                // increment count to keep track of cycles
                count++;
                //print to Client console
                System.out.println("Cycle: " + count + "; " + response);
                //print to GUI
                message = "Cycle: " + count+ "; "  + response;
                textArea.append(message);
            }

            @Override
            public void onError(Throwable t) {
                // Handle any errors that occur during the streaming RPC.
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // Called when all responses have been received from the server.
                System.out.println("Monitor Area completed.");
            }
        });
    }

    private void sendSensorData() {
        System.out.println("Send Sensor Data method commenced");
        textArea.setText("");
        // Create a stream observer for the server responses
        StreamObserver<SensorDataResponse> responseObserver = new StreamObserver<SensorDataResponse>() {

            @Override
            public void onNext(SensorDataResponse response) {
                // Print the response in the text area
                count++;
                textArea.append("Cycle; " + count + " " + response.getAlert() + response.getRecommendation() + "\n");
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Send Sensor Data Stream completed");
            }
        };

        // Create a stream observer for the client requests
        StreamObserver<SensorDataRequest> requestObserver = asyncStub.sendSensorData(responseObserver);

        Random rand = new Random();
        String[] areaName = {"Car Wash", "Public Toilet", "Staff Toilet", "Restaurant1", "Restaurant2", "ServiceArea", "Boiler room", "Water Tanks"};

        int count = 0;

        // Send some sensor data
        // Send data stream with loop
        for (int i = 0; i < 5; i++) {
            try {
                // generate a random index between 0 and the length of the array
                int randomIndex = rand.nextInt(areaName.length);
                //Identify the array value at specified random index, cast to String
                String area = areaName[randomIndex];
                SensorDataRequest request1 = SensorDataRequest.newBuilder().setAreaName(area)
                        .setWaterUsage(rand.nextInt(1000) + 1).build();
                requestObserver.onNext(request1);
                count++;
                System.out.println("Sending data for cycle " + count);



                // Shutdown the channel if it is not already shutdown
            } catch (RuntimeException e) {
                e.printStackTrace();
            }

        }
        // End the request stream
        requestObserver.onCompleted();
        System.out.println("Send Sensor data complete.");

    }
}
