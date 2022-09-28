import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
  
  private JButton button;
  private JButton button2;
  private static JFrame frame;
  private JPanel panel;
  private JLabel label;
  private JTextField textField;
  
  public MyFrame(){
	    frame = new JFrame("VCRTS Project");
	    frame.setSize(500,500);
	    frame.setVisible(true);
	    panel = new JPanel();
	    frame.add(panel);
	    button = new JButton("Owner");
	    button2 = new JButton("User");
	    panel.add(button);
	    panel.add(button2);
	    button.addActionListener(this);
	    
		
	  
	textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Courier New",Font.PLAIN,15));
        panel.add(textField);
  }




        // Action performed method that gives functionality to java "back button"
        @Override 
        public void actionPerformed(ActionEvent e) {
              if(e.getSource()==button) {
                createOwnerButton();
            frame.dispose();
          }
        }
        


        public static void createOwnerButton() {  // Beginning of createOwnerButton 
        
        JFrame frame2 = new JFrame("Owner Login");
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Username");
        JButton back = new JButton(new AbstractAction("Back!") {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                  // TODO Auto-generated method stub
                  frame.setVisible(true);
                  frame2.dispose();
                }
        });
          
        JTextField textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(250,40));
        textField2.setFont(new Font("Consolas",Font.PLAIN,15));
        panel2.add(label2);
        panel2.add(textField2);
        panel2.add(back);
        frame2.add(panel2);
        frame2.setSize(500,500);
        frame2.setVisible(true);	  
        } // Ending of createOwnerButton 

        
}



