

/***
* 声明式 VS 命令式
***/
public class FindNemo {
  public static void main(String[] args) {
    List<String> names = 
      Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");
 
    findNemo(names);
  }                 
   
  public static void findNemo(List<String> names) {
    boolean found = false;
    for(String name : names) {
      if(name.equals("Nemo")) {
        found = true;
        break;
      }
    }
     
    if(found)
      System.out.println("Found Nemo");
    else
      System.out.println("Sorry, Nemo not found");
  }

 

 public static void findNemo2(List<String> names) {
  if(names.contains("Nemo"))
    System.out.println("Found Nemo");
  else
    System.out.println("Sorry, Nemo not found");
}



}

