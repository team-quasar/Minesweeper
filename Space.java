public abstract class Space{
  
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
  public abstract String getType();
}