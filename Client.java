import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Client extends Main {

        public static String fullName;
        public static String deadLine;
        public static String JobIDString;
        public static String UserName;

        public static String duration;


        public static void APPENDCLIENT() throws IOException {

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH: mm :ss");
                LocalDateTime now = LocalDateTime.now();
                String DateTimer = (dtf.format(now));
                System.out.println("Completed Successfully");


                try {

                        BufferedWriter bw = new BufferedWriter(new FileWriter("clientInformation.txt", true));
                     bw.append(Server.clientInput.toString());


                      //  bw.append("Client ID: " + HomeScreen.clientUserName.getText() + "\n");
                      //  bw.append("Password:  " + HomeScreen.clientPassword.getText() + "\n");
                      //  bw.append("Client Full Name:  " + HomeScreen.clientFullName.getText() + "\n");

                        //  bw.append("Client Job Duration " + clientJobDuration.getText() + "  hours " + "\n");


                      //  bw.append("Client Deadline " + HomeScreen.clientDeadline.getText() + "\n");
                       // bw.append("Job ID:" + HomeScreen.JobIDField.getText() + " finishes at Duration:" + HomeScreen.clientJobDuration.getText() + "\n");
                       // bw.append(DateTimer + "\n");

                        bw.close();
                        JOptionPane.showMessageDialog(null, "The request has been accepted", "Client Login", JOptionPane.PLAIN_MESSAGE);
                        //JFrame SusWindow = new JFrame("ACCEPTED");
                       // SusWindow.setSize(450,400);
                       // SusWindow.setLayout(new BoxLayout(SusWindow.getContentPane(),BoxLayout.Y_AXIS));
                       // SusWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        //SusWindow.setVisible(true);
                } catch (IOException ex) {

                }

               // HomeScreen.clientUserName.setText("");
               // HomeScreen.clientPassword.setText("");
               // HomeScreen.clientFullName.setText("");
               // HomeScreen.JobIDField.setText("");
               // HomeScreen.clientJobDuration.setText("");


               // HomeScreen.clientDeadline.setText("");



        }

        public static void REJECTCLIENT() throws IOException {
                System.out.println("Rejected");

        }

}






