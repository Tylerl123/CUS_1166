import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Owner extends Main {

    public static String fullName;
    public static String carMake;
    public static String carYear;
    public static String carResidency;
    public static String UserName;
    public static String carModel;



    public static void APPENDOWNER() throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH: mm :ss");
        LocalDateTime now = LocalDateTime.now();
        String DateTimer = (dtf.format(now));
        System.out.println("Completed Successfully");

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("OwnerInformation.txt", true));
            if (Owner.UserName == null);
            else {
                bw.append(Server.ownerInput.toString());
                bw.append(DateTimer + "\n");
                JOptionPane.showMessageDialog(null, "The request has been accepted for:  " + Owner.UserName +" Name:  " + Owner.fullName , "Owner Login", JOptionPane.PLAIN_MESSAGE);
                bw.close();
            }



        } catch (IOException ex) {

        }

    }
    public static void REJECTOWNER() throws IOException {
        if (Owner.UserName==null);

        else {

            System.out.println("Rejected");
            JOptionPane.showMessageDialog(null, "The request sent by Owner:  " + Owner.UserName + " Full Name: " + Owner.fullName + " was rejected by Admin", " Owner Login ", JOptionPane.PLAIN_MESSAGE);
        }
    }
    public static void ownerData(String command){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // name of driver
            Connection connection = DriverManager.getConnection(url, username, password); // pulls from main
            Statement statement= connection.createStatement(); // establishes the connection
            String sql = command;        // owner data method
            int rows = statement.executeUpdate(sql);
                System.out.println("SQL insert..");
        }
        catch(Exception d){
            System.out.println(d);
        }}

}
