package com.Recursion.PermutationCombination;

import java.util.Arrays;

public class Permutation_Using_Combination {
    // Problem Statement : No of Ways to put non-identical(non-similar) r items into n boxes
    // T.C. O(n!/(n-r)!)
    // S.C. O(n) => n = size of items;
    public static void main(String[] args) {
        int noitem=0,items=2;
        int[] boxes = new int[3];
        int [] isVisited = new int[items+1];
        help(0,noitem,items,boxes,isVisited);
    }
    public static void help(int index,int noitem,int items,int[] boxes,int[] isVisited){
        if(index==boxes.length){
            if(noitem==items) System.out.println(Arrays.toString(boxes));
            return;
        }
        for(int i=1;i<=items;i++){
            if(isVisited[i]==0){
                isVisited[i]=1;
                boxes[index]=i;
                help(index+1,noitem+1,items,boxes,isVisited);
                boxes[index]=0;
                isVisited[i]=0;
            }
        }
        help(index+1,noitem,items,boxes,isVisited);
    }
}
