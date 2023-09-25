package recursion;
import java.util.ArrayList;

public class Substrings {
    public static void main(String[] args) {
        String str="abc";
        int n=str.length();

        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
          for(int j=i;j<n;j++){
            arr.add(str.substring(i,j+1));
          }
        }
        System.out.println(arr);
    }
}
