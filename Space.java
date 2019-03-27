public class Space{
  
  private boolean isClicked;
  private boolean isFlagged;
  public Space(){
    isFlagged = false;
    isClicked = false;
  }
  
  public void click(){
    isClicked = true;
  }
  public void flag(){
    isFlagged = !isFlagged;
  }
  public boolean getClicked(){
    return isClicked;
  }
  public boolean getFlagged(){
    return isFlagged;
  }
  public String getType(){
    return "Blank";
  }
}