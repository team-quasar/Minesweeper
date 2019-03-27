import java.util.Scanner;
public class MinesweeperTest{
  public static void main(String[] args){
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter board size: ");
    int boardsize = kb.nextInt();
    System.out.println("Enter minecount: ");
    int minecount = kb.nextInt();
    
    Board board = new Board(boardsize,minecount);
    System.out.println(board);
    
    int x = 0;
    int y = 0;
    char choice = 'a';
    while (board.getState().equals("Neither")){
      System.out.println("Enter x: ");
      x = kb.nextInt();
      System.out.println("Enter y: ");
      y = kb.nextInt();
      System.out.println("Enter flag or click: (f/c)");
      choice = kb.next().charAt(0);
      try{
      if (choice == 'f'){
        board.board[y][x].flag();
        board.processTurn();
      }
      if (choice == 'c'){
        NumberSpace spacetest = (NumberSpace)board.board[y][x];
        if (spacetest.getNumber() != 0 && board.board[y][x].getClicked()){
          board.clickAdjacentExceptItsForNumbersThisTime(y,x);
        }
        else{
          board.board[y][x].click();
        }
        board.processTurn();
      }
      }
      catch (Exception e){
        System.out.println("Error");
      }
      System.out.println(board);
    }
    System.out.println(board.getState());
    
    
}
}