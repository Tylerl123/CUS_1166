import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;



public class  Job extends Main {
    public static int JobID;

    public Job() {

        Random random = new Random();
        JobID = random.nextInt(10000000) + 1;


        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Luis\\CUS1166 GUI\\Job.txt", true));

            bw.append("Job ID:" + JobID + "\n");

            bw.append("Job Duration:" + HomeScreen.clientJobDuration.getText() + "\n");
           

            bw.close();

        } catch (IOException ex) {

        }

        ArrayList<String> JobList = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Luis\\CUS1166 GUI\\Job.txt"))) {
            String JobIndex;

            while ((JobIndex = br.readLine()) != null) {
                JobList.add(JobIndex);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(JobList + "\n");
    }

}

