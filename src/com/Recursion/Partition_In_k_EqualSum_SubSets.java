package com.Recursion;

import java.util.ArrayList;

public class Partition_In_k_EqualSum_SubSets {

    // Problem Statement : In this Question We have to partition into k subsets with each subset having equal sum to other subsets;

    // e.g.  int ar = [1 1 2] , k=2  => [ 2 | 2 ]
    // T.C.  O(2^K * N)
    // S.C.  O(k)
    public static void main(String[] args) {
        int[] ar = {1,1,2};
        int k=2;
        ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
        for(int i=0;i<k;i++){
            ds.add(new ArrayList<>());
        }
        int[] sumArr=new int[k];
        help(ar,0,k,1,ds,sumArr);
    }
    public static boolean isEqual(int[] ar){
        for(int i=0;i<ar.length-1;i++){
            if(ar[i]!=ar[i+1]) return false;
        }
        return true;
    }
    public static void display(ArrayList<ArrayList<Integer>> ds){
        for(ArrayList<Integer> ls:ds){
            System.out.print(ls+" ");
        }
        System.out.println();
    }
    public static void help(int[] ar, int ind, int k,int csub, ArrayList<ArrayList<Integer>> ds,int[] sumArr){
        if(ind==ar.length){
            if(csub>k){
                if(isEqual(sumArr)) display(ds);
            }
            return;
        }
        for(int i=0;i<k;i++){
            ArrayList<Integer> ls=ds.get(i);
            if(ls.size()>0){
                //If partition size is not zero then add ele. but not inc. count
                sumArr[i]+=ar[ind];
                ls.add(ar[ind]);
                help(ar,ind+1,k,csub,ds,sumArr);
                ls.remove(ls.size()-1);
                sumArr[i]-=ar[ind];
            }
            else{
                //If partition size is zero then add ele. but inc. count and break loop to avoid repetitions
                sumArr[i]+=ar[ind];
                ls.add(ar[ind]);
                help(ar,ind+1,k,csub+1,ds,sumArr);
                ls.remove(ls.size()-1);
                sumArr[i]-=ar[ind];
                break; //used to avoid duplicate partition
            }
        }
    }

}

