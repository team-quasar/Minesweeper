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
      if (!board[y-1][x-1].getClicked()){try{clickAdjacent(y-1,x-1);}catch(Exception e){;}}
      if (!board[y-1][x].getClicked()){try{clickAdjacent(y-1,x);}catch(Exception e){;}}
      if (!board[y-1][x+1].getClicked()){try{clickAdjacent(y-1,x+1);}catch(Exception e){;}}
      if (!board[y][x-1].getClicked()){try{clickAdjacent(y,x-1);}catch(Exception e){;}}
      if (!board[y][x+1].getClicked()){try{clickAdjacent(y,x+1);}catch(Exception e){;}}
      if (!board[y+1][x-1].getClicked()){try{clickAdjacent(y+1,x-1);}catch(Exception e){;}}
      if (!board[y+1][x].getClicked()){try{clickAdjacent(y+1,x);}catch(Exception e){;}}
      if (!board[y+1][x+1].getClicked()){try{clickAdjacent(y+1,x+1);}catch(Exception e){;}}
    }
    else{
      board[y][x].click();
    }
    
  }
  public void clickAdjacentBackup(){
    int count2 = 0;
    
    int n = board.length;
    System.out.println(":" + n);
    
    for (int i = 0; i < 12; i++){
      for (int j = 0; j < 12; j++){
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
        
        
      }
      
    }
    }
  }
            
  
  public String toString(){    
    String output = "";
    for (int i = 0; i < n; i++){
      output += "\n";
      for (int j = 0; j < n; j++){    
        try{
          if (!board[i][j].getClicked()){
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
      for (int k = 0; k < (n*2);k++){
        output += "-";
      }
    }
  
  return output;
  
}
  public boolean isWon(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j].getType().equals("Mine") && board[i][j].getClicked()){
          return true;
        }
      }
    }
    return false;
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
      
      