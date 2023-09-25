package com.Recursion;
import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {

        // ArrayList<String> res1 = help1("abc","",0);
        // System.out.println(res1);

        ArrayList<String> res2 = help2("abc");
        System.out.println(res2);
    }

    //Method 1
    // i) take it   ii) not take it
    private static ArrayList <String> help1(String str,String ds,int index){
       if(index==str.length()){
          ArrayList <String> ar = new ArrayList<>();
          ar.add(ds);
          return ar;
       }
       ds+=str.charAt(index);
       ArrayList<String> ans1 = help1(str, ds, index+1);
       ds=ds.substring(0, ds.length()-1);
       ArrayList<String> ans2 = help1(str, ds, index+1);

       ans1.addAll(ans2);
       return ans1;
    }

    //Method 2
    //  i) add char ii) not add char 
    private static ArrayList <String> help2(String str){
       if(str.length()==0){
          ArrayList <String> ar = new ArrayList<>();
          ar.add("");
          return ar;
       }
       char chr = str.charAt(0);
       ArrayList<String> ans = help2(str.substring(1));
       ArrayList<String> res = new ArrayList<>();
       for(String tmp:ans){
        res.add(tmp);
        res.add(chr+tmp);
       }
       return res;
    }

}
