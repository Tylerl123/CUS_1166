
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

            BufferedWriter bw = new BufferedWriter(new FileWriter("Job.txt", true));
            bw.append("Job ID:" + JobID + "\n");

            bw.close();

        } catch (IOException ex) {

        }
        ArrayList<String> JobList = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("clientInformation.txt"))) {

            String CurrentLine;

            while ((CurrentLine = br.readLine()) != null) {
                JobList.add(CurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(JobList + "\n");
    }

}
