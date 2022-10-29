import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;



public class  Job extends Main {
    public static int JobID;
    static int INTCOMPLETION;
    static String JAB;

    public Job() {

        Random random = new Random();
        JobID = random.nextInt(10000000) + 1;


        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Luis\\CUS1166 GUI\\Job.txt", true));

            //bw.append("Job ID:" + JobID + "\n");

           bw.append(HomeScreen.clientJobDuration.getText() + "\n");

            JAB = HomeScreen.clientJobDuration.getText();
            INTCOMPLETION = Integer.parseInt(JAB);


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
        List<Integer> newList = new ArrayList<Integer>(JobList.size());
        for (String myInt : JobList) {
            newList.add(Integer.valueOf(myInt));
            int COMPLETION = 0;
            for (int i = 0; i < newList.size(); i++) {

                COMPLETION += newList.get(i);


            }
            System.out.println(COMPLETION);
        } try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Luis\\CUS1166 GUI\\Job.txt", true));

            //bw.append("Job ID:" + JobID + "\n");



            bw.close();

        } catch (IOException ex) {

        }
    }
