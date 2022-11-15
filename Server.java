
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Server {


    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    public static JTextField Admin;

    static public File text;
    static Scanner keyInput;
    static String clientInput;
    static String serverOutput = "";


    public static void main(String[] args) throws IOException {

        clientInput = "";

        String response = HomeScreen.AdminSelect;
        Scanner input;


        try {
            boolean serverRunning = true;
            System.out.println("Server Online");
            System.out.println("Waiting for Response from Client");
            serverSocket = new ServerSocket(3000);
            socket = serverSocket.accept();
            System.out.println("User Connected");

            while (serverRunning) {
                System.out.println("Waiting for Input");

                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());

                clientInput = inputStream.readUTF();
                System.out.println("Input received");
                System.out.println(clientInput.toString());

                System.out.println("Would you like to save this message? Yes/No?");
                {


                }
            }
            // outputStream.writeUTF(serverOutput);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



