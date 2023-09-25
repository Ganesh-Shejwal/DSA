package com.Recursion;

public class Lexicographical_Order {
    //T.C. O(9^n)
    //S.C. O(1)
    // Note : For O(n) time complexity use DFS algo.
    public static void main(String[] args) {
        int n=12;
        for(int i=1;i<=9;i++){
            help(i,n);
        }
    }
    public static void help(int num,int n){
        if(num>n) return;
        System.out.println(num);
        for(int i=0;i<=9;i++){
            help(num*10+i,n);
        }
    }
}
