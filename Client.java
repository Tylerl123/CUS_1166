import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Client {


    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;

    public static void main(String[] args) {

        String messageIn = "Hello";
        String messageOut = "";
        Scanner keyInput;

        try {

            System.out.println("----------*** This is client side ***--------");
            System.out.println("client started!");
            //connect the client socket to server
            Socket socket = new Socket("localhost", 9806);


            //client reads a message from Server
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());


            // client reads a message from keyboard
            System.out.println("Enter a message you want to send to server side: ");
            keyInput = new Scanner(System.in);
            messageOut = keyInput.nextLine();
            // server sends the message to client
            outputStream.writeUTF(messageOut);


            while(!messageIn.equals("exit")) {
                messageIn = inputStream.readUTF();
                // client prints the message received from server to console
                System.out.println("message received from server: " + "\"" + messageIn + "\"");


                // ********************************************************
                // client reads a message from keyboard
                System.out.println("Enter a message you want to send to server side: ");
                keyInput = new Scanner(System.in);
                messageOut = keyInput.nextLine();
                // server sends the message to client
                outputStream.writeUTF(messageOut);

            }


        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}

