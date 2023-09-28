package com.Recursion;

public class FriendsPairingProblem_UsingBackTracking {
    // T.C  O(2^n)
    // S.C. O(n)
    public static void main(String[] args) {
        int n=3;
        boolean[] used=new boolean[5];
        help(n,1,used,"");
    }
    public static void help(int n,int i,boolean[] used,String ds){
        if(i==n+1){
            System.out.println(ds);
            return;
        }
        if(used[i]){
            help(n,i+1,used,ds);
        }
        else{
            used[i]=true;
            help(n,i+1,used,ds+'('+i+')');
            for(int j=i+1;j<=n;j++){
                if(!used[j]){
                    used[j]=true;
                    help(n,i+1,used,ds+'('+i+j+')');
                    used[j]=false;
                }
            }
            used[i]=false;
        }
    }
}
