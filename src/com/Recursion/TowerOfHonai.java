package com.Recursion;
public class TowerOfHonai {
    //T.C. O(2^n)    for n disk => (2^n)-1 moves;
    //S.C. O(2^n)    e.g. for n=3 => 7 moves
    public static void main(String[] args) {
        help(3,'A','B','C');
    }
    static int count=0;
    private static void help(int n,char source,char helper,char desti){
        if(n==0){
            return;
        }
        // Step 1) move n-1 disk from source to helper
        help(n-1, source, desti, helper);
        count++;
        // Step 2) move n th disk from source to destination 
        System.out.println(count+") "+"move "+n+ " disk from "+source+"---->"+desti);
        // Step 3) move n-1 disk from helper to destination
        help(n-1,helper,source,desti);
        
    }
}
