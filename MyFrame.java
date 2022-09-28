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



  

  @Override 
  public void actionPerformed(ActionEvent e){
        if(e.getSource()==button) {
    	createFrame();
	frame.dispose();
    }
  }
    public static void createFrame()
  { 
	JFrame frame2 = new JFrame("Owner Login");
	JPanel panel2 = new JPanel();
	JLabel label2 = new JLabel("Username");
	JTextField textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(250,40));
        textField2.setFont(new Font("Consolas",Font.PLAIN,15));
	panel2.add(label2);
        panel2.add(textField2);
	frame2.add(panel2);
	frame2.setSize(500,500);
	frame2.setVisible(true);	  
  }
}



