package com.Recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class Send_More_Money {
    // CryptArithmetic Problem
    // T.C. O(n!)
    // S.C. O(1)
    // [ leetcode gives TLE Problem No 1307 ]
    // use DFS for optimize solution
    public static void main(String[] args) {
        String [] words={"send","more"};
        String result="money",str="";
        for(String tmp : words){
            for(int i=0;i<tmp.length();i++){
                char key=tmp.charAt(i);
                if(!map.containsKey(key)){
                    map.put(key,-1);
                    str+=key;
                }
            }
        }
        for(int i=0;i<result.length();i++){
            char key=result.charAt(i);
            if(!map.containsKey(key)){
                map.put(key,-1);
                str+=key;
            }
        }
        help(words,result,str,0);
    }
    static HashMap <Character,Integer> map = new HashMap<>();
    static boolean[] ar=new boolean[10];
    public static void help(String[] words,String res,String str,int index){
        if(index==str.length()){
            if(getResult(words,res)){
                displayResult(map);
                System.out.println();
            }
            return;
        }
        char ch=str.charAt(index);
        for(int i=0;i<=9;i++){
            if(!ar[i]){
                map.put(ch,i);
                ar[i]=true;
                help(words,res,str,index+1);
                ar[i]=false;
            }
        }
    }
    public static boolean getResult(String[] words,String res){
        int wordsSum=0;
        for(String tmp : words){
            String str="";
            for(int i=0;i<tmp.length();i++){
                //convert Integer to character;
                str+=map.get(tmp.charAt(i));
            }
            wordsSum+=Integer.parseInt(str);
        }
        String resSum="";
        for(int i=0;i<res.length();i++){
            //convert Integer to character;
            resSum+=map.get(res.charAt(i));
        }
        return wordsSum==Integer.parseInt(resSum)?true:false;
    }
    public static void displayResult(HashMap <Character,Integer> map){
        for(char i='a';i<='z';i++){
            if(map.containsKey(i)){
                System.out.print(i+"-->"+map.get(i)+" ");
            }
        }
    }
}
