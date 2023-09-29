package com.Recursion;

import java.util.ArrayList;
// T.C. O(2^N)
// S.C. O(k)

public class Partition_In_k_Subsets {
    public static void main(String[] args) {
        int[] ar = {1,2,3};
        int k=2;
        ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
        for(int i=0;i<k;i++){
            ds.add(new ArrayList<>());
        }
        help(ar,0,k,1,ds);
    }
    public static void help(int[] ar, int ind, int k,int csub, ArrayList<ArrayList<Integer>> ds){
        if(ind==ar.length){
            if(csub>k){
                for(ArrayList<Integer> ls:ds){
                    System.out.print(ls+" ");
                }
                System.out.println();
            }
            return;
        }
      for(int i=0;i<k;i++){
          ArrayList<Integer> ls=ds.get(i);
          if(ls.size()>0){
              //If partition size is not zero then add ele. but not inc. count
              ls.add(ar[ind]);
              help(ar,ind+1,k,csub,ds);
              ls.remove(ls.size()-1);
          }
          else{
              //If partition size is zero then add ele. but inc. count and break loop to avoid repetitions
              ls.add(ar[ind]);
              help(ar,ind+1,k,csub+1,ds);
              ls.remove(ls.size()-1);
              break; //used to avoid partition
          }
      }

    }
}
