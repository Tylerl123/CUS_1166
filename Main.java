import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
public class Main {

public static String url = "jdbc:mysql://locaLhost:3306/vc3?useTimezone=true&serverTimezone=UTC";
public static String username = "root";
public static String password = "lgroot@618";
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    HomeScreen.main(args);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Server.main(args);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }
}

