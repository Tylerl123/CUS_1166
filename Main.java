import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {


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
