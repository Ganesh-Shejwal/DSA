package com.Recursion.PermutationCombination;

import java.util.Arrays;

public class Combination_Using_BackTracking_nCr {

    // Problem Statement : No of Ways to put identical(similar) r items into n boxes
    // T.C. O(n!/r! (n-r)!)
    // S.C. O(n) => n = size of items;
    public static void main(String[] args) {
        int citem=0,items=2;
        int[] boxes = new int[4];
        help(0,citem,items,boxes);
    }
    public static void help(int index,int citem,int items,int[] boxes){
        if(index==boxes.length){
            System.out.println(Arrays.toString(boxes));
            return;
        }
        if(citem<items){
            boxes[index]=1;
            help(index+1,citem+1,items,boxes);
            boxes[index]=0;
            help(index+1,citem,items,boxes);
        }

    }
}
