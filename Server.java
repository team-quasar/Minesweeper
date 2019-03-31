import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
  private static String hostIP;
  private Helper server;
  //GUI fields
  private static final long serialVersionUID = 1L;
  private static JButton stopStartHost, startGame;
  private static JTextArea event;
  private static JTextField tPortNumber, tHostIP;
  //server constructor
  public Server(int port){
    //init all vars
    super("Server");
    server = null;
    JPanel north = new JPanel();
    north.add(new JLabel("Port number: "));
    tPortNumber = new JTextField("  " + port);
    north.add(tPortNumber);
    north.add(new JLabel("Host IPv4: "));
    try{
        InetAddress ip = InetAddress.getLocalHost();
        hostIP = ip.getHostAddress();
      }catch(Exception e){
        System.out.println(e);
      }
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
    JPanel center = new JPanel(new GridLayout(1,1));
    event = new JTextArea(80,80);
    event.setEditable(false);
    event.append("> Log:\n");event.setCaretPosition(event.getText().length()-1);
    center.add(new JScrollPane(event)); 
    add(center);
    addWindowListener(this);
    setSize(700, 700);
    setVisible(true);
  }
  //main method to start server
  public static void main(String[] args){
    //starts server on specified port number 
    new Server(1500);
  }
  private synchronized void display(){
    //This will attempt to display the minesweeper screens to
    //the clients as they appear
    
    //Implement after GUI of client is figured out
  }
  //actionlistener method
  public void actionPerformed(ActionEvent e){
    //depending on which button gets clicked
    //If the start server button gets clicked, start it
    //If the stop server button gets clicked, end it
    //If the start game button gets clicked, run the game for all
    //connected clients and records time until end of match
    Object o = e.getSource();
    if(o == stopStartHost && server != null){
      server.stop();
      server = null;
      tPortNumber.setEditable(true);
      stopStartHost.setText("Start");
      startGame.setEnabled(false);
      return;
    }
    //cannot reach this statement if server is running because it would go through the
    //above if statement. I'm clarifying because it is confusing
    if(o == stopStartHost){
      int port;
      try{
        port = Integer.parseInt(tPortNumber.getText().trim());
      }catch(Exception ee){
        event.append("> Invalid port number!\n");event.setCaretPosition(event.getText().length()-1);
        return;
      }
      server = new Helper(port);
      new ServerRunner().start();
      stopStartHost.setText("Stop");
      tPortNumber.setEditable(false);
      startGame.setEnabled(true);
      return;
    }
    if(o == startGame){
      //start the minesweeper game on all clients
    }
  }
  //windowlistener methods
  public void windowClosing(WindowEvent e){
    //if the user presses the x button and the server is running
    //close the server and exit the app
    if(server != null){
      try{
        server.stop();
      }catch(Exception ee){}
      server = null;
    }
    dispose();
    System.exit(0);
  }
  public void windowClosed(WindowEvent e) {}
  public void windowOpened(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowActivated(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}
  //inner class server thread
  class ServerRunner extends Thread {
    public void run() {
      server.start();
      stopStartHost.setText("Start");
      tPortNumber.setEditable(true);
      event.append("> Server crashed!\n");
      event.setCaretPosition(event.getText().length()-1);
      server = null;
    }
  } 
  static class Helper{
    private static int uniqID;
    private ArrayList<ClientThread> al;
    private int port;
    private boolean keepGoing;

    public Helper(int port){
      this.port = port;
      al = new ArrayList<ClientThread>();
      
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
          sSocket.close();
          for(int i = 0; i < al.size(); i++){
            ClientThread ct = al.get(i);
            try{
              ct.sIn.close();
              ct.sOut.close();
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
      keepGoing = false;
      hostIP = "localhost";
      //looked around on the internet
      //this is the best thing I found for exiting
      //The server has to connect  to itself as a client
      //If you read this and find a better method, please tell me!
      try{
        InetAddress ip = InetAddress.getLocalHost();
        hostIP = ip.getHostAddress();
      }catch(Exception e){System.out.println(e);}
      try {
        new Socket(hostIP, port);
      }catch(Exception e){}
    }
    synchronized void rmclient(int id){
      //takes id as arg
      //when a client leaves, the client with the id has to be removed
      //from the client thread arraylist
      //this will scan the arraylist until we find id
      for(int i = 0; i < al.size(); i++){
        ClientThread client = al.get(i);
        //finds id -> removes id and then exits method
        if(client.id == id){
          al.remove(i);
          return;
        }
      }
    }
    //inner class client thread
    class ClientThread extends Thread{
      Socket socket;
      ObjectInputStream sIn;
      ObjectOutputStream sOut;
      Object input;
      int id;
      String username;
      //constructor
      ClientThread(Socket socket){
        //init vars
        //make sure each id is unique based on the uniqID
        id = uniqID++;
        this.socket = socket;
        event.append("> Thread attempting to create IO streams\n");
        event.setCaretPosition(event.getText().length()-1);
        try{
          sOut = new ObjectOutputStream(socket.getOutputStream());
          sIn = new ObjectInputStream(socket.getInputStream());
          username = (String) sIn.readObject();
          event.append("> " + username + " entered the fray!\n");
          event.setCaretPosition(event.getText().length()-1);
        }catch(IOException e){
          event.append("> Exception with initializing IOStreams: " + e + "\n");
          event.setCaretPosition(event.getText().length()-1);
          return;
        }
        catch(ClassNotFoundException e){}
      }
      public void run(){
        //this will run forever until logout
        //this will handle all of the server inputs and displays for each Client Thread
        boolean kG = true;
        while(kG){
          try{
            input = sIn.readObject();
          }
          catch(IOException e){
            //display error
            break;
          }
          catch(ClassNotFoundException ee){break;}
          //display based on input
          
        }
        rmclient(id);
        close();
      }
      public void close(){
        //closes connection
        try{if(sOut != null)sOut.close();}
        catch(Exception e){}
        try{if(sIn != null)sIn.close();}
        catch(Exception e){}
        try{if(socket != null)socket.close();}
        catch(Exception e){}
      }
      private boolean write(){
        //send displays to output stream
        //returns false to check if the client is not connected and removes it if it isn't
        //returns true otherwise
        return true;
      }
    } 
  }
}
