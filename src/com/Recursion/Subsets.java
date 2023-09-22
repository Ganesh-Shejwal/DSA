package com.Recursion;

import java.util.ArrayList;
public class Subsets {
    //T.C. O(2^n);
    //S.C. O(n);
    static ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<Integer> tmp=new ArrayList<>();
        int a[]={1,1,1};
        help2(a,tmp,0);
        System.out.println(res);
    }
    //method 1
    public static void help1(int a[], ArrayList<Integer> ds, int i){
        if(i==a.length){
            System.out.println(ds);
            return;
        }
        ds.add(a[i]);
        help1(a, ds, i+1);
        ds.remove(ds.size()-1);
        while(i+1<a.length && a[i]==a[i+1])i++;
        help1(a, ds, i+1);

    }
    //method 2
    public static void help2(int a[], ArrayList<Integer> ds,int i){
        if(i==a.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(a[i]);
        help2(a, ds, i+1);
        ds.remove(ds.size()-1);
        while(i+1<a.length && a[i]==a[i+1])i++;
        help2(a, ds, i+1);
    }
}
