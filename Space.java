public class Space{
  
  private boolean isClicked;
  public Space(){
    
    isClicked = false;
  }
  
  public void click(){
    isClicked = true;
  }
  public boolean getClicked(){
    return isClicked;
  }
  public String getType(){
    return "Blank";
  }
}