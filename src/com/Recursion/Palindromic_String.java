package com.Recursion;

public class Palindromic_String {
    // T.C O(N!)
    // S.C.O(N)
    public static void main(String[] args) {
        String str="aaaab";
        help(str,"");
    }
    public static void help(String str,String ds){
        if(str.isEmpty()){
            System.out.println(ds);
            return;
        }
        for(int i=0;i<str.length();i++){
            if (i>0 && str.charAt(i)==str.charAt(i-1)) continue;
            String left=str.substring(0,i);
            String right=str.substring(i+1);
            help(left+right,ds+str.charAt(i));
        }
    }
}
