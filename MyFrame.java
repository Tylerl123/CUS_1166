import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
  
  JButton button;
  JButton button2;
  JFrame frame;
  JPanel panel;
   
 JTextField textField;
  
  public MyFrame(){
	    frame = new JFrame();
	    frame.setSize(300,300);
	    frame.setVisible(true);
	    panel = new JPanel();
	    frame.add(panel);
	    button = new JButton("Owner");
	    button2 = new JButton("User");
	    panel.add(button);
	    panel.add(button2);
	    button.addActionListener(this);
	    

  
}
  @Override 
  public void actionPerformed(ActionEvent e){
    
  }
  
}



