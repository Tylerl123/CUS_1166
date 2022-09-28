import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
  
  private JButton button;
  private JButton button2;
  private JFrame frame;
  private JPanel panel;
  private JLabel label;
  private JTextField textField;
  
  public MyFrame(){
	    frame = new JFrame("VCRTS Project");
	    frame.setSize(300,300);
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
  @Override 
  public void actionPerformed(ActionEvent e){
        if(e.getSource()==button) {
    	createFrame();
    }
  }
    public static void createFrame()
  { 
	  JFrame frame2 = new JFrame("Owner Login");
	  frame2.setSize(300,300);
	  frame2.setVisible(true);
	  
  }
}



