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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;


public class HomeScreen extends JFrame implements ActionListener {

    private JButton button1;
    private JButton button2;
    private static  JFrame HomeScreenFrame;
    private JPanel HomeScreenPanel;

    public static JTextField clientUserName;
    public static JTextField clientPassword;
    public static JTextField clientFullName;
    public static JTextField clientJobDuration;
    public static JTextField clientDeadline;
    public static int JobID;

    public static JTextField ownerID;
    public static JTextField ownerFullname;
    public static JTextField ownerCarMake;
    public static JTextField ownerCarModel;
    public static JTextField ownerCarYear;
    public static JTextField residencyTime;

    public static JLabel TimeLabel;
    public static SimpleDateFormat TimeFormatter;
    public static String Time;

    static JButton enterButton2;


    public HomeScreen() {
        HomeScreenFrame = new JFrame("VCRTS Project");
        HomeScreenFrame.setSize(500,500);
        HomeScreenPanel = new JPanel();


        HomeScreenPanel.setBackground(new Color(170, 128, 250));


        ImageIcon favicon = new ImageIcon("Images/MotherBoardIcon.png");

        HomeScreenFrame.setIconImage(favicon.getImage());
        TimeLabel = new JLabel();
        TimeFormatter = new SimpleDateFormat("hh:mm:ss a");
        Time = TimeFormatter.format(new Date());
        TimeLabel.setText(Time);
        button1 = new JButton("Client Registration"); //Client rents a vehicle
        button2 = new JButton("Vehicle Registration"); //Owner registers a car
        button1.setBackground(new Color(217, 174, 89));
        button2.setBackground(new Color(217, 174, 89));
        HomeScreenPanel.add(button1);
        HomeScreenPanel.add(button2);
        // keep these two lines of codes below add button
        HomeScreenFrame.add(HomeScreenPanel);
        // This line has to be after declaring the HomeScreenPanel and setting it's color to show that the object has been defined before it is added or else the home screen will be blank

        HomeScreenFrame.setVisible(true);

        button1.addActionListener(this); // This line is helping this class implementing the action listener

        ActionListener ownerLogin = new VehicleRegistrationPage(); // For the 2nd button we had to make a 2nd class for the action listener to make it functional
        button2.addActionListener(ownerLogin);
    }


    // Action performed method that gives functionality to java "back button"
    @Override
    public void actionPerformed(ActionEvent e) { // create new window for owner to login
        if(e.getSource()==button1) {
            createClientButton();
            HomeScreenFrame.dispose();
        }
    }


    public static void createClientButton() {  // Beginning of createClientButton

        JFrame frame2 = new JFrame("Client Login");

        frame2.getContentPane().setBackground(new Color(191, 161, 250));
        frame2.setBackground(new Color(170, 128, 252));

        frame2.setSize(500,500);
        frame2.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        JPanel panel2 = new JPanel();
        frame2.add(panel2);

        panel2.setPreferredSize(new Dimension(200,700));
        panel2.setBackground(new Color(191,161 , 250));

        JPanel CarImagePanel2 = new JPanel(); //? made panel to hold car image label
        CarImagePanel2.setPreferredSize(new Dimension(200,700));
        CarImagePanel2.setBackground(new Color(191,161,250));

        JLabel label2 = new JLabel("Client ID");
        JLabel labelP = new JLabel("Password");
        JLabel labelFN = new JLabel("Full Name");
        JLabel labelTime = new JLabel("Job Duration (Hours)");
        JLabel labelDeadline = new JLabel("Deadline (Hours)");
        JLabel CarLabel2 = new JLabel();
        CarLabel2.setIcon(new ImageIcon("Images/tablet.png"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH: mm :ss");
        LocalDateTime now = LocalDateTime.now();
        String DateTimer = (dtf.format(now));

        enterButton2 = new JButton(new AbstractAction("Enter!") { //make back button to go to previous window
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == enterButton2)
                    panel2.add(TimeLabel);
                frame2.setVisible(true);

                try{

                    BufferedWriter bw = new BufferedWriter(new FileWriter("clientInformation.txt",true));
                    bw.append("Client ID: " + clientUserName.getText() + "\n");
                    bw.append("Password:  " + clientPassword.getText() + "\n");
                    bw.append("Client Full Name:  " + clientFullName.getText() + "\n");
                    bw.append("Client Job Duration " + clientJobDuration.getText() + "  hours " + "\n");
                    bw.append("Client Deadline " + clientDeadline.getText() + " hours " + "\n");
                    bw.append("Job ID:" + JobID + "\n");
                    bw.append(DateTimer + "\n");

                    bw.close();

                }catch(IOException ex){

                }

            }
        });
        JButton back = new JButton(new AbstractAction("Back!") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                HomeScreenFrame.setVisible(true);
                frame2.dispose();
            }
        });
        // labels added to the panel
        clientUserName = new JTextField();//textfield for username
        clientUserName.setPreferredSize(new Dimension(150,20));
        clientUserName.setFont(new Font("Consolas",Font.PLAIN,15));

        clientPassword = new JPasswordField();//textfield for password
        clientPassword.setPreferredSize(new Dimension(150,20));

        clientFullName = new JTextField();//textfield for full name
        clientFullName.setPreferredSize (new Dimension(150, 20));

        clientJobDuration = new JTextField();//textfield for job duration
        clientJobDuration.setPreferredSize (new Dimension(150, 20));

        clientDeadline = new JTextField();//textfield for deadline
        clientDeadline.setPreferredSize (new Dimension(150, 20));

        Random random = new Random();
        JobID = random.nextInt(10000000)+1;
        panel2.add(enterButton2);
        panel2.add(back);

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
        enterButton2.setBackground(new Color(217, 174, 89));
        back.setBackground(new Color(217, 174, 89));

        frame2.add(CarImagePanel2);


        panel2.add(enterButton2);
        panel2.add(back);

        frame2.setVisible(true);
    }




//! ============================================================================================================================================================================



    //! Nested class containing the method for button 2's functionality
    class VehicleRegistrationPage implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button2) {
                RegisterVehicleButton();

                HomeScreenFrame.dispose();
            }
        }
    }


    public static void RegisterVehicleButton() {

        JFrame RegisterVehicleFrame = new JFrame("Vehicle registration and owner login");
        RegisterVehicleFrame.getContentPane().setBackground(new Color(191, 161, 250));

        RegisterVehicleFrame.setSize(500,500);
        RegisterVehicleFrame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        JPanel RegisterVehiclePanel = new JPanel();
        RegisterVehiclePanel.setPreferredSize(new Dimension(200,700));
        RegisterVehiclePanel.setBackground(new Color(191,161 , 250));


        JPanel CarImagePanel = new JPanel(); 
        CarImagePanel.setPreferredSize(new Dimension(200,700));
        CarImagePanel.setBackground(new Color(191,161,250));


        JLabel labelOwnerID = new JLabel("Owner ID");
        JLabel labelFullName = new JLabel("Full Name");
        JLabel labelVMake= new JLabel("Vehicle Make");
        JLabel labelVModel = new JLabel("Vehicle Model");
        JLabel labelVYear= new JLabel("Vehicle Year");
        JLabel labelResTime = new JLabel("Residency Time (Hours)");
        JLabel CarLabel = new JLabel();

        CarLabel.setIcon(new ImageIcon("Images/Car.png"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH: mm :ss");
        LocalDateTime now = LocalDateTime.now();
        String DateTimer = (dtf.format(now));


        //! Enter Button initialization
        JButton enterButton = new JButton(new AbstractAction("Enter") {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BufferedWriter ownerLogin = new BufferedWriter(new FileWriter("OwnerInformation.txt",true));
                    ownerLogin.append("Owner ID: " + ownerID.getText() + "\n");
                    ownerLogin.append("Full Name:  " + ownerFullname.getText() + "\n");
                    ownerLogin.append("Car Make:  " + ownerCarMake.getText() + "\n");
                    ownerLogin.append("Car Model: " + ownerCarModel.getText() + "\n");
                    ownerLogin.append("Car Year: " + ownerCarYear.getText() + "\n");
                    ownerLogin.append("Residency Time:" + residencyTime.getText() + " hours " + "\n");

                    ownerLogin.append(DateTimer + "\n");
                    ownerLogin.close();

                }catch(IOException ex){}
            }
        });


        //! Back button initialization
        JButton backButton = new JButton(new AbstractAction("Back") {

            @Override
            public void actionPerformed(ActionEvent e) {
                HomeScreenFrame.setVisible(true);
                RegisterVehicleFrame.dispose();
            }
        });

        enterButton.setBackground(new Color(217, 174, 89));
        backButton.setBackground(new Color(217, 174, 89));

        ownerID = new JTextField();//textfield for ownerID
        ownerID.setPreferredSize(new Dimension(150,20));

        ownerFullname = new JTextField();//textfield for fullname
        ownerFullname.setPreferredSize (new Dimension(150, 20));

        ownerCarMake = new JTextField();//textfield for vehicle make
        ownerCarMake.setPreferredSize (new Dimension(150, 20));

        ownerCarModel = new JTextField();//textfield for vehicle model
        ownerCarModel.setPreferredSize (new Dimension(150, 20));

        ownerCarYear = new JTextField();//textfield for vehicle year
        ownerCarYear.setPreferredSize (new Dimension(150, 20));

        residencyTime = new JTextField(); //textfield for residencyTime
        residencyTime.setPreferredSize(new Dimension(150,20));


        //! added each label to the panel created up top
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
}

