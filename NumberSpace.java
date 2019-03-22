public class NumberSpace extends Space{
  private int number;
  public NumberSpace(int n){
    super();
    number = n;
  }
  
  public int getNumber(){
    return number;
  }
  public String getType(){
    return "Number";
  }
}