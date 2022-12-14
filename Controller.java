import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    static BufferedWriter bw;

    public static void Calculate() throws IOException {
        System.out.println("The Completion Times for the jobs in hours are:");

        ArrayList<String> JobList = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("Job.txt"))) {
            bw = new BufferedWriter(new FileWriter("CompletionTime.txt", true));
            //bw.append("Completion Time:" + "\n");


            String JobIndex;
            while ((JobIndex = br.readLine()) != null) {
                JobList.add(JobIndex);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        List<Integer> newList = new ArrayList<Integer>(JobList.size());
        for (String myInt : JobList) {                       // for each loops that goes through each String and converts into ainint
            newList.add(Integer.valueOf(myInt));
            Job.COMPLETION = 0;
            for (int i = 0; i < newList.size(); i++) {

                Job.COMPLETION += newList.get(i);
                //    HomeScreen.POPOO.setText(String.valueOf(Job.COMPLETION));
                //   HomeScreen.ComputePanel.add(HomeScreen.POPOO);

            }
            System.out.println(Job.COMPLETION);
            // bw.append("ID"+ Client.JobIDString);
                    bw.append("and Completion Time is at :" + Job.COMPLETION+ " hours" + "\n");

        } try {

            bw.close();
        } catch (IOException ex) {

        }
        try {
            FileReader reader = new FileReader("CompletionTime.txt");
            HomeScreen.textArea2.read(reader, "CompletionTime.txt");
        } catch (IOException e)   {

            e.printStackTrace();
        }
    }

}
