package ds.waterRecycling;

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

import ds.waterRecycling.*;
import ds.waterRecycling.WaterRecyclingGrpc.WaterRecyclingBlockingStub;
import ds.waterRecycling.WaterRecyclingGrpc.WaterRecyclingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client3 extends JFrame {

    private static WaterRecyclingBlockingStub blockingStub;
    private static WaterRecyclingStub asyncStub;
    private static int userInput = 0;
    private static String SERVICE_TYPE = "_waterRecycling._tcp.local.";
    private static String SERVICE_NAME = "WaterRecycling";
    private static String SERVICE_HOST = "localhost";
    private static int SERVICE_PORT = 50053;

    private JLabel tankRequestLabel, MonitorLevelsLabel, RainwaterTankLabel;
    private static JTextField userInputField, userInputField2;
    private JButton CheckTankLevelButton, MonitorLevelsButton, SwitchRainwaterTankButton;
    private static JTextArea textArea;

    public Client3() {
        super("Recycling Service");

        tankRequestLabel = new JLabel("Enter TankID");
        userInputField = new JTextField(10);
        CheckTankLevelButton = new JButton("Check Tank Level");
        CheckTankLevelButton.addActionListener(e -> checkTankLevel());

        MonitorLevelsLabel = new JLabel("Monitor TankID: ");
        userInputField2 = new JTextField(10);
        MonitorLevelsButton = new JButton("Request Monitoring");
        MonitorLevelsButton.addActionListener(e -> monitorTankLevels());

        RainwaterTankLabel = new JLabel("Rainwater Tanks");
        SwitchRainwaterTankButton = new JButton("Switch");
        SwitchRainwaterTankButton.addActionListener(e -> switchToRainwaterTank());


        JPanel panel = new JPanel();
        panel.add(tankRequestLabel);
        panel.add(userInputField);
        panel.add(CheckTankLevelButton);
        panel.add(MonitorLevelsLabel);
        panel.add(userInputField2);
        panel.add(MonitorLevelsButton);
        panel.add(RainwaterTankLabel);
        panel.add(SwitchRainwaterTankButton);

        textArea = new JTextArea(10, 40);
        panel.add(new JScrollPane(textArea));

        add(panel);

        // Set the preferred size of the frame
        setPreferredSize(new Dimension(800, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {

        // Discovering service using JmDNS
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
        if (serviceInfo != null) {
            SERVICE_HOST = serviceInfo.getHostAddresses()[0];
            SERVICE_PORT = serviceInfo.getPort();
            System.out.println("Discovered service: " + SERVICE_HOST + ":" + SERVICE_PORT);
        } else {
            System.out.println("Service not found");
        }
        jmdns.close();

        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVICE_HOST, SERVICE_PORT).usePlaintext().build();

        // stubs -- generate from proto file
        blockingStub = WaterRecyclingGrpc.newBlockingStub(channel);

        asyncStub = WaterRecyclingGrpc.newStub(channel);

        new Client3();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    // unary rpc
    public static void checkTankLevel() {

        userInput = Integer.parseInt(userInputField.getText());
        TankRequest req = TankRequest.newBuilder().setTankId(userInput).build();

        // retrieving reply from service
        TankResponse response = blockingStub.checkTankLevel(req);
        int currentLevel = response.getTankLevel();
        String message = "\n" + "Current level for tank " + userInput + " is: " + currentLevel + " litres";

        System.out.println("Server response: \n" + message);
        textArea.append(message);
    }

    public static void monitorTankLevels() {
        userInput = Integer.parseInt(userInputField2.getText());

        // Create a request for the monitorTankLevels() method.
        MonitorLevels request = MonitorLevels.newBuilder().setTankId(userInput) //
                .build();

        // Call the monitorTankLevels() method with the request and a StreamObserver to
        // handle the responses.
        asyncStub.monitorTankLevels(request, new StreamObserver<LevelsResponse>() {
            public void onNext(LevelsResponse response) {
                // Handle the response from the server.
                int tankId = response.getTankId();
                int currentLevel = response.getCurrentLevel();
                System.out.println("Tank ID: " + tankId + ", Current Level: " + currentLevel);
                String message = "\n" + "Tank ID: " + tankId + ", Current Level: " + currentLevel;
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
                System.out.println("Monitoring complete.");
            }
        });
    }

    // client side streaming
    public static void switchToRainwaterTank() {
        StreamObserver<RainwaterResponse> responseObserver = new StreamObserver<RainwaterResponse>() {

            public void onNext(RainwaterResponse msg) {
                System.out.println("receiving TankId and level data ");
                System.out.println("Recommendation based on incoming data: " + msg.getCurrentTankUsed());
                String message = "Recommendation to switch to tankID " + msg.getCurrentTankUsed() + "\n";
                textArea.append("\n" + message);

                // JOptionPane for testing response
                // JOptionPane.showMessageDialog(null, message);

            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream is completed ... receiving info");

            }

        };

        StreamObserver<RainwaterTank> requestObserver = asyncStub.switchToRainwaterTank(responseObserver);
        // create random numbers for input
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            try {
                requestObserver.onNext(RainwaterTank.newBuilder().setTankId(rand.nextInt(10))
                        .setTankLevels(rand.nextInt(1000) + 1).build());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }

        // Mark the end of requests
        requestObserver.onCompleted();

    }

}
