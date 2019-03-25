public class MinesweeperTest{
  public static void main(String[] args){
    Board board = new Board(12,16);
    System.out.println(board);
    board.board[5][6].click();
    board.processTurn();
    System.out.println(board);
    
}
}