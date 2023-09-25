package com.Recursion;
import java.util.Scanner;
class ReverseNumber {
    public static void main(String[] args){
        int a[]={1,2,3,4,5};
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        rev(n);
        boolean check=isPalindrome(n);
        System.out.println(check);
    }
    static int rev(int n){
    
      int digit=(int)(Math.log10(n))+1;
      return help(n,digit); 
    }
    static int help(int n,int digit){
        if(n%10==n)return n;
        return (n%10) *(int)(Math.pow(10,digit-1))+help(n/10,--digit);
    }
    static boolean isPalindrome(int n){
      return n==rev(n);
    }

       
}