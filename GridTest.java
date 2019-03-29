import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GridTest extends JFrame {

  public static void main(String[] args) {
    int rows = 3;
    int cols = 3;
    GridTest gt = new GridTest(rows, cols);
    gt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gt.setSize(800,800);
    //gt.pack();
    gt.setVisible(true);
  }

  public GridTest(int rows, int cols) {
    super("Test");
    Container pane = getContentPane();
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(10,10));
    pane.setLayout(new GridLayout(rows, cols));
    JButton[][] arr = new JButton[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        JButton b = new JButton(new ImageIcon("black.png"));
        b.setSelectedIcon(new ImageIcon(""));
        b.setMnemonic(KeyEvent.VK_D);
        b.setActionCommand("disable");
        b.addActionListener(this);
        arr[i][j] = b;
        panel.add(arr[i][j]);
      }
    }
    for (int n = 0; n < 4; n++) {
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(10,10));
      for (int i = 0; i < 100; i++)
        p.add(new JLabel("O"));
      pane.add(p);
    }
     pane.add(panel);
     for (int n = 0; n < 4; n++) {
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(10,10));
      for (int i = 0; i < 100; i++)
        p.add(new JLabel("O"));
      pane.add(p);
    }
  }
  
  public void actionPerformed(ActionEvent e) {
    if ("disable".equals(e.getActionCommand())) {
      ActionEvent temp = e.getSource();
      temp.setEnabled(false);
    }
  }
}
