package ds.waterRecycling;

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

import ds.waterRecycling.*;
import ds.waterRecycling.WaterRecyclingGrpc.WaterRecyclingBlockingStub;
import ds.waterRecycling.WaterRecyclingGrpc.WaterRecyclingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;



public class Client3 extends JFrame {

    private static WaterRecyclingBlockingStub blockingStub;
    private static WaterRecyclingStub asyncStub;
    private static int userInput = 0;
    private static String SERVICE_TYPE = "_waterRecycling._tcp.local.";
    private static String SERVICE_NAME = "Recycling_Service";
    private static String SERVICE_HOST = "localhost";
    private static int SERVICE_PORT = 50053;

    private JLabel tankRequestLabel, MonitorLevelsLabel, RainwaterTankLabel;
    private static JTextField userInputField;
    private JButton CheckTankLevelsButton, MonitorLevelsButton, SwitchRainwaterTankButton;
    private static JTextArea textArea;

    public Client3() {
        super("Water Recycling Service");

        tankRequestLabel = new JLabel("Enter TankID");
        userInputField = new JTextField(10);
        CheckTankLevelsButton = new JButton("Set");
        CheckTankLevelsButton.addActionListener(e -> CheckTankLevels());

        RainwaterTankLabel = new JLabel("Rainwater Tanks");
        SwitchRainwaterTankButton = new JButton("Switch");
        SwitchRainwaterTankButton.addActionListener(e -> SwitchToRainwaterTank());

        JPanel panel = new JPanel();
        panel.add(tankRequestLabel);
        panel.add(userInputField);
        panel.add(CheckTankLevelsButton);
        //need to add Monitor Tanklevel controls
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
    public static void CheckTankLevels() {
		/*
		userInput = Integer.parseInt(userInputField.getText());
		TankRequest req = TankRequest.newBuilder().TankResponse(userInput).build();

		// retrieving reply from service
		TankTempConfirm response = blockingStub.setTankTemperature(req);

		System.out.println("Server response: " + response.getConfirmation());
		textArea.append("Tank temperature set to " + response.getConfirmation() + "\n");

    */
        //	JOptionPane to test response
        //	JOptionPane.showMessageDialog(null, "Tank temperature set to " + response.getConfirmation());
    }

    // client side streaming
    public static void SwitchToRainwaterTank() {
        StreamObserver<RainwaterResponse> responseObserver = new StreamObserver<RainwaterResponse>() {

            public void onNext(RainwaterResponse msg) {
                System.out.println("receiving TankId and level data ");
                System.out.println("Recommendation based on incoming data: " + msg.getCurrentTankUsed());
                String message = "Recommendation to switch to tankID " + msg.getCurrentTankUsed() + "\n";
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

        StreamObserver<RainwaterTank> requestObserver = asyncStub.switchToRainwaterTank(responseObserver);
        // create random numbers for input
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            try {
                requestObserver.onNext(RainwaterTank.newBuilder().setTankId(rand.nextInt(10)) // Random
                        // number
                        // between
                        // 40 and
                        // 100
                        .setTankLevels(rand.nextInt(1000) + 1) // Random number between 1 and 1000
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
