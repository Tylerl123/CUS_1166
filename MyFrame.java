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
    frame.setVisible(true);
    panel = new JPanel();

    button = new JButton("Owner");
    panel.add(button);
    button.addActionListener(this);
    
    
    
    
    
  
  
  
  
  
}
  @Override 
  public void actionPerformed(ActionEvent e){
    
  }
  
}



