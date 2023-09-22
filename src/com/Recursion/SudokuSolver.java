package com.Recursion;

public class SudokuSolver {
    //T.C O(9^n)
    //S.C.O(n*n)
    public static void main(String[] args) {
      char a[][]={{'5','3','0','0','7','0','0','0','0'},{'6','0','0','1','9','5','0','0','0'},{'0','9','8','0','0','0','0','6','0'},{'8','0','0','0','6','0','0','0','3'},{'4','0','0','8','0','3','0','0','1'},{'7','0','0','0','2','0','0','0','6'},{'0','6','0','0','0','0','2','8','0'},{'0','0','0','4','1','9','0','0','5'},{'0','0','0','0','8','0','0','7','9'}};
      solveSudoku(a,0,0);
    }
    public static void displayBoard(char board[][]){
        for(char rows[]:board){
            for(char val:rows){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    public static void solveSudoku(char board[][],int row,int col){
        if(row==board.length-1 && col==board.length){
            displayBoard(board);
            return;
        }
        if(col==board[0].length){
            col=0;
            row=row+1;
        }
        if(board[row][col]!='0'){
            solveSudoku(board,row,col+1);
        }
        else{
            for(char i='0';i<='9';i++){
                if(isValid(board,row,col,i)){
                    board[row][col]=i;
                    solveSudoku(board,row,col+1);
                    board[row][col]='0';
                }
            }
        }
    }
    public static boolean isValid(char a[][],int x,int y,char val){
        for(int j=0;j<a[0].length;j++){
            if(a[x][j]==val) return false;
            if(a[j][y]==val) return false;
        }
        int smi=x/3*3,smj=y/3*3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(a[smi+i][smj+j]==val){
                    return false;
                }
            }
        }
        return true;
    }
}