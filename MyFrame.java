import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MyFrame extends JFrame implements ActionListener {
  
  private JButton button;
  private JButton button2;
  private static JFrame frame;  
  private JPanel panel;
  private JLabel label;
  private JTextField textField;
  
  public MyFrame(){
	    frame = new JFrame("VCRTS Project");  //This creates the initial frame with the owner and user button
	    frame.setSize(500,500);
	    frame.setVisible(true);
	    panel = new JPanel();
	    frame.add(panel);
	    button = new JButton("Rent a vehicle");
	    button2 = new JButton("Register a Vehicle");
	    panel.add(button);
	    panel.add(button2);
	    button.addActionListener(this);
	    ActionListener userLogin = new addUserLogin();
	    button2.addActionListener(userLogin);
	    
		
	  
	textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Courier New",Font.PLAIN,15));	//This is the text field that goes along with the initial frame
        panel.add(textField);
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
        JButton back = new JButton(new AbstractAction("Back!") {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                  frame.setVisible(true);
                  frame2.dispose();
                }
        });
          
        JTextField textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(400,40));
        textField2.setFont(new Font("Consolas",Font.PLAIN,15));
		
        JPasswordField passTextField = new JPasswordField();
        passTextField.setPreferredSize(new Dimension(400,40));
		
		
        panel2.add(label2);
        panel2.add(textField2);
		
	panel2.add(labelP);
        panel2.add(passTextField);
		
        panel2.add(back);
        frame2.add(panel2);
        frame2.setSize(500,500);
        frame2.setVisible(true);	  
        } // Ending of createClientButton 

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
		@SuppressWarnings("serial")
		JButton back = new JButton(new AbstractAction("Back!") { //make back button to go to previous window

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(true);
				frame3.dispose();
			
			}
		});

		JTextField textField3 = new JTextField();
		textField3.setPreferredSize(new Dimension(250,40));
		textField3.setFont(new Font("Consolas",Font.PLAIN,15));
		panel3.add(label3);
		panel3.add(textField3);
		panel3.add(back);
		frame3.add(panel3);
		frame3.setSize(500,500);
		frame3.setVisible(true);
	}
        
}


//Save Data in a file
public static void saveFile(String data) throws IOException
{
String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new java.util.Date());
BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
writer.write(data);
writer.close();
System.out.println("File Saved");

}
}










