import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;



public class  Job extends Main {
    public static int JobID;

    public static int COMPLETION;
    public Job() {

        Random random = new Random();
        JobID = random.nextInt(10000000) + 1;


        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Luis\\CUS1166 GUI\\Job.txt", true));

            //bw.append("Job ID:" + JobID + "\n");

            bw.append(HomeScreen.clientJobDuration.getText() + "\n");

            //JAB = HomeScreen.clientJobDuration.getText();
           // INTCOMPLETION = Integer.parseInt(JAB);


            bw.close();

            BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\Luis\\CUS1166 GUI\\JobList.txt", true));
            br.append(("Job ID:  " + HomeScreen.JobIDField.getText() +  "  Duration:  "  + HomeScreen.clientJobDuration.getText() + "\n"));

            br.close();

        } catch (IOException ex) {


        }



        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Luis\\CUS1166 GUI\\Job.txt", true));

            //bw.append("Job ID:" + JobID + "\n");



            bw.close();

        } catch (IOException ex) {

        }
    }
}
