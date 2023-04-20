package ds.waterRecycling;

import ds.waterRecycling.WaterRecyclingGrpc.WaterRecyclingBlockingStub;
import ds.waterRecycling.WaterRecyclingGrpc.WaterRecyclingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Client3 extends JFrame {

    private static WaterRecyclingBlockingStub blockingStub;
    private static WaterRecyclingStub asyncStub;
    private static int userInput = 0;
    private static int cycle =0;
    private static String SERVICE_HOST = "localhost";
    private static int SERVICE_PORT = 50053;

    private static JTextField userInputField, userInputField2;
    private static JTextArea textArea;

    public Client3() {
        super("Recycling Service");

        JLabel tankRequestLabel = new JLabel("Enter TankID");
        userInputField = new JTextField(10);
        JButton checkTankLevelButton = new JButton("Check Tank Level");
        checkTankLevelButton.addActionListener(e -> checkTankLevel());

        JLabel monitorLevelsLabel = new JLabel("Monitor TankID: ");
        userInputField2 = new JTextField(10);
        JButton monitorLevelsButton = new JButton("Request Monitoring");
        monitorLevelsButton.addActionListener(e -> monitorTankLevels());

        JLabel rainwaterTankLabel = new JLabel("Rainwater Tanks");
        JButton switchRainwaterTankButton = new JButton("Switch to Full Tank");
        switchRainwaterTankButton.addActionListener(e -> switchToRainwaterTank());

        JPanel panel = new JPanel();
        panel.add(tankRequestLabel);
        panel.add(userInputField);
        panel.add(checkTankLevelButton);
        panel.add(monitorLevelsLabel);
        panel.add(userInputField2);
        panel.add(monitorLevelsButton);
        panel.add(rainwaterTankLabel);
        panel.add(switchRainwaterTankButton);

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
        String SERVICE_TYPE = "_waterRecycling._tcp.local.";
        String SERVICE_NAME = "WaterRecycling";
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

        // stubs -- generate from proto file
        blockingStub = WaterRecyclingGrpc.newBlockingStub(channel);

        asyncStub = WaterRecyclingGrpc.newStub(channel);

        new Client3();

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
    public static void checkTankLevel() {

        System.out.println("Calling Check Tank Level method ");

        userInput = Integer.parseInt(userInputField.getText());
        TankRequest req = TankRequest.newBuilder().setTankId(userInput).build();

        // retrieving reply from service
        TankResponse response = blockingStub.checkTankLevel(req);
        int currentLevel = response.getTankLevel();
        String message = "\n" + "Current level for tank " + userInput + " is: " + currentLevel + " litres";

        System.out.println("Server response: \n" + message);
        textArea.setText(message);
        System.out.println("Check Tank Level method response received & finished. ");

    }

    public static void monitorTankLevels() {
        System.out.println("Calling Monitor Tank Level method ");

        userInput = Integer.parseInt(userInputField2.getText());
        cycle=0;
        textArea.setText("");

        // Create a request for the monitorTankLevels() method.
        MonitorLevels request = MonitorLevels.newBuilder().setTankId(userInput) //
                .build();

        // Call the monitorTankLevels() method with the request and a StreamObserver to
        // handle the responses.
        asyncStub.monitorTankLevels(request, new StreamObserver<LevelsResponse>() {
            public void onNext(LevelsResponse response) {
                // Handle the response from the server
                cycle++;
                int tankId = response.getTankId();
                int currentLevel = response.getCurrentLevel();
                System.out.println("Cycle: " + cycle + ": Tank ID: " + tankId + ", Current Level: " + currentLevel);
                String message ="\n" + "Cycle: " + cycle + ": Tank ID: " + tankId + ", Current Level: " + currentLevel;
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
                System.out.println("Monitor Tank Level response received & method complete.");
            }
        });
    }

    // client side streaming
    public static void switchToRainwaterTank() {
        StreamObserver<RainwaterResponse> responseObserver = new StreamObserver<RainwaterResponse>() {

            public void onNext(RainwaterResponse msg) {
                System.out.println("receiving TankId and level data ");
                System.out.println("Recommendation based on incoming data: " + msg.getCurrentTankUsed());
                String message = "Recommendation based on incoming data is to switch to tankID " + msg.getCurrentTankUsed() + "\n";
                textArea.append(message);

                // JOptionPane for testing response
                // JOptionPane.showMessageDialog(null, message);

            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Switch Rainwater tank method completed");

            }

        };

        StreamObserver<RainwaterTank> requestObserver = asyncStub.switchToRainwaterTank(responseObserver);
        // create random numbers for input
        Random rand = new Random();
        textArea.setText("");
        System.out.println("Switch Rainwater tank method comenced");

        for (int i = 0; i < 5; i++) {
            try {
                requestObserver.onNext(RainwaterTank.newBuilder().setTankId(rand.nextInt(10)+1)
                        .setTankLevels(rand.nextInt(1000) + 1).build());
                Thread.sleep(500);
            } catch (InterruptedException | RuntimeException e) {
                e.printStackTrace();
            }
        }

        // Mark the end of requests
        requestObserver.onCompleted();

    }

}
