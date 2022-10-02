import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomeScreen extends JFrame implements ActionListener {
  
  private JButton button;
  private JButton button2;
  private static  JFrame HomeScreenFrame;  
  private JPanel HomeScreenPanel;
  
  public static JTextField clientUserName;
  public static JTextField clientPassword;
  public static JTextField clientFullName;
  public static JTextField clientJobDuration;
  public static JTextField clientDeadline;
  
  public static JTextField ownerUserName;
  public static JTextField ownerFullname;
  public static JTextField ownerCarMake;
  public static JTextField ownerCarModel;
  public static JTextField ownerCarYear;
  public static JTextField residencyTime;

  
  
    public HomeScreen() {
        HomeScreenFrame = new JFrame("VCRTS Project");  
        HomeScreenFrame.setSize(500,500);
        HomeScreenFrame.setVisible(true);
        HomeScreenPanel = new JPanel();
        HomeScreenPanel.setBackground(new Color(60, 116, 181));
        HomeScreenFrame.add(HomeScreenPanel); // This line has to be after declaring the HomeScreenPanel and setting it's color or else the home screen will be blank
        
        button = new JButton("Rent Vehicle Hardware"); //Client rents a vehicle
        button2 = new JButton("Register Vehicle"); //Owner registers a car
        HomeScreenPanel.add(button);
        HomeScreenPanel.add(button2);
        button.addActionListener(this);
        ActionListener ownerLogin = new addOwnerLogin();
        button2.addActionListener(ownerLogin);
    }

    
    // Action performed method that gives functionality to java "back button"
    @Override 
    public void actionPerformed(ActionEvent e) { // create new window for owner to login
            if(e.getSource()==button) {
            createClientButton();
            HomeScreenFrame.dispose();
        }
    }
    


        public static void createClientButton() {  // Beginning of createClientButton 
        
        JFrame frame2 = new JFrame("Client Login");
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.CYAN);
        JLabel label2 = new JLabel("Client ID");
        JLabel labelP = new JLabel("Password");
		JLabel labelFN = new JLabel("Full Name");
        JLabel labelTime = new JLabel("Job Duration");
        JLabel labelDeadline = new JLabel("Deadline");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH: mm :ss");
		LocalDateTime now = LocalDateTime.now();
		String DateTimer = (dtf.format(now));

        JButton enterButton2 = new JButton(new AbstractAction("Enter!") { //make back button to go to previous window

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter("clientInformation.txt",true));
                    bw.append("Client ID: " + clientUserName.getText() + "\n");
                    bw.append("Password:  " + clientPassword.getText() + "\n");
                    bw.append("Client Full Name:  " + clientFullName.getText() + "\n");
                    bw.append("Client Job Duration " + clientJobDuration.getText() + "\n");
                    bw.append("Client Deadline " + clientDeadline.getText() + "\n");
                    bw.append(DateTimer + "\n");

                    bw.close();


                }catch(IOException ex){

                }

            }
        });
        JButton back = new JButton(new AbstractAction("Back!") {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                  HomeScreenFrame.setVisible(true);
                  frame2.dispose();
                }
        });
          
        JTextField textField2 = new JTextField();//textfield for username
        textField2.setPreferredSize(new Dimension(450,40));
        textField2.setFont(new Font("Consolas",Font.PLAIN,15));
		
        JPasswordField passTextField = new JPasswordField();//textfield for password
        passTextField.setPreferredSize(new Dimension(450,40));
		
        JTextField textField3 = new JTextField();//textfield for full name
        textField3.setPreferredSize (new Dimension(450, 40));
        
        JTextField textField4 = new JTextField();//textfield for job duration
        textField4.setPreferredSize (new Dimension(450, 40));
        
        JTextField textField5 = new JTextField();//textfield for deadline
        textField5.setPreferredSize (new Dimension(450, 40));
		
		// labels added to the panel
        clientUserName = new JTextField();//textfield for username
        clientUserName.setPreferredSize(new Dimension(450,40));
        clientUserName.setFont(new Font("Consolas",Font.PLAIN,15));
		
        clientPassword = new JPasswordField();//textfield for password
        clientPassword.setPreferredSize(new Dimension(450,40));
		
        clientFullName = new JTextField();//textfield for full name
        clientFullName.setPreferredSize (new Dimension(450, 40));
        
        clientJobDuration = new JTextField();//textfield for job duration
        clientJobDuration.setPreferredSize (new Dimension(450, 40));
        
        clientDeadline = new JTextField();//textfield for deadline
        clientDeadline.setPreferredSize (new Dimension(450, 40));
		
		// labels added to the panel
        panel2.add(label2);
        panel2.add(clientUserName);
		
        panel2.add(labelP);
        panel2.add(clientPassword);
		
        panel2.add(labelFN);
        panel2.add(clientFullName);
		
        panel2.add(labelTime);
        panel2.add(clientJobDuration);
        
        panel2.add(labelDeadline);
        panel2.add(clientDeadline);
		
        panel2.add(enterButton2);
        panel2.add(back);
        frame2.add(panel2);
        frame2.setSize(500,500);
        frame2.setVisible(true);	  
        } 
	
	
	

class addOwnerLogin implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		      if(e.getSource()==button2) {
		        createOwnerButton();
		        HomeScreenFrame.dispose();
		  }
		}
	}

public static void createOwnerButton() { //Beginning creating the owner button with username

		JFrame frame3 = new JFrame("Owner Login");
		JPanel panel3 = new JPanel();
		JLabel label3 = new JLabel("Owner ID");
		panel3.setBackground(Color.PINK);

		
		JLabel labelFN = new JLabel("Full Name");	//Information collected from vehicle owner
		JLabel labelVMake= new JLabel("Vehicle Make");
		JLabel labelVModel = new JLabel("Vehicle Model");
		JLabel labelVYear= new JLabel("Vehicle Year");
		 JLabel labelResTime = new JLabel("Residency Time");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH: mm :ss");
		LocalDateTime now = LocalDateTime.now();
		String DateTimer = (dtf.format(now));

		JButton enterButton = new JButton(new AbstractAction("Enter!") { //make back button to go to previous window
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
		            BufferedWriter ownerLogin = new BufferedWriter(new FileWriter("OwnerInformation.txt",true));
		            ownerLogin.append("Owner ID: " + ownerUserName.getText() + "\n");
		            ownerLogin.append("Full Name:  " + ownerFullname.getText() + "\n");
		            ownerLogin.append("Car Make:  " + ownerCarMake.getText() + "\n");
		            ownerLogin.append("Car Model: " + ownerCarModel.getText() + "\n");
		            ownerLogin.append("Car Year: " + ownerCarYear.getText() + "\n");
			    ownerLogin.append("Residency Time:" + residencyTime.getText() + "\n");

		            ownerLogin.append(DateTimer + "\n");
		            ownerLogin.close();
		            
		            
		        }catch(IOException ex){
		        	
		        }

			}
		});
		JButton back = new JButton(new AbstractAction("Back!") { //make back button to go to previous window

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreenFrame.setVisible(true);
				frame3.dispose();
			
			}
		});
		
			ownerUserName = new JTextField();//textfield for username
			ownerUserName.setPreferredSize(new Dimension(450,40));
			ownerUserName.setFont(new Font("Consolas",Font.PLAIN,18));
		
       	 	ownerFullname = new JTextField();//textfield for fullname
        	ownerFullname.setPreferredSize (new Dimension(450, 40));
        
        	ownerCarMake = new JTextField();//textfield for vehicle make
        	ownerCarMake.setPreferredSize (new Dimension(450, 40));
        
        	ownerCarModel = new JTextField();//textfield for vehicle model
        	ownerCarModel.setPreferredSize (new Dimension(450, 40));
        
        	ownerCarYear = new JTextField();//textfield for vehicle year
       		ownerCarYear.setPreferredSize (new Dimension(450, 40));
	
		residencyTime = new JTextField(); //textfield for residencyTime
                residencyTime.setPreferredSize(new Dimension(450,40));
	
	//adding each label to the panel created up top
		panel3.add(label3);
		panel3.add(ownerUserName);
		
		panel3.add(labelFN);
		panel3.add(ownerFullname);
		
		panel3.add(labelVMake);
		panel3.add(ownerCarMake);
		
		panel3.add(labelVModel);
		panel3.add(ownerCarModel);
		
		panel3.add(labelVYear);
		panel3.add(ownerCarYear);
	
		panel3.add(labelResTime);
                panel3.add(residencyTime);
	
		panel3.add(enterButton);
		panel3.add(back);
		frame3.add(panel3);
		frame3.setSize(500,500);
		frame3.setVisible(true);
	}
 

//Save Data in a file

}