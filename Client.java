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
  private JButton login, logout, whoIsIn;
  private JTextArea me;
  private boolean connected;
  private Client client;
  private int defaultPort;
  private String defaultHost;
  public Client(String server, int port){
    
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