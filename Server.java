import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.io.*;
import java.net.*;
import java.util.*;
/*
 * Server class 
 * Run this program to start the GUI that will allow the server to be hosted
 * This class will handle all server side issues
 */
public class Server extends JFrame implements ActionListener, WindowListener{
  //Normal fields
  private static int uniqID;
  private ArrayList<ClientThread> al;
  private SimpleDateFormat sdf;
  private int port;
  private boolean keepGoing;
  private String hostIP;
  private Server server;
  //GUI fields
  private static final long serialVersionUID = 1L;
  private JButton stopStartHost, startGame;
  private JButton chat, event;
  private JTextField tPortNumber, tHostIP;
  //server constructor
  public Server(int port){
    //init all vars
  }
  //main method to start server
  public static void main(String[] args){
    //starts server on specified port number 
    
  }
  //start method
  public void start(){
    //create server socket and wait for connection reqs
    //uses boolean to establish infinite while loop
    
  }
  protected void stop(){
    //turn boolean false
    //disable server
  }
  private synchronized void display(){
    //This will attempt to display the minesweeper screens to
    //the clients as they appear
  }
  synchronized void rmclient(int id){
    //takes id as arg
    //when a client leaves, the client with the id has to be removed
    //from the client thread arraylist
    //this will scan the arraylist until we find id
  }
  
  //actionlistener method
  public void actionPerformed(ActionEvent e){
    //depending on which button gets clicked
    //If the start server button gets clicked, start it
    //If the stop server button gets clicked, end it
    //If the start game button gets clicked, run the game for all
    //connected clients and records time until end of match
  }
  //windowlistener methods
  public void windowClosing(WindowEvent e){
    //if the user presses the x button and the server is running
    //close the server and exit the app
  }
  public void windowClosed(WindowEvent e) {}
  public void windowOpened(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowActivated(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}
  //inner class client thread
  class ClientThread extends Thread{
    Socket socket;
    ObjectInputStream sInput;
    ObjectOutputStream sOutput;
    int id;
    String username;
    //constructor
    ClientThread(Socket socket){
      //init vars
      //make sure each id is unique based on the uniqID
      
    }
    public void run(){
      //this will run forever until logout
      //this will handle all of the server inputs and displays for each Client Thread
      
    }
    public void close(){
      //closes connection
    }
    private boolean write(){
      //send displays to output stream
      //returns false to check if the client is not connected and removes it if it isn't
      //returns true otherwise
      return true;
    }
  } 
  //inner class server thread
  class ServerRunner extends Thread{
    public void run(){
      //will start the server
    }
    
  }
}