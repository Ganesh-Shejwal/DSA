package com.Recursion;

import java.util.HashMap;
import java.util.HashSet;

public class Word_Break_Problem {
    // T.C  O(N*2^N) ...
    // S.C. O(N) Auxillary Space At Worst Case
    // e.g  dict={'s','o','f','t'}
    //       str="soft"
    public static void main(String[] args) {
        HashSet<String> dict =new HashSet<>();
        dict.add("micro");
        dict.add("soft");
        dict.add("hi");
        dict.add("ring");
        dict.add("hiring");
        String str="microsofthiring";
        help(str,"",dict);
    }
    public static void help(String str,String ds,HashSet<String> dict){
        if(str.isEmpty()){
            ds=ds.substring(0,ds.length()-1);
            System.out.println(ds);
            return;
        }
        for(int i=0;i<str.length();i++){
            String left=str.substring(0,i+1);
            String right=str.substring(i+1);
            if(dict.contains(left)){
                help(right,ds+left+'-',dict);
            }
        }
    }
}
