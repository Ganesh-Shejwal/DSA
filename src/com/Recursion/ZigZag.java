package recursion;

public class ZigZag{
    public static void main(String[] args){
        print(3);
    };
    private static void print(int n){
      if(n==0) return;
      System.out.println("Pre"+ n);
      print(n-1);
      System.out.println("In"+ n);
      print(n-1);
      System.out.println("Post"+ n);
    }
}