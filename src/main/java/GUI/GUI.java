package GUI;

import ds.hotWater.*;
import ds.hotWater.HotWaterServiceGrpc.HotWaterServiceBlockingStub;
import ds.waterMonitoring.*;
import ds.waterMonitoring.MonitoringServiceGrpc.MonitoringServiceStub;
import ds.waterRecycling.*;
import ds.waterRecycling.WaterRecyclingGrpc.WaterRecyclingBlockingStub;
import ds.waterRecycling.WaterRecyclingGrpc.WaterRecyclingStub;
import io.grpc.Deadline;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.DNSRecord.Service;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GUI extends JFrame {

    private static Service serviceHost;
    //constructor
    public GUI(Service serviceHost) {
        GUI.serviceHost = serviceHost;
    }

    private static final long serialVersionUID = 1L;
    private static String SERVICE_HOST;
    private static int SERVICE_PORT;
    private static HotWaterServiceBlockingStub blockingStub;
    private static HotWaterServiceGrpc.HotWaterServiceStub asyncStub;
    private static MonitoringServiceStub asyncStub2;
    private static WaterRecyclingBlockingStub blockingStub3;
    private static WaterRecyclingStub asyncStub3;
    private static int count;
    private static int userInput;
    private static int port;

    // GUI components for the Services
    private static JTextField userInputField;
    private static JTextArea textArea;
    private static JTextField userInputField2;


    public GUI(int servicePort) {
        //
        super("Services");

        // Create the GUI components based on the service port

        if (servicePort == 50051) {
            // Create the GUI components for the Hot Water Service
            //create and assign fields, and button to call the method
            JLabel tankTempLabel = new JLabel("Set Tank Temperature");
            userInputField = new JTextField(10);
            JButton setTankTempButton = new JButton("Set");
            setTankTempButton.addActionListener(e -> setTankTemperature());

            JLabel usageDataLabel = new JLabel("Send Usage Data");
            JButton sendUsageDataButton = new JButton("Send");
            sendUsageDataButton.addActionListener(e -> SendUsageData());
            //add components to the panel
            JPanel panel = new JPanel();
            panel.add(tankTempLabel);
            panel.add(userInputField);
            panel.add(setTankTempButton);
            panel.add(usageDataLabel);
            panel.add(sendUsageDataButton);
            //create area for the response to be printed out to user
            textArea = new JTextArea(10, 40);
            panel.add(new JScrollPane(textArea));

            add(panel);

            // Set the preferred size of the frame
            setPreferredSize(new Dimension(500, 300));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            setVisible(true);
        //same for the next 2 services
        } else if (servicePort == 50052) {
            // Create the GUI components for the Water Monitoring Service
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

        } else if (servicePort == 50053) {
            // Create the GUI components for the Water Recycling Service

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
    }
//connect the client file to the server through JmDNS
    private static Service connectToServer() {
        try {

            // Discovering service using JmDNS
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            String[] serviceTypes = { "_hotwater._tcp.local.", "_waterMonitoring._tcp.local.",
                    "_waterRecycling._tcp.local." }; // the types of services to connect to
            for (String serviceType : serviceTypes) {
                ServiceInfo[] serviceInfos = jmdns.list(serviceType);
                for (ServiceInfo serviceInfo : serviceInfos) {
                    // connect to the service with the given host address and port
                    SERVICE_HOST = serviceInfo.getHostAddresses()[0];
                    SERVICE_PORT = serviceInfo.getPort();

                    System.out.println("Discovered service: " + SERVICE_HOST + ":" + SERVICE_PORT + " ("
                            + serviceInfo.getName() + ")");
                }
                //create port variable and assign discovered port value
                port = SERVICE_PORT;
            }
            jmdns.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serviceHost;

    }

    public static void main(String[] args) throws Exception {
        Service serviceHost = connectToServer();
        //build the channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVICE_HOST, SERVICE_PORT).usePlaintext().build();
        System.out.println("line after managed channel port " + SERVICE_PORT + " host: " + SERVICE_HOST);

        // stubs for synchronous and asynchronous communications
        blockingStub = HotWaterServiceGrpc.newBlockingStub(channel);
        asyncStub = HotWaterServiceGrpc.newStub(channel);
        asyncStub2 = MonitoringServiceGrpc.newStub(channel);
        blockingStub3 = WaterRecyclingGrpc.newBlockingStub(channel);
        asyncStub3 = WaterRecyclingGrpc.newStub(channel);
        //call the GUI(int) method passing the port value as a parameter
        new GUI(port);

        // Timeout of 7 seconds for the channel to terminate gracefully
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    channel.shutdown().awaitTermination(7, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hot Water Service methods
    // unary rpc
    public static void setTankTemperature() {
        System.out.println("Calling Set Tank Temperature method.");
        //acquire user input value with a getter
        int userInput = Integer.parseInt(userInputField.getText());
        //build request including the user input to pass onto the server
        desiredTankTemp req = desiredTankTemp.newBuilder().setDesiredTemp(userInput).build();
        System.out.println("Sending user input to server.");


        // retrieving reply from service
        TankTempConfirm response = blockingStub.setTankTemperature(req);
        //Console log to confirm
        System.out.println("Server response: " + response.getConfirmation());
        textArea.setText(response.getConfirmation() + "\n");

        //	JOptionPane to test response
        //	JOptionPane.showMessageDialog(null, "Tank temperature set to " + response.getConfirmation());
        System.out.println("Set Tank Temperature method completed.");
    }

    // client side streaming
    public static void SendUsageData() {
        StreamObserver<UsageDataResponse> responseObserver = new StreamObserver<UsageDataResponse>() {
            //response from server using a getter (console log and GUI output)
            public void onNext(UsageDataResponse msg) {
                System.out.println("Recommendation based on incoming data: " + msg.getRecommendation());
                String message = "Recommendation based on incoming data:\n" + msg.getRecommendation();
                textArea.setText(message);

                // JOptionPane for testing response
                // JOptionPane.showMessageDialog(null, message);
            }
            //Error handling
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Send usage data call is completed ... ");
            }

        };
        //request handling
        StreamObserver<UsageDataRequest> requestObserver = asyncStub.sendUsageData(responseObserver);
        // create random numbers for input
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            try {
                requestObserver.onNext(UsageDataRequest.newBuilder().setHotWaterTemp(rand.nextInt(60) + 40)
                        .setTankLevel(rand.nextInt(700) + 300).setFlowRate(rand.nextInt(10) + 5)
                        .setWaterPressure(rand.nextInt(30) + 20).build());
                Thread.sleep(500);
            } catch (InterruptedException | RuntimeException e) {
                e.printStackTrace();
            }
        }

        // Mark the end of requests
        requestObserver.onCompleted();
        System.out.println("Hot water data stream to server complete ");

    }

    // Water Monitoring Services
    //server side streaming
    private void MonitorArea() {
        System.out.println("Monitor Area commenced.");
        //get user input from GUI
        String userInput = userInputField.getText();
        //reset GUI response output area & counter to empty for repeat calls
        textArea.setText("");
        count=0;

        // Create a request for the monitorTankLevels() method.
        AreaRequest request = AreaRequest.newBuilder().setAreaName(userInput).build();


        // Call the MonitorArea() method with the request and a StreamObserver to handle the responses.
        asyncStub2.monitorArea(request, new StreamObserver<AreaResponse>() {

            public void onNext(AreaResponse response) {
                // Handle the response from the server.
                // Increment count to keep track of cycles
                count++;
                //print to Client console
                System.out.println("Cycle: " + count + "; " + response);
                //print to GUI
                String message = "Cycle: " + count+ "; "  + response;
                textArea.append(message);
            }

            @Override
            public void onError(Throwable t) {
                // Handle any errors that occur during the streaming RPC.
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // All responses have been received from the server.
                System.out.println("Monitor Area completed.");
                //Reset counter to 0 for repeat calls
                count =0;
            }
        });
    }
    //bidirectional streaming method
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
                count =0;
            }
        };

        // Create a stream observer for the client requests
        StreamObserver<SensorDataRequest> requestObserver = asyncStub2.sendSensorData(responseObserver);
        //create random mock data for streaming
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

            } catch (RuntimeException e) {
                e.printStackTrace();
            }

        }
        // End the request stream
        requestObserver.onCompleted();
        System.out.println("Send Sensor data complete.");

    }

    //Water Recycling Service Methods
    // unary rpc checkTankLevel method
    public static void checkTankLevel() {

        System.out.println("Calling Check Tank Level method ");
        //get user input value from GUI
        userInput = Integer.parseInt(userInputField.getText());
        //build and send request
        TankRequest req = TankRequest.newBuilder().setTankId(userInput).build();

        // Set a timeout for the RPC to 2 seconds (dummy sleep line in server implementation for testing
        Deadline deadline = Deadline.after(2, TimeUnit.SECONDS);

        // Create a new blocking stub with the timeout set
        WaterRecyclingBlockingStub stubWithDeadline =
                blockingStub3.withDeadline(deadline);

        // Retrieve the reply from the service
        TankResponse response;
        try {
            response = stubWithDeadline.checkTankLevel(req);
            //timeout exception handling
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
            return;
        }

        int currentLevel = response.getTankLevel();
        String message = "\n" + "Current level for tank " + userInput + " is: " + currentLevel + " litres";

        System.out.println("Server response: \n" + message);
        textArea.setText(message);
        System.out.println("Check Tank Level method response received & finished. ");

    }

    //server side stream
    public static void monitorTankLevels() {
        System.out.println("Calling Monitor Tank Level method ");
        //get value of user input (second input filed in this frame)
        userInput = Integer.parseInt(userInputField2.getText());
        count=0;
        textArea.setText("");

        // Create a request for the monitorTankLevels() method.
        MonitorLevels request = MonitorLevels.newBuilder().setTankId(userInput) //
                .build();

        // Call the monitorTankLevels() method with the request and a StreamObserver to                                                 handle the responses.
        asyncStub3.monitorTankLevels(request, new StreamObserver<LevelsResponse>() {
            public void onNext(LevelsResponse response) {
                // Handle the response from the server
                count++;
                int tankId = response.getTankId();
                int currentLevel = response.getCurrentLevel();
                System.out.println("Cycle: " + count + ": Tank ID: " + tankId + ", Current Level: " + currentLevel);
                String message ="\n" + "Cycle: " + count + ": Tank ID: " + tankId + ", Current Level: " + currentLevel;
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
            //response handling - console log & GUI reply field appended
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

        StreamObserver<RainwaterTank> requestObserver = asyncStub3.switchToRainwaterTank(responseObserver);
        // create random numbers for input
        Random rand = new Random();
        textArea.setText("");
        System.out.println("Switch Rainwater tank method commenced");
        //create 5 instances of randomly generated mock data to stream
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
