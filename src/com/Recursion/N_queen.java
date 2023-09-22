package com.Recursion;

import java.util.Scanner;

public class N_queen {
    //T.C n*T(n-1)+n^2==N!
    public static void main(String[] args) {
        int a[][]= new int[4][4];
        help(a,0);
    }
    private static void help(int a[][],int row){
        if(row==a.length){
            displayBoard(a);
            System.out.println();
            return;
        }
        for(int col=0;col<a.length;col++){
            if(isSafe(a,row,col)){
                a[row][col]=1;
                help(a,row+1);
                a[row][col]=0;
            }
        }
    }
    private static boolean isSafe(int a[][],int row,int col){
        //up
        for(int i=row-1,j=col;i>=0;i--){
            if(a[i][j]==1) return false;
        }
        //digonally left
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(a[i][j]==1) return false;
        }
        //digonally right
        for(int i=row-1,j=col+1;i>=0 && j<a.length;i--,j++){
            if(a[i][j]==1) return false;
        }
        return true;
    }
    private static void displayBoard(int a[][]){
         for(int row[]:a){
             for(int val:row){
                 if(val==1) System.out.print("Q");
                 else System.out.print("X");
             }
             System.out.println();
         }
    }

    public static class Palindrome {
        public static void main(String[] args) {
            int n,rev=0;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Any Number = ");
            n=sc.nextInt();
            for(int i=n;i>0;i/=10){
                int rem=i%10;
                rev=rev*10+rem;
            }
            if(n==rev) System.out.println("com.DSA.Reursion.N_queen.Palindrome");
            else System.out.println("Not com.DSA.Reursion.N_queen.Palindrome");

        }
    }
}
