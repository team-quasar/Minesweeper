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
  private JTextArea chat, event;
  private JTextField tPortNumber, tHostIP;
  //server constructor
  public Server(int port){
    //init all vars
    super("Server");
    this.port = port;
    sdf = new SimpleDateFormat("HH:mm:ss");
    al = new ArrayList<ClientThread>();
    server = null;
    try{
      InetAddress ip = InetAddress.getLocalHost();
      hostIP = ip.getHostAddress();
    }catch(Exception e){
      System.out.println(e);
    }
    
    JPanel north = new JPanel();
    north.add(new JLabel("Port number: "));
    tPortNumber = new JTextField("  " + port);
    north.add(tPortNumber);
    north.add(new JLabel("Host IPv4: "));
    tHostIP = new JTextField(" " + hostIP);
    tHostIP.setEditable(false);
    north.add(tHostIP);
    // to stop or start the server, we start with "Start"
    stopStartHost = new JButton("Start");
    stopStartHost.addActionListener(this);
    north.add(stopStartHost);
    startGame = new JButton("Start Game");
    startGame.setEnabled(false);
    north.add(startGame);
    add(north, BorderLayout.NORTH);
    JPanel center = new JPanel(new GridLayout(2,1));
    chat = new JTextArea(80,80);
    chat.setEditable(false);
    center.add(new JScrollPane(chat));
    event = new JTextArea(80,80);
    event.setEditable(false);
    center.add(new JScrollPane(event)); 
    add(center);
    
    addWindowListener(this);
    setSize(400, 600);
    setVisible(true);
  }
  //main method to start server
  public static void main(String[] args){
    //starts server on specified port number 
    new Server(1500);
  }
  //start method
  public void start(){
    //create server socket and wait for connection reqs
    //uses boolean to establish infinite while loop
    keepGoing = true;
    try{
      ServerSocket sSocket = new ServerSocket(port);
      while(keepGoing){
        System.out.println("Server is accepting clients on this port: " + port + ".");
        Socket socket = sSocket.accept();
        if(!keepGoing)break;
        ClientThread t = new ClientThread(socket);
        al.add(t);
        t.start();
      }
      try{
        for(int i = 0; i < al.size(); i++){
          ClientThread ct = al.get(i);
          try{
            ct.sInput.close();
            ct.sOutput.close();
            ct.socket.close();
          }catch(IOException ioe){
            System.out.println(ioe);
          }
        }
      }catch(Exception e){
        System.out.println(e);
      }
    }catch(IOException e){
      System.out.println(e);
    }
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
