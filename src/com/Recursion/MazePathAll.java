package com.Recursion;

import java.util.ArrayList;
public class MazePathAll {
    public static void main(String[] args) {
        //   int m1[][]=new int[3][3];
        //   int count=help1(m1,0,0);
        //   System.out.println("No of Ways To reach at end ="+count);
        int a[][]=new int[3][3];
        help6(a, 0, 0, "");
    }
    /*--------Only 2 Direction Move Down / Right--------- */
    // Q1) No of Ways to reach at End
    //T.C.  O(2^m*n)
    //S.C   O(m+n)
    private static int help1(int[][] mat,int r,int c){
        if(r==mat.length-1 && c==mat[0].length-1) return 1;
        if(r>mat.length || c>mat.length) return 0;
        int left=help1(mat, r+1, c);
        int right=help1(mat, r, c+1);
        return left+right;
    }

    // Q2) Print The Path
    //T.C.  O(2^m*n)
    //S.C   O(m+n)
    static ArrayList<String> res= new ArrayList<>();
    private static void help2(int[][] mat,int r,int c,String path){
        if(r==mat.length && c==mat[0].length){
            System.out.println(path);
            res.add(path);
            return;
        }
        if(r<mat.length){
            help2(mat, r+1, c,path+'D');
        }
        if(c<mat.length){
            help2(mat, r, c+1,path+'R');
        }
    }
    // Q3) Digonal Move
    //T.C.  O(3^m*n)
    //S.C   O(m+n)
    private static void help3(int[][] mat,int r,int c,String path){
        if(r==mat.length-1 && c==mat[0].length-1){
            System.out.println(path);
            return;
        }
        //Vertical
        if(r<mat.length) help3(mat, r+1, c,path+'V');
        //Digonal
        if(r<mat.length && c<mat.length) help3(mat, r+1, c+1, path+'D');
        //Horizontal
        if(c<mat.length) help3(mat, r, c+1,path+'H');
    }
    // Q4) All Direction
    //T.C.  O(4^m*n)
    //S.C   O(m*n)
    private static void help4(int[][] mat,int r,int c,String path){
        if(r<0 || r==mat.length || c<0 || c==mat.length || mat[r][c]==1){
            return;
        }
        if(r==mat.length-1 && c==mat[0].length-1){
            System.out.println(path);
            return;
        }
        mat[r][c]=1;
        //left
        help4(mat, r,c-1,path+'L');
        //Down
        help4(mat,r+1,c,path+'D');
        //Right
        help4(mat,r,c+1,path+'R');
        //Up
        help4(mat, r-1, c,path+'U');
        mat[r][c]=0;

    }
    // Q5) Maze With Obstacle
    //T.C.  O(4^m*n)
    //S.C   O(m*n)
    private static void help5(int[][] mat,int r,int c,String path){
        if(r<0 || r==mat.length || c<0 || c==mat[0].length) return;
        if(mat[r][c]==0 || mat[r][c]== -1) return;
        if(r==mat.length-1 && c==mat[0].length-1){
            res.add(path);
            //  System.out.println(path);
            return;
        }
        mat[r][c]=-1;
        //left
        help5(mat, r,c-1,path+'L');
        //Down
        help5(mat,r+1,c,path+'D');
        //Right
        help5(mat,r,c+1,path+'R');
        //Up
        help5(mat, r-1, c,path+'U');
        mat[r][c]=1;

    }
    // Q6) Maze Path With Jumps
    //T.C. O(n^(n))
    //S.C. O(m+n)
    private static void help6(int[][] mat,int r,int c,String path){
        if(r==mat.length-1 && c==mat[0].length-1){
            System.out.println(path);
            return;
        }
        if(r>mat.length || c>mat.length) return;
        for(int i=1;i<mat.length;i++){
            help6(mat, r+i, c,path+'D');
            help6(mat, r, c+i,path+'R');
        }
    }

}

