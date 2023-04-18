package ds.hotWater;

import java.awt.Dimension;

import javax.jmdns.JmDNS;
import javax.jmdns.NetworkTopologyDiscovery;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import ds.hotWater.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;



public class Client extends JFrame {

    private static HotWaterServiceGrpc.HotWaterServiceBlockingStub blockingStub;
    private static HotWaterServiceGrpc.HotWaterServiceStub asyncStub;
    private static int userInput = 0;
    private static String SERVICE_TYPE = "_hotwater._tcp.local.";
    private static String SERVICE_NAME = "HotWaterService";
    private static String SERVICE_HOST = "localhost";
    private static int SERVICE_PORT = 50051;

    private JLabel tankTempLabel, usageDataLabel;
    private static JTextField userInputField;
    private JButton setTankTempButton, sendUsageDataButton;
    private static JTextArea textArea;

    public Client() {
        super("Hot Water Service");

        tankTempLabel = new JLabel("Set Tank Temperature");
        userInputField = new JTextField(10);
        setTankTempButton = new JButton("Set");
        setTankTempButton.addActionListener(e -> setTankTemperature());

        usageDataLabel = new JLabel("Send Usage Data");
        sendUsageDataButton = new JButton("Send");
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
        blockingStub = HotWaterServiceGrpc.newBlockingStub(channel);

        asyncStub = HotWaterServiceGrpc.newStub(channel);

        new Client();

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
    public static void setTankTemperature() {
        userInput = Integer.parseInt(userInputField.getText());
        desiredTankTemp req = desiredTankTemp.newBuilder().setDesiredTemp(userInput).build();

        // retrieving reply from service
        TankTempConfirm response = blockingStub.setTankTemperature(req);

        System.out.println("Server response: " + response.getConfirmation());
        textArea.append("Tank temperature set to " + response.getConfirmation() + "\n");


        //	JOptionPane to test response
        //	JOptionPane.showMessageDialog(null, "Tank temperature set to " + response.getConfirmation());
    }

    // client side streaming
    public static void SendUsageData() {
        StreamObserver<UsageDataResponse> responseObserver = new StreamObserver<UsageDataResponse>() {

            public void onNext(UsageDataResponse msg) {
                System.out.println("receiving hot water data ");
                System.out.println("Recommendation based on incoming data: " + msg.getRecommendation());
                String message = "Recommendation based on incoming data:\n" + msg.getRecommendation() + "\n";
                textArea.append(message);

                // JOptionPane for testing response
                //	JOptionPane.showMessageDialog(null, message);

            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream is completed ... receiving converted info");

            }

        };

        StreamObserver<UsageDataRequest> requestObserver = asyncStub.sendUsageData(responseObserver);
        // create random numbers for input
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            try {
                requestObserver.onNext(UsageDataRequest.newBuilder().setHotWaterTemp(rand.nextInt(60) + 40) // Random
                        // number
                        // between
                        // 40 and
                        // 100
                        .setTankLevel(rand.nextInt(700) + 300) // Random number between 300 and 1000
                        .setFlowRate(rand.nextInt(10) + 5) // Random number between 5 and 15
                        .setWaterPressure(rand.nextInt(30) + 20) // Random number between 30 and 50
                        .build());
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
