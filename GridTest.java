import java.awt.*;
import javax.swing.*;

public class GridTest extends JFrame {

  public static void main(String[] args) {
    int rows = 10;
    int cols = 10;
    GridTest gt = new GridTest(rows, cols);
    gt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gt.setSize(500,500);
    //gt.pack();
    gt.setVisible(true);
  }

  public GridTest(int rows, int cols) {
    super("Test");
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(rows, cols));
    JButton[][] arr = new JButton[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        arr[i][j] = new JButton("",new ImageIcon("black.jpg"));
        //button.setBounds(0,0,100,100);
        pane.add(arr[i][j]);
      }
    }
  }
}
