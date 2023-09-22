package com.Recursion;

import java.util.HashSet;

public class PrintAbbreviations {
    public static void main(String[] args) {
      solve("pep",0,0,"");
    }
    public static void solve(String str,int index,int helper,String ds){
        if(index==str.length()){
            if(helper==0){
              System.out.println(ds);
            }
            else{
                System.out.println(ds+helper);
            }
            return;
        }
        char ch=str.charAt(index);
        if(helper==0) solve(str,index+1,0,ds+ch);
        else solve(str,index+1,0,ds+helper+ch);
        solve(str,index+1,helper+1,ds);
    }

    public static class ValidSudoku {

        public static void main(String[] args) {
            char a[][]={{'5','3','0','0','7','0','0','0','0'},{'6','0','0','1','9','5','0','0','0'},{'0','9','8','0','0','0','0','6','0'},{'8','0','0','0','6','0','0','0','3'},{'4','0','0','8','0','3','0','0','1'},{'7','0','0','0','2','0','0','0','6'},{'0','6','0','0','0','0','2','8','0'},{'0','0','0','4','1','9','0','0','5'},{'0','0','0','0','8','0','0','7','9'}};
    //        for(int i=0;i<9;i++){
    //            for(int j=0;j<9;j++){
    //                if(a[i][j] !='0' && isValid(a,i,j)){
    //                    System.out.println("False");
    //                }
    //            }
    //        }
    //        System.out.println("True");
            boolean res= isValide(a);
            System.out.println(res);
        }
        //Method 1
        //T.C. O(n*n)
        //S.C. O(n*n);
        public static boolean isValide(char a[][]){
            int n=a.length;
            HashSet set=new HashSet();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int val=a[i][j],smp=(i/3*3)+(j/3);
                       if(val!='0' && (!set.add("r"+i+a[i][j]) || !set.add("c"+j+a[i][j]) || !set.add("sm"+smp+a[i][j])))
                          return false;
                }
            }
            return true;
        }
        //Method 1
        //T.C. O((m*n)*(m+n+9)
        //S.C. O(1)
        public static boolean isValid(char a[][],int r,int c){
            for(int i=0;i<a.length;i++) {
                if (i != c && a[r][i] == a[r][c]) return true;
                if (i != r && a[i][c] == a[r][c]) return true;
            }
            int smi=r/3*3,smj=c/3*3;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(smi+i!=r && smj!=c && a[smi+i][smj+j]==a[r][c]){
                        return false;
                    }
                }
            }
            return false;
        }
    }
}
