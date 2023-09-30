package com.Recursion;

import java.util.ArrayList;

public class Palindromic_Partitioning_Of_String {

    // T.C. (N*2^N)*N/2
    // Here N => At Worst case Consider all Palindromic permutations e.g "aaa";
    //    2^N => Total No of Substring are Generated
    //     N/2=> Palindromic Check;

    // S.C. O(N)
    //     N => Auxillary Space
    public static void main(String[] args) {
        help("abaaba","");
    }
    public static boolean isPalindrome(String str){
        int s=0,e=str.length()-1;
        while(s<e){
            if(str.charAt(s++)!=str.charAt(e--)) return false;
        }
        return true;
    }
    public static void help(String str, String ds){
        if(str.equals("")){
            System.out.println(ds);
        }
        for(int i=0;i<str.length();i++){
            String left=str.substring(0,i+1);
            String right=str.substring(i+1,str.length());
            if(isPalindrome(left)){
                help(right,ds+"("+left+")");
            }
        }
    }
}
