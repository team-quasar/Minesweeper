import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUITest {
  public static void frameTest() {
    JFrame f=new JFrame("Button Example"); 
    //submit button
    JButton b=new JButton("Submit");
    b.setBounds(100,100,140, 40);    
    //enter name label
    JLabel label = new JLabel();  
    label.setText("Enter Name :");
    label.setBounds(10, 10, 100, 100);
    //empty label which will show event after button clicked
    JLabel label1 = new JLabel();
    label1.setBounds(10, 110, 200, 100);
    //textfield to enter name
    JTextField textfield= new JTextField();
    textfield.setBounds(110, 50, 130, 30);
    //add to frame
    f.add(label1);
    f.add(textfield);
    f.add(label);
    f.add(b);    
    f.setSize(300,300);    
    f.setLayout(null);    
    f.setVisible(true);    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
  
    //action listener
    b.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        label1.setText("Name has been submitted.");    
      }          
    });
  }
  
  public static void panelTest () {
    JPanel p = new JPanel();
    GridBagConstraints c = new GridBagConstraints();
    //GridBagConstraints c = new GridBagConstraints(0,0,10,10,null,null,null,null,null,null,null);
    for (int i = 0; i < 10; i++)
      p.add(new JButton(), c);
    //p.pack();
    p.setVisible(true);
  } 
  
  public static void frameCon () {
    JFrame p = new JFrame();
    GridBagConstraints c = new GridBagConstraints();
    //GridBagConstraints c = new GridBagConstraints(0,0,10,10,null,null,null,null,null,null,null);
    for (int i = 0; i < 10; i++)
      p.add(new JButton(), c);
    p.pack();
    p.setVisible(true);
  } 
  
  public static void main (String[] args) {
    //frameTest();
    //panelTest();
    frameCon();
  }
}
