import java.util.Arrays;
public class Board{
  private int n;
  private int minecount;
  public Space[][] board;
  public Board(int rows, int mc){
    n = rows;
    minecount = mc;
    board = new Space[n][n];
    int r = 0;
    for (int i = 0; i < minecount; i++){
      r = (int)(Math.random() * (((n*n)-1) + 1));      
      board[r/n][r%n] = new MineSpace();
    }
    int adjacent;
    for (int j = 0; j < (n*n); j++){
      try{
        board[j/n][j%n].getType();
      }
      catch(Exception e){
        adjacent = getAdjacent(j/n,j%n);        
        board[j/n][j%n] = new NumberSpace(adjacent);
      }
    }
    
  }
  public int getAdjacent(int y, int x){
    int count = 0;
    //read at your own risk
    
            
      try{if(board[y-1][x-1].getType().equals("Mine")){count++;}}
      catch(Exception e){;}
      try{if(board[y-1][x].getType().equals("Mine")){count++;}}
      catch(Exception e){;}
      try{if(board[y-1][x+1].getType().equals("Mine")){count++;}}
      catch(Exception e){;}
      try{if(board[y][x-1].getType().equals("Mine")){count++;}}
      catch(Exception e){;}
      try{if(board[y][x+1].getType().equals("Mine")){count++;}}
      catch(Exception e){;}
      try{if(board[y+1][x-1].getType().equals("Mine")){count++;}}
      catch(Exception e){;}
      try{if(board[y+1][x].getType().equals("Mine")){count++;}}
      catch(Exception e){;}
      try{if(board[y+1][x+1].getType().equals("Mine")){count++;}}
      catch(Exception e){;}
      
    
  return count;
  }
  public void clickAdjacent(int y, int x){
//    System.out.println(toString());
    NumberSpace spacetest = (NumberSpace)board[y][x];
    if (spacetest.getNumber() == 0){
      board[y][x].click();
      try{if (!board[y-1][x-1].getClicked()){clickAdjacent(y-1,x-1);}}catch(Exception e){;}
    try{if (!board[y-1][x].getClicked()){clickAdjacent(y-1,x);}}catch(Exception e){;}
  try{if (!board[y-1][x+1].getClicked()){clickAdjacent(y-1,x+1);}}catch(Exception e){;}
  try{if (!board[y][x-1].getClicked()){clickAdjacent(y,x-1);}}catch(Exception e){;}
  try{if (!board[y][x+1].getClicked()){clickAdjacent(y,x+1);}}catch(Exception e){;}
  try{if (!board[y+1][x-1].getClicked()){clickAdjacent(y+1,x-1);}}catch(Exception e){;}
  try{if (!board[y+1][x].getClicked()){clickAdjacent(y+1,x);}}catch(Exception e){;}
  try{if (!board[y+1][x+1].getClicked()){clickAdjacent(y+1,x+1);}}catch(Exception e){;}
    }
    else{
      board[y][x].click();
    }
    
  }
  
  public void clickAdjacentExceptItsForNumbersThisTime(int y, int x){
//    System.out.println(toString());
    NumberSpace spacetest = (NumberSpace)board[y][x];
   
      board[y][x].click();
      try{if (!board[y-1][x-1].getClicked() && !board[y-1][x-1].getFlagged()){board[y-1][x-1].click();}}catch(Exception e){;}
    try{if (!board[y-1][x].getClicked() && !board[y-1][x-1].getFlagged()){board[y-1][x].click();}}catch(Exception e){;}
  try{if (!board[y-1][x+1].getClicked() && !board[y-1][x-1].getFlagged()){board[y-1][x+1].click();}}catch(Exception e){;}
  try{if (!board[y][x-1].getClicked() && !board[y-1][x-1].getFlagged()){board[y][x-1].click();}}catch(Exception e){;}
  try{if (!board[y][x+1].getClicked() && !board[y-1][x-1].getFlagged()){board[y][x+1].click();}}catch(Exception e){;}
  try{if (!board[y+1][x-1].getClicked() && !board[y-1][x-1].getFlagged()){board[y+1][x-1].click();}}catch(Exception e){;}
  try{if (!board[y+1][x].getClicked() && !board[y-1][x-1].getFlagged()){board[y+1][x].click();}}catch(Exception e){;}
  try{if (!board[y+1][x+1].getClicked() && !board[y-1][x-1].getFlagged()){board[y+1][x+1].click();}}catch(Exception e){;}
    
    
    
  }
  
  public void clickAdjacentBackup(){
    int count2 = 0;
    
    int n = board.length;
    
    
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        if (board[i][j].getType() != "Mine"){
        
        if (i == 0 && j == 0){
          NumberSpace spacetest = (NumberSpace)board[i][j];
          if (spacetest.getNumber() == 0 && board[i][j].getClicked()){
            board[i][j+1].click();
            board[i+1][j+1].click();
            board[i+1][j].click();
          }
          continue;
        }
        if (i == 0 && j == board.length-1){
          NumberSpace spacetest = (NumberSpace)board[i][j];
          if (spacetest.getNumber() == 0 && board[i][j].getClicked()){
            board[i][j-1].click();
            board[i+1][j-1].click();
            board[i+1][j].click();
          }
          continue;
        }
        
        if (i == board.length-1 && j == 0){
          NumberSpace spacetest = (NumberSpace)board[i][j];
          if (spacetest.getNumber() == 0 && board[i][j].getClicked()){
            board[i-1][j+1].click();
            board[i-1][j].click();
            board[i][j+1].click();
          }
          continue;
        }
        if (i == board.length-1 && j == board.length-1){
          NumberSpace spacetest = (NumberSpace)board[i][j];
          if (spacetest.getNumber() == 0 && board[i][j].getClicked()){
            board[i-1][j-1].click();
            board[i-1][j].click();
            board[i][j-1].click();
          }
          continue;
        }
        if (i == 0){
          NumberSpace spacetest = (NumberSpace)board[i][j];
          
          if (spacetest.getNumber() == 0 && board[i][j].getClicked()){
            
            board[i][j-1].click();
            board[i][j+1].click();
            board[i+1][j-1].click();
            board[i+1][j].click();
            board[i+1][j+1].click();
            
          }
          
        }
        
        if (i == board.length-1){
          NumberSpace spacetest = (NumberSpace)board[i][j];
          
          if (spacetest.getNumber() == 0 && board[i][j].getClicked()){
            
            board[i-1][j-1].click();
            board[i-1][j].click();
            board[i-1][j+1].click();
            board[i][j-1].click();
            board[i][j+1].click();
            
          }         
        }
        
        if (j == 0){
          NumberSpace spacetest = (NumberSpace)board[i][j];
          
          if (spacetest.getNumber() == 0 && board[i][j].getClicked()){
            board[i+1][j].click();
            board[i+1][j+1].click();
            board[i][j+1].click();
            board[i-1][j].click();
            board[i-1][j+1].click();           
          }         
        }
        
        
        if (j == board[i].length-1){
          NumberSpace spacetest = (NumberSpace)board[i][j];
          
          if (spacetest.getNumber() == 0 && board[i][j].getClicked()){
            board[i+1][j-1].click();
            board[i+1][j].click();
            board[i][j-1].click();
            board[i+1][j-1].click();
            board[i+1][j].click();           
          }         
        }
        else{
          NumberSpace spacetest = (NumberSpace)board[i][j];
          
          if (spacetest.getNumber() == 0 && board[i][j].getClicked()){
            board[i-1][j-1].click();
            board[i-1][j].click();
            board[i-1][j+1].click();
            board[i][j-1].click();
            board[i][j+1].click();
            board[i+1][j-1].click();
            board[i+1][j].click();
            board[i+1][j+1].click();
            
          }
        }
        
      }
      
    }
    }
  }
            
  
  public String toString(){    
    String output = " ";
    for (int k = -1; k < (n*2);k++){
      if (k % 2 == 0){
        output += k/2;
      }
      else{
        output += "-";
      }
      }
    output += "\n";
    for (int k = -2; k < (n*2);k++){
        output += "-";
      }
    for (int i = 0; i < n; i++){
      output += ("\n" + i + "|");
      for (int j = 0; j < n; j++){    
        try{
          if (board[i][j].getFlagged()){
            output += "f";
          }
          else if (!board[i][j].getClicked()){
            output += "o";
          }
          
        else if (board[i][j].getType().equals("Mine")){
          output += "*";
        }
        else{
          try{
            NumberSpace spacetest = (NumberSpace)board[i][j];
            output += spacetest.getNumber();
          }
          catch (Exception e){
            output += " ";
          }
        }
        output += "|";
      }
        catch (Exception e){}
    }
      output += "\n";
      for (int k = -2; k < (n*2);k++){
        output += "-";
      }
    }
  
  return output;
  
}
  public String getState(){
    boolean flag = false;
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j].getType().equals("Mine") && board[i][j].getClicked()){
          return "Loss";
        }
        if (!board[i][j].getFlagged() && board[i][j].getType().equals("Mine")){
          flag = true;
        }
      }
    }
    if (flag){
      return "Neither";
    }
    return "Won";
  }
  public void processTurn(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j].getType() != "Mine"){
        NumberSpace spacetest = (NumberSpace)board[i][j];
        
        if(spacetest.getNumber() == 0 && board[i][j].getClicked()){
          
          clickAdjacent(i,j);
          clickAdjacentBackup();
          return;
        }
        }
       
      }
    }
}
}
      
      