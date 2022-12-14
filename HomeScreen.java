/* Project:  Milestone 2
 * Class: HomeScreen.java
 * Author:   Ryan Doyle, Luis Guarin, Tyler Logan, Dondre Campbell, Shafin Ahmed
 * Date: October 4, 2022
 * This program creates the gui that has 2 buttons that leads to 2 new frames where the user enters in info and submits info into a txt
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class HomeScreen extends JFrame implements ActionListener {

    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    public static JButton REJECT;
    public static JButton Refresh;

    public static JLabel clientMessage;

    private static JFrame HomeScreenFrame;
    private static JFrame ComputeFrame;
    private static JPanel HomeScreenPanel;

    public static JTextField clientUserName;
    public static JTextField clientPassword;
    public static JTextField clientFullName;
    public static JTextField clientDeadline;
    public static String JOBNAME;


    static ActionEvent ea;
    public static JTextField clientJobDuration;
    public static JTextField ownerID;
    public static JTextField ownerFullname;
    public static JTextField ownerCarMake;
    public static JTextField ownerCarModel;
    public static JTextField ownerCarYear;
    public static JTextField residencyTime;
    public static Label HomeScreenLabel;
    public static JPanel ComputePanel;
    public static JTextField controllerUsername;
    public static JTextField controllerPassword;
    public static JTextField JobIDField;
    public static JTextArea textArea2;
    public static JLabel POPOO = new JLabel();
    public static JLabel AdminLabel;
    public static JPanel ComputeImagePanel;
    public static JPanel ComputeImagePanel2;
    public static JPanel ComputeImagePanel3;
    public static JPanel ComputeImagePanel4;
    public static JLabel TimeLabel;
    public static SimpleDateFormat TimeFormatter;
    public static String Time;
    public static String JOBNUMBERSTRING = String.valueOf(HomeScreen.clientJobDuration);

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    static String AdminSelect;



    static JButton loginButton;
    static JButton enterButton2;
    static JButton ACCEPT;
    public static JButton ACCEPTOWNER;
    public static JButton REJECTOWNER;





    public static void main(String[] args) throws IOException {

        socket = new Socket("localhost", 3000);

        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());


        HomeScreenFrame = new JFrame("VCRTS Project");
        HomeScreenFrame.setSize(1400, 800);// 500 x 500
        HomeScreenFrame.getContentPane().setBackground(new Color(199,160,215));
        HomeScreenFrame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        HomeScreenPanel = new JPanel();
        JPanel CarImagePanel2 = new JPanel(); // ? made panel to hold car image label
        CarImagePanel2.setPreferredSize(new Dimension(450, 950));
        CarImagePanel2.setBackground(new Color(199, 160, 215));




        JLabel CarLabel2 = new JLabel();
        CarLabel2.setIcon(new ImageIcon("C:\\Users\\Luis\\Downloads\\Header.png"));
        CarLabel2.setBackground(Color.black);

        JLabel CarLabel3 = new JLabel();
        CarLabel3.setIcon(new ImageIcon("C:\\Users\\Luis\\Downloads\\header2.jpeg"));
        CarLabel3.setBackground(Color.black);

        //CarLabel2.setIcon(new ImageIcon("Images/AC



        HomeScreenPanel.setBackground(new Color(199, 160, 215));
        HomeScreenPanel.setLayout(null);
        HomeScreenPanel.setPreferredSize(new Dimension(900,900));

        ImageIcon favicon = new ImageIcon("C:\\Users\\Luis\\CUS1166 GUI\\src\\Images\\MotherBoardIcon.png");

        HomeScreenFrame.setIconImage(favicon.getImage());
        TimeLabel = new JLabel();
        TimeFormatter = new SimpleDateFormat("hh:mm:ss a");
        Time = TimeFormatter.format(new Date());
        TimeLabel.setText(Time);
        button1 = new JButton("Client Registration"); // Client rents a vehicle
        button2 = new JButton("Vehicle Registration"); // Owner registers a car
        button3 = new JButton("VC Controller"); // Owner registers a car

        button1.setBackground(new Color(250, 249, 249));
        button2.setBackground(new Color(250, 249, 249));
        button3.setBackground(new Color(250, 249, 249));
        CarImagePanel2.setBounds(200,50,500,300);
        button1.setBounds(20,400,250,60);

        button2.setBounds(320,400,250,60);

        button3.setBounds(620,400,250,60);
        CarImagePanel2.add(CarLabel2);
        HomeScreenPanel.add(CarImagePanel2);

        HomeScreenPanel.add(button1);
        HomeScreenPanel.add(button2);
        HomeScreenPanel.add(button3);


        // keep these two lines of codes below add button
        HomeScreenFrame.add(HomeScreenPanel);

        // This line has to be after declaring the HomeScreenPanel and setting it's
        // color to show that the object has been defined before it is added or else the
        // home screen will be blank
        HomeScreenFrame.setVisible(true);
        ActionListener clientsLOGIN = new ClientRegistrationPage();
        button1.addActionListener(clientsLOGIN);
        ActionListener ownerLogin = new VehicleRegistrationPage();

        button2.addActionListener(ownerLogin);
        ActionListener vcController = new vcControllerPage();
        button3.addActionListener(vcController);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // Action performed method that gives functionality to java "back button"
    static class ClientRegistrationPage implements ActionListener {
        public void actionPerformed(ActionEvent e) { // create new window for owner to login
            if (e.getSource() == button1) {
                createClientButton();
                HomeScreenFrame.dispose();
            }
        }
    }

    public static void createClientButton() { // Beginning of createClientButton

        JFrame frame2 = new JFrame("Client Login");

        frame2.getContentPane().setBackground(new Color(191, 161, 250));
        frame2.setBackground(new Color(170, 128, 252));

        frame2.setSize(500, 500);
        frame2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JPanel panel2 = new JPanel();


        panel2.setPreferredSize(new Dimension(190, 700));
        panel2.setBackground(new Color(204, 178, 255));

        JPanel CarImagePanel2 = new JPanel(); // ? made panel to hold car image label
        CarImagePanel2.setPreferredSize(new Dimension(200, 700));
        CarImagePanel2.setBackground(new Color(191, 161, 250));

        JLabel label2 = new JLabel("Client ID");
        JLabel labelP = new JLabel("Password");
        JLabel labelFN = new JLabel("Full Name");
        JLabel labelJobID = new JLabel("Job ID");
        JLabel labelTime = new JLabel("Job Duration (Hours)");
        JLabel labelDeadline = new JLabel("Deadline");
        JLabel CarLabel2 = new JLabel();
        CarLabel2.setIcon(new ImageIcon("C:\\Users\\Luis\\CUS1166 GUI\\src\\Images\\tablet.png"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH: mm :ss");
        LocalDateTime now = LocalDateTime.now();
        String DateTimer = (dtf.format(now));
        enterButton2 = new JButton(new AbstractAction("Enter") { // make back button to go to previous window

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == enterButton2)
                    Job.Job2();
                System.out.println("Request Pending...");
                Client.UserName = clientUserName.getText();
                Client.fullName = clientFullName.getText();
                Client.deadLine = clientDeadline.getText();
                Client.duration = clientJobDuration.getText();
                Client.JobIDString = JobIDField.getText();

                clientUserName.setText("");
                clientPassword.setText("");
                clientFullName.setText("");
                JobIDField.setText("");
                clientJobDuration.setText("");


                HomeScreen.clientDeadline.setText("");


            }});

        JButton back = new JButton(new AbstractAction("Back") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                HomeScreenFrame.setVisible(true);
                frame2.dispose();
            }
        });
        // labels added to the panel
        clientUserName = new JTextField();// textfield for username
        clientUserName.setPreferredSize(new Dimension(150, 20));
        clientUserName.setFont(new Font("Consolas", Font.PLAIN, 15));

        clientPassword = new JPasswordField();// textfield for password
        clientPassword.setPreferredSize(new Dimension(150, 20));

        clientFullName = new JTextField();// textfield for full name
        clientFullName.setPreferredSize(new Dimension(150, 20));

        JobIDField = new JTextField();// textfield for job duration
        JobIDField.setPreferredSize(new Dimension(150, 20));


        clientJobDuration = new JTextField();// textfield for job duration
        clientJobDuration.setPreferredSize(new Dimension(150, 20));


        clientDeadline = new JTextField();// textfield for deadline
        clientDeadline.setPreferredSize(new Dimension(150, 20));

        // clientMessage = new JLabel();
        // labels added to the panel

        panel2.add(label2);
        panel2.add(clientUserName);

        panel2.add(labelP);
        panel2.add(clientPassword);

        panel2.add(labelFN);
        panel2.add(clientFullName);




        panel2.add(labelTime);
        panel2.add(clientJobDuration);



        panel2.add(labelDeadline);
        panel2.add(clientDeadline);


        CarImagePanel2.add(CarLabel2);
        enterButton2.setBackground(new Color(250, 249, 249));
        back.setBackground(new Color(250, 249, 249));

        panel2.add(labelJobID);
        panel2.add(JobIDField);


        frame2.add(panel2);
        frame2.add(CarImagePanel2);

        // panel2.add(clientMessage);
        panel2.add(enterButton2);
        panel2.add(back);

        frame2.setVisible(true);
    }

//! ============================================================================================================================================================================

    // ! Nested class containing the method for button 2's functionality
    static class VehicleRegistrationPage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button2) {
                RegisterVehicleButton();

                HomeScreenFrame.dispose();
            }
        }
    }

    public static void RegisterVehicleButton() {

        JFrame RegisterVehicleFrame = new JFrame("Vehicle registration and owner login");
        RegisterVehicleFrame.getContentPane().setBackground(new Color(191, 161, 250));

        RegisterVehicleFrame.setSize(500, 500);
        RegisterVehicleFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JPanel RegisterVehiclePanel = new JPanel();
        RegisterVehiclePanel.setPreferredSize(new Dimension(200, 700));
        RegisterVehiclePanel.setBackground(new Color(191, 161, 250));

        JPanel CarImagePanel = new JPanel();
        CarImagePanel.setPreferredSize(new Dimension(200, 700));
        CarImagePanel.setBackground(new Color(191, 161, 250));

        JLabel labelOwnerID = new JLabel("Owner ID");
        JLabel labelFullName = new JLabel("Full Name");
        JLabel labelVMake = new JLabel("Vehicle Make");
        JLabel labelVModel = new JLabel("Vehicle Model");
        JLabel labelVYear = new JLabel("Vehicle Year");
        JLabel labelResTime = new JLabel("Residency Time (Hours)");
        JLabel CarLabel = new JLabel();

        CarLabel.setIcon(new ImageIcon("C:\\Users\\Luis\\CUS1166 GUI\\src\\Images\\Car.png"));

        // ! Enter Button initialization
        JButton enterButton = new JButton(new AbstractAction("Enter") {
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH: mm :ss");
                LocalDateTime now = LocalDateTime.now();
                String DateTimer = (dtf.format(now));
                System.out.println("Request Pending...");
                Owner.UserName = ownerID.getText();
                Owner.fullName = ownerFullname.getText();
                Owner.carModel = ownerCarModel.getText();
                Owner.carMake = ownerCarMake.getText();
                Owner.carYear = ownerCarYear.getText();
                Owner.carResidency = residencyTime.getText();


                ownerID.setText("");
                ownerFullname.setText("");
                ownerCarMake.setText("");
                ownerCarModel.setText("");
                ownerCarYear.setText("");
                residencyTime.setText("");
            }
        });

        // ! Back button initialization
        JButton backButton = new JButton(new AbstractAction("Back") {

            @Override
            public void actionPerformed(ActionEvent e) {
                HomeScreenFrame.setVisible(true);
                RegisterVehicleFrame.dispose();
            }
        });

        enterButton.setBackground(new Color(250, 249, 250));
        backButton.setBackground(new Color(250, 249, 250));

        ownerID = new JTextField();// textfield for ownerID
        ownerID.setPreferredSize(new Dimension(150, 20));

        ownerFullname = new JTextField();// textfield for fullname
        ownerFullname.setPreferredSize(new Dimension(150, 20));

        ownerCarMake = new JTextField();// textfield for vehicle make
        ownerCarMake.setPreferredSize(new Dimension(150, 20));

        ownerCarModel = new JTextField();// textfield for vehicle model
        ownerCarModel.setPreferredSize(new Dimension(150, 20));

        ownerCarYear = new JTextField();// textfield for vehicle year
        ownerCarYear.setPreferredSize(new Dimension(150, 20));

        residencyTime = new JTextField(); // textfield for residencyTime
        residencyTime.setPreferredSize(new Dimension(150, 20));

        // ! added each label to the panel created up top
        RegisterVehiclePanel.add(labelOwnerID);
        RegisterVehiclePanel.add(ownerID);

        RegisterVehiclePanel.add(labelFullName);
        RegisterVehiclePanel.add(ownerFullname);

        RegisterVehiclePanel.add(labelVMake);
        RegisterVehiclePanel.add(ownerCarMake);

        RegisterVehiclePanel.add(labelVModel);
        RegisterVehiclePanel.add(ownerCarModel);

        RegisterVehiclePanel.add(labelVYear);
        RegisterVehiclePanel.add(ownerCarYear);

        RegisterVehiclePanel.add(labelResTime);
        RegisterVehiclePanel.add(residencyTime);

        RegisterVehiclePanel.add(enterButton);
        RegisterVehiclePanel.add(backButton);

        RegisterVehicleFrame.add(RegisterVehiclePanel);
        RegisterVehicleFrame.add(CarImagePanel);
        CarImagePanel.add(CarLabel);

        RegisterVehicleFrame.setVisible(true);
    }

//=============================================================================================================================================

    static class vcControllerPage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button3) {
                controllerButton();

                HomeScreenFrame.dispose();
            }
        }
    }

    public static void controllerButton() {

        JFrame ControllerFrame = new JFrame("Admin login");
        ControllerFrame.getContentPane().setBackground(new Color(223, 208, 255));

        ControllerFrame.setSize(500, 500);
        ControllerFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JPanel ControllerPanel = new JPanel();
        ControllerPanel.setPreferredSize(new Dimension(200, 700));
        ControllerPanel.setBackground(new Color(216, 197, 255));

        JPanel CarImagePanel = new JPanel();
        CarImagePanel.setPreferredSize(new Dimension(200, 700));
        CarImagePanel.setBackground(new Color(217, 199, 255));

        JLabel labelUsername = new JLabel("Username");
        JLabel labelPassword = new JLabel("Password");

        JLabel CarLabel = new JLabel();

        CarLabel.setIcon(new ImageIcon("C:\\Users\\Luis\\CUS1166 GUI\\src\\Images\\Car.png"));

        // Compute Button
        //======================================================================================================================================

        loginButton = new JButton(new AbstractAction("Login") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userValue = controllerUsername.getText();
                String passValue = controllerPassword.getText();
                if (userValue.equals("Admin") && passValue.equals("Admin")) {
                    try {
                        ComputeButton();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    ControllerFrame.dispose();
                } else{
                    JOptionPane.showMessageDialog(ControllerFrame,"Login Error");
                }
            }


            public  void ComputeButton() throws IOException {
                ComputeFrame = new JFrame("Compution");
                ComputeFrame.getContentPane().setBackground(new Color(211, 193, 250));



                ComputeFrame.setSize(500, 500);
                ComputeFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

                ComputePanel = new JPanel();


                ComputeImagePanel = new JPanel();
                ComputeImagePanel2 = new JPanel();
                ComputeImagePanel3 = new JPanel();
                ComputeImagePanel4 = new JPanel();
                JLabel AdminGear = new JLabel();
                AdminGear.setIcon(new ImageIcon("C:\\Users\\Luis\\Downloads\\admin.png"));
                ComputeImagePanel2.add(AdminGear);
                ComputeImagePanel2.setBackground(new Color(191,161,250));
                // ComputeImagePanel2.setBorder(new EmptyBorder(20,0,10,0));
              //  ComputeImagePanel.setBorder(new EmptyBorder(20,0,10,0));
                ComputeImagePanel.setBackground(new Color(191, 161, 250));
                ComputeImagePanel3.setBackground(new Color(191,161,250));
                ComputeImagePanel4.setBackground(new Color(191,161,250));


                ComputePanel.setPreferredSize(new Dimension(400, 700));
                ComputePanel.setBackground(new Color(191, 161, 250));

                // recieves information from server
                HomeScreen.outputStream.writeUTF("Username: " + Client.UserName + " Full Name: " + Client.fullName + " Deadline: " + Client.deadLine + " Job ID: " + Client.JobIDString + " Job Duration: " +Client.duration +"\n");
                HomeScreen.outputStream.writeUTF("Username: " + Owner.UserName + " Full Name: " + Owner.fullName + " Car Make: " + Owner.carMake + " Car Model: " + Owner .carModel + " Car Reisdency: " + Owner.carResidency + Owner.carYear + "\n");


                JButton calculate = new JButton(new AbstractAction("Calculate") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            ComputeFrame.dispose();
                            textArea2 = new JTextArea();
                            textArea2.setFont(new Font("Arial",Font.BOLD,14));

                            ComputeImagePanel3.add(textArea2);
                            textArea2.setOpaque(false);
                            Controller.Calculate();
                            ComputeFrame.setVisible(true);

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }});

                JButton backButton3 = new JButton(new AbstractAction("Back") {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            new FileOutputStream("CompletionTime.txt",false).close();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        ControllerFrame.setVisible(true);
                        ComputeFrame.dispose();
                    }


                });
                REJECT = new JButton(new AbstractAction("Reject Client") {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource()==REJECT) {
                            System.out.println("Information rejected");
                            Server.serverOutput = "MessageReject";

                            try {
                                Server.serverSocket.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            try {
                                Client.REJECTCLIENT();


                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                        // AdminSelect = Server.Admin.getText();
                        // System.out.println(AdminSelect);
                    }


                });

                REJECTOWNER = new JButton(new AbstractAction("Reject Owner") {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource()==REJECTOWNER) {
                            System.out.println("Information rejected");
                            Server.serverOutput = "MessageReject";

                            try {
                                Server.serverSocket.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            try {
                                Owner.REJECTOWNER();


                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                        // AdminSelect = Server.Admin.getText();
                        // System.out.println(AdminSelect);
                    }


                });
                ACCEPT = new JButton((new AbstractAction("Accept Client") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource()==ACCEPT){
                            Job.Job1();

                        }
                        try {
                            System.out.println("Information accepted");
                            Server.serverOutput = "MessageAccepted";

                            Client.APPENDCLIENT(); //methods from client class
                            Client.data("INSERT INTO clientinformation "
                                    + "VALUES ('" + Client.UserName + "', '" + Client.fullName + "', '" + Client.duration + "', '" + Client.deadLine + "', '" + Client.JobIDString + "')");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    {
                    }}));
                ACCEPTOWNER = new JButton((new AbstractAction("Accept Owner") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource()==ACCEPTOWNER){
                            Job.Job1();

                        }
                        try {
                            System.out.println("Information accepted");
                            Server.serverOutput = "MessageAccepted";

                            Owner.APPENDOWNER();
                            Owner.ownerData("INSERT INTO ownerinformation "
                                    + "VALUES ('" + Owner.UserName + "', '" + Owner.fullName + "', '" + Owner.carMake + "', '" + Owner.carModel + "', '" + Owner.carYear + "', '" + Owner.carResidency + "')");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    {
                    }}));
                Refresh = new JButton((new AbstractAction("Refresh") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource()==Refresh){
                            try {
                                new FileOutputStream("CompletionTime.txt",false).close();
                                ComputeFrame.dispose();
                                ComputeButton();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }

                    }}));


                ACCEPT.setBackground(new Color(249,249,249));
                REJECT.setBackground(new Color(249,249,249));
                calculate.setBackground(new Color(250, 249, 249));
                backButton3.setBackground(new Color(250, 249, 249));
                JTextArea textArea = new JTextArea();

                // textArea.setPreferredSize(new Dimension(425,400));

                textArea.setLayout(new FlowLayout(FlowLayout.CENTER));
                textArea.setBounds(500,-100,425,400);
                textArea.setBackground(new Color(191,161,250));
                textArea.setFont(new Font("Arial",Font.BOLD,14));
                textArea.setEditable(false);


                try {
                    FileReader reader = new FileReader("JobList.txt");

                    textArea.read(reader, "JobList.txt");


                    textArea.setVisible(true);


                } catch (IOException e)   {

                    e.printStackTrace();
                }


                ComputePanel.add(calculate);
                ComputePanel.add(backButton3);
                ComputeImagePanel.add(ACCEPT);
                ComputeImagePanel.add(REJECT);
                ComputeImagePanel.add(ACCEPTOWNER);
                ComputeImagePanel.add(REJECTOWNER);

                ComputeImagePanel3.add(textArea);
                ComputeImagePanel2.add(Refresh);


                ComputeFrame.add(ComputeImagePanel2);
                ComputeFrame.add(ComputeImagePanel);
                ComputeFrame.add(ComputeImagePanel3);
                ComputeFrame.add(ComputeImagePanel4);

                ComputeFrame.add(ComputePanel);

                ComputeFrame.setLayout(new BoxLayout(ComputeFrame.getContentPane(), BoxLayout.PAGE_AXIS));
                ComputeFrame.setVisible(true);

            }
        });

        // continution of controller code
        //==============================================================================================================================================
        JButton backButton2 = new JButton(new AbstractAction("Back") {

            @Override
            public void actionPerformed(ActionEvent e) {
                HomeScreenFrame.setVisible(true);
                ControllerFrame.dispose();
            }
        });

        loginButton.setBackground(new Color(250, 249, 249));
        backButton2.setBackground(new Color(250, 249, 249));

        controllerUsername = new JTextField();// textfield for ownerID
        controllerUsername.setPreferredSize(new Dimension(150, 20));

        controllerPassword = new JPasswordField();// textfield for fullname
        controllerPassword.setPreferredSize(new Dimension(150, 20));

        residencyTime = new JTextField(); // textfield for residencyTime
        residencyTime.setPreferredSize(new Dimension(150, 20));

        // ! added each label to the panel created up top
        ControllerPanel.add(labelUsername);
        ControllerPanel.add(controllerUsername);

        ControllerPanel.add(labelPassword);
        ControllerPanel.add(controllerPassword);

        ControllerPanel.add(loginButton);
        ControllerPanel.add(backButton2);

        ControllerFrame.add(ControllerPanel);
        ControllerFrame.add(CarImagePanel);
        CarImagePanel.add(CarLabel);

        ControllerFrame.setVisible(true);

    }

}
