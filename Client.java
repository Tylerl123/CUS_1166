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

                new Job();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH: mm :ss");
                LocalDateTime now = LocalDateTime.now();
                String DateTimer = (dtf.format(now));
                System.out.println("Completed Successfully");
                try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter("clientInformation.txt", true));
                        if (Client.UserName==null);

                                else{
                                bw.append(Server.clientInput.toString() +"\n");
                                bw.append(DateTimer + "\n");
                                bw.close();
                                JOptionPane.showMessageDialog(null, "The request has been accepted for:  " + Client.UserName + " Job ID " + Client.JobIDString, "Client Login", JOptionPane.PLAIN_MESSAGE);
                        }
                } catch (IOException ex) {
                }
        }
        public static void REJECTCLIENT() throws IOException {
                if (Client.UserName==null);

                else {
                        System.out.println("Rejected");
                        JOptionPane.showMessageDialog(null, "The request sent by Client:  " + Client.UserName + " Full Name: " + Client.fullName + " was rejected by Admin", " Client Login ", JOptionPane.PLAIN_MESSAGE);
                }
        }

}





