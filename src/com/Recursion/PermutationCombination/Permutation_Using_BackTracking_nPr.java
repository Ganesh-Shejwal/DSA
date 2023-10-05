package com.Recursion.PermutationCombination;

import java.util.Arrays;

public class Permutation_Using_BackTracking_nPr {
    // Problem Statement : No of Ways to put non-identical(non-similar) r items into n boxes
    // T.C. O(n!/(n-r)!)
    // S.C. O(n) => n = total items;
    public static void main(String[] args) {
        int current_item=1,total_items=2;
        int[] boxes = new int[4];
        help(current_item,total_items,boxes);
    }
    public static void help(int citem,int titems,int[] boxes){
        if(citem>titems){
            System.out.println(Arrays.toString(boxes));
            return;
        }
        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==0){
                boxes[i]=citem;
                help(citem+1,titems,boxes);
                boxes[i]=0;
            }
        }

    }
}
