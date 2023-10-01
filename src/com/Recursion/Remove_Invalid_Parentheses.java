package com.Recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Remove_Invalid_Parentheses {
    // T.C O(2^N) ...
    // S.C O(N)
    public static void main(String[] args) {
        // String str="(()()))(";
        // String str="((a)())";
         String str="((()((s((((()";
        int count=getMax(str);
        help(str,count,new HashMap<>());
        System.out.println(res);
    }
    //HashSet used to avoid duplicate result
    static HashSet<String> res=new HashSet<>();
    public static int getMax(String str){
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            // avoid character in string
            if(ch>='a' && ch<='z') continue;
            if(!stk.empty() && ( ch==')' && stk.peek()=='(')) stk.pop();
            else stk.push(ch);
        }
        return stk.size();
    }
    public static void help(String str, int count, HashMap<String,Boolean> map){
        // HashMap used to avoid make recursion call on already processed string (Avoid T.L.E)
        if(map.containsKey(str)) return;
        map.put(str,true);
        if(count==0){
            int ans=getMax(str);
            if(ans==0) res.add(str);
            return;
        }
        for(int i=0;i<str.length();i++){
            String left=str.substring(0,i);
            String right=str.substring(i+1);
            help(left+right,count-1,map);
        }
    }
}
