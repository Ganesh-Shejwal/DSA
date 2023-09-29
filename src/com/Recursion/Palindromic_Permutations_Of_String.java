package com.Recursion;

import java.util.HashMap;

public class Palindromic_Permutations_Of_String {
    // T.C. (Hashmap Generated String.length()/2!/Product of Each Character Freq./2);
    // e.g. (4!/2! 2!) => 6

    // S.C String.length()/2
    public static void main(String[] args) {
        String str="ababaabbc";
        HashMap<Character,Integer> map = new HashMap<>();
        int len=str.length();
        for(int i=0;i<len;i++){
            char ch=str.charAt(i);
            if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
        }
        Character odd=null;
        int countOdd=0,length=0;
        for(char ch : map.keySet()){
            int frq=map.get(ch);
            if(frq%2!=0){
                odd=ch;
                countOdd++;
            }
            map.put(ch,frq/2);
            length+=frq/2;
        }
        help(length,odd,"",map);
    }
    public static String reverse(String str){
        String res="";
        for(int i=str.length()-1;i>=0;i--){
            res+=str.charAt(i);
        }
        return res;
    }
    public static void help (int len,Character odd,String ds,HashMap<Character,Integer> map){
        if(len==0){
            String rev= reverse(ds);
            if(odd!=null) System.out.println(ds+odd+rev);
            else System.out.println(ds+rev);
            return;
        }
        for(char ch : map.keySet()){
            int frq=map.get(ch);
            if(frq>0){
                map.put(ch,frq-1);
                help(len-1,odd,ds+ch,map);
                map.put(ch,frq);
            }
        }
    }

}
