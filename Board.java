import java.util.Arrays;
public class Board{
  private int n;
  private int minecount;
  private Space[][] board;
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
  public String toString(){    
    String output = "";
    for (int i = 0; i < n; i++){
      output += "\n";
      for (int j = 0; j < n; j++){    
        try{
        if (board[i][j].getType().equals("Mine")){
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
}
      
      