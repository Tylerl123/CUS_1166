import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;

    public static void main(String[] args) throws IOException {

        String messageIn = "";
        String messageOut = "";
        Scanner keyInput;

        try {

            System.out.println("----------$$$ This is server side $$$--------");
            System.out.println("wating for client to connect...");
            // creating the server
            serverSocket = new ServerSocket(9806);
            // sever accepts connection request from client
            socket = serverSocket.accept();
            System.out.println("client is connected!");
            System.out.println("go to client side and send me a message");

            // server reads a message message from client
            inputStream = new DataInputStream(socket.getInputStream());

            // server sends a message to client
            outputStream = new DataOutputStream(socket.getOutputStream());

            // as long as message is not exit keep reading and sending message to client
            while (!messageIn.equals("exit")) {

                // extract the message from client
                messageIn = inputStream.readUTF();
                // server prints the message received from client to console
                System.out.println("message received from client: " + "\"" + messageIn + "\"");

                // ********************************************************
                // server reads file
                File text = new File("clientInformation.txt");

                //Creating Scanner instance to read File in Java
                try {
                    keyInput = new Scanner(System.in);
                    //Reading each line of the file using Scanner class

                    while (keyInput.hasNextLine()) {
                        String line = keyInput.nextLine();
                        System.out.println("line "  + line);

                        System.out.println(text);

                        // System.out.println("Enter a message you want to send to client side: ");
                        //keyInput = new Scanner(System.in);
                        //messageOut = keyInput.nextLine();
                        // server sends the message to client
                        outputStream.writeUTF(messageOut);
                    }

                } catch (Exception ex) {

                    ex.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
