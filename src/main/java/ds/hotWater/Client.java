package ds.hotWater;

import java.awt.Dimension;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;

import java.net.InetAddress;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ds.hotWater.HotWaterServiceGrpc.HotWaterServiceBlockingStub;
import ds.hotWater.HotWaterServiceGrpc.HotWaterServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class Client extends JFrame {

    private static HotWaterServiceBlockingStub blockingStub;
    private static HotWaterServiceStub asyncStub;
    private static String SERVICE_HOST = "localhost";
    private static int SERVICE_PORT = 50051;

    private static JTextField userInputField;
    private static JTextArea textArea;

    public Client() {
        super("Hot Water Service");

        JLabel tankTempLabel = new JLabel("Set Tank Temperature");
        userInputField = new JTextField(10);
        JButton setTankTempButton = new JButton("Set");
        setTankTempButton.addActionListener(e -> setTankTemperature());

        JLabel usageDataLabel = new JLabel("Send Usage Data");
        JButton sendUsageDataButton = new JButton("Send");
        sendUsageDataButton.addActionListener(e -> SendUsageData());

        JPanel panel = new JPanel();
        panel.add(tankTempLabel);
        panel.add(userInputField);
        panel.add(setTankTempButton);
        panel.add(usageDataLabel);
        panel.add(sendUsageDataButton);

        textArea = new JTextArea(10, 40);
        panel.add(new JScrollPane(textArea));

        add(panel);

        // Set the preferred size of the frame
        setPreferredSize(new Dimension(500, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {

        // Discovering service using JmDNS
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        String SERVICE_TYPE = "_hotwater._tcp.local.";
        String SERVICE_NAME = "HotWaterService";
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

        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVICE_HOST, SERVICE_PORT).usePlaintext().build();

        // stubs
        blockingStub = HotWaterServiceGrpc.newBlockingStub(channel);

        asyncStub = HotWaterServiceGrpc.newStub(channel);

        new Client();

        //Timeout
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

    }

    // unary rpc
    public static void setTankTemperature() {
        System.out.println("Calling Set Tank Temperature method.");
        int userInput = Integer.parseInt(userInputField.getText());
        desiredTankTemp req = desiredTankTemp.newBuilder().setDesiredTemp(userInput).build();
        System.out.println("Sending user input to server.");


        // retrieving reply from service
        TankTempConfirm response = blockingStub.setTankTemperature(req);

        System.out.println("Server response: " + response.getConfirmation());
        textArea.setText(response.getConfirmation() + "\n");


        //	JOptionPane to test response
        //	JOptionPane.showMessageDialog(null, "Tank temperature set to " + response.getConfirmation());
        System.out.println("Set Tank Temperature method completed.");

    }

    // client side streaming
    public static void SendUsageData() {
        StreamObserver<UsageDataResponse> responseObserver = new StreamObserver<UsageDataResponse>() {

            public void onNext(UsageDataResponse msg) {
                System.out.println("Recommendation based on incoming data: " + msg.getRecommendation());
                String message = "Recommendation based on incoming data:\n" + msg.getRecommendation();
                textArea.setText(message);

                // JOptionPane for testing response
                //	JOptionPane.showMessageDialog(null, message);

            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Send usage data call is completed ... ");

            }

        };

        StreamObserver<UsageDataRequest> requestObserver = asyncStub.sendUsageData(responseObserver);
        // create random numbers for input
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            try {
                requestObserver.onNext(UsageDataRequest.newBuilder().setHotWaterTemp(rand.nextInt(60) + 40)
                        .setTankLevel(rand.nextInt(700) + 300)
                        .setFlowRate(rand.nextInt(10) + 5)
                        .setWaterPressure(rand.nextInt(30) + 20)
                        .build());
                Thread.sleep(500);
            } catch (InterruptedException | RuntimeException e) {
                e.printStackTrace();
            }
        }

        // Mark the end of requests
        requestObserver.onCompleted();
        System.out.println("Hot water data stream to server complete ");


    }

}
