import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class Client extends JFrame implements ActionListener{
  private ObjectInputStream sIn;
  private ObjectOutputStream sOut;
  private Socket socket;
  private String server, username;
  private int port;
  private JLabel label;
  private JTextField textF, textFServer, textFPort;
  private JButton login, logout;
  private JTextArea me;
  private boolean connected;
  private Client client;
  private int defaultPort;
  private String defaultHost;
  public Client(String server, int port){
    super("Chat Client");
    defaultPort = port;
    defaultHost = server;
    JPanel north = new JPanel(new GridLayout(3,1));
    JPanel spPanel = new JPanel(new GridLayout(1,5,1,3));
    textFServer = new JTextField(server);
    textFPort = new JTextField("" + port);
    textFServer.setHorizontalAlignment(SwingConstants.RIGHT);
    textFPort.setHorizontalAlignment(SwingConstants.RIGHT);
    spPanel.add(new JLabel("Server Address: "));
    spPanel.add(textFServer);
    spPanel.add(new JLabel("Port Number: "));
    spPanel.add(textFPort);
    north.add(spPanel);
    label = new JLabel("Enter your username: ", SwingConstants.CENTER);
    north.add(label);
    textF = new JTextField("Anonymous");
    textF.setBackground(Color.WHITE);
    north.add(textF);
    add(north, BorderLayout.NORTH);
    login = new JButton("Login");
    login.addActionListener(this);
    logout = new JButton("Logout");
    logout.addActionListener(this);
    logout.setEnabled(false);
    //In center put the gui panels
    JPanel south = new JPanel();
    south.add(login);
    south.add(logout);
    add(south, BorderLayout.SOUTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(1280, 720);
    setVisible(true);
    textF.requestFocus();    
  }
  public static void main(String[] args){
    new Client("localhost",1500);
  }
  public void onConnectFailure(){
    
  }
  public void actionPerformed(ActionEvent e){
    
  }
  public boolean start(){
    return true;//on success
  }
  private void display(){
    
  }
  private void disconnect(){
    
  }
  class ListenFromServer extends Thread{
    public void run(){
      
    }
  }
}
