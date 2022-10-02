import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MyFrame extends JFrame implements ActionListener {
  
  private JButton button;
  private JButton button2;
  private static  JFrame frame;  
  private JPanel panel;
  private JLabel label;
  private JTextField textField;
  
  public static JTextField ownerUserName;
  public static JTextField ownerFullname;
  public static JTextField ownerCarMake;
  public static JTextField ownerCarModel;
  public static JTextField ownerCarYear;
  
  
  public MyFrame(){
	    frame = new JFrame("VCRTS Project");  //This creates the initial frame with the owner and user button
	    frame.setSize(500,500);
	    frame.setVisible(true);
	    panel = new JPanel();
	    frame.add(panel);
	    button = new JButton("Rent Vehicle Hardware"); //Client rents a vehicle
	    button2 = new JButton("Register Vehicle"); //Owner registers a car
	    panel.add(button);
	    panel.add(button2);
	    button.addActionListener(this);
	    ActionListener ownerLogin = new addOwnerLogin();
	    button2.addActionListener(ownerLogin);
	    
		
  }
        // Action performed method that gives functionality to java "back button"
        @Override 
        public void actionPerformed(ActionEvent e) { // create new window for owner to login
              if(e.getSource()==button) {
                createClientButton();
                frame.dispose();
          }
        }
        


        public static void createClientButton() {  // Beginning of createClientButton 
        
        JFrame frame2 = new JFrame("Client Login");
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Username");
        JLabel labelP = new JLabel("Password");
		JLabel labelFN = new JLabel("Full Name");
        JLabel labelTime = new JLabel("Job Duration");
        JLabel labelDeadline = new JLabel("Deadline");
        JButton back = new JButton(new AbstractAction("Back!") {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                  frame.setVisible(true);
                  frame2.dispose();
                }
        });
          
        JTextField textField2 = new JTextField();//textfield for username
        textField2.setPreferredSize(new Dimension(400,40));
        textField2.setFont(new Font("Consolas",Font.PLAIN,15));
		
        JPasswordField passTextField = new JPasswordField();//textfield for password
        passTextField.setPreferredSize(new Dimension(400,40));
		
        JTextField textField3 = new JTextField();//textfield for full name
        textField3.setPreferredSize (new Dimension(400, 40));
        
        JTextField textField4 = new JTextField();//textfield for job duration
        textField4.setPreferredSize (new Dimension(400, 40));
        
        JTextField textField5 = new JTextField();//textfield for deadline
        textField5.setPreferredSize (new Dimension(400, 40));
		
		// labels added to the panel
        panel2.add(label2);
        panel2.add(textField2);
		
        panel2.add(labelP);
        panel2.add(passTextField);
		
        panel2.add(labelFN);
        panel2.add(textField3);
		
        panel2.add(labelTime);
        panel2.add(textField4);
        
        panel2.add(labelDeadline);
        panel2.add(textField5);
		
        panel2.add(back);
        frame2.add(panel2);
        frame2.setSize(500,500);
        frame2.setVisible(true);	  
        } 
	
	
	

class addOwnerLogin implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub // User login page
		      if(e.getSource()==button2) {
		        createOwnerButton();
		        frame.dispose();
		  }
		}
	}

public static void createOwnerButton() { //Beginning creating the owner button with username

		JFrame frame3 = new JFrame("Owner Login");
		JPanel panel3 = new JPanel();
		JLabel label3 = new JLabel("Username");

		
		JLabel labelFN = new JLabel("Full Name");	//Information collected from vehicle owner
		JLabel labelVMake= new JLabel("Vehicle Make");
		JLabel labelVModel = new JLabel("Vehicle Model");
		JLabel labelVYear= new JLabel("Vehicle Year");

		JButton enterButton = new JButton(new AbstractAction("Enter!") { //make back button to go to previous window

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
		            BufferedWriter bw = new BufferedWriter(new FileWriter("OwnerInformation.txt",true));
		            bw.append("UserName: " + ownerUserName.getText() + "\n");
		            bw.append("Full Name:  " + ownerFullname.getText() + "\n");
		            bw.append("Car Make:  " + ownerCarMake.getText() + "\n");
		            bw.append("Car Model: " + ownerCarModel.getText() + "\n");
		            bw.append("Car Year: " + ownerCarYear.getText() + "\n");
		          
		            bw.close();
		            
		            
		        }catch(IOException ex){
		        	
		        }
			
			}
		});
		JButton back = new JButton(new AbstractAction("Back!") { //make back button to go to previous window

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(true);
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
	
		panel3.add(enterButton);
		panel3.add(back);
		frame3.add(panel3);
		frame3.setSize(500,500);
		frame3.setVisible(true);
	}
 

//Save Data in a file

}

