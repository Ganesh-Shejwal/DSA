package com.Recursion;
public class StairPath {
    //T.C O(3^n)
    //S.C O(n)
    public static void main(String[] args) {
        help(3, "");
        System.out.println("Count="+count);
    }
    static int count=0;
    //method 1 --------> for n= Any from 1->n;
    private static void help(int n,String path){
        if(n==0) {
            System.out.println(path);
            count++;
            return;
        }
        if(n<0)return;
        for(int i=1;i<=n;i++){
            help(n-i, path+Integer.toString(i));
        }
    }
    /*method 2 --------> Only for n=3
    private static void help(int n,String path){
        if(n==0) {
            System.out.println(path);
            count++;
            return;
        }
        if(n<0)return;
        help(n-1,path+'1');
        help(n-2,path+'2');
        help(n-3,path+'3');
    }*/
}
