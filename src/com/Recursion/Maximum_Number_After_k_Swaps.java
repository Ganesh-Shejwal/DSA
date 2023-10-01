package com.Recursion;

public class Maximum_Number_After_k_Swaps {
    // T.C O(2^N) ...
    // S.C O(N) Aux. Space
    public static void main(String[] args) {
        String str="1234";
        int swap=2;
        help(str,swap);
        System.out.println(max);
    }
    public static String swapped(String str,int i,int j){
        //str="1234567"   i=2   j= 4
        char charAti = str.charAt(i);        // 3
        char charAtj = str.charAt(j);        // 5
        String left = str.substring(0,i);    // (0,2) 12
        String mid = str.substring(i+1,j);   // (3,4) 4
        String right = str.substring(j+1);   // (4,7) 67
        return left+charAtj+mid+charAti+right;  // 12+5+4+3+67 => 1254367
    }
    static String max="0";
    public static void help(String str,int swap){
        // written this statement before base cond. because final max num check.
        if(Integer.parseInt(str)>Integer.parseInt(max)) {
            max=str;
        }
        if(swap==0) {
            return;
        }
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                System.out.println(str);
                str=swapped(str,i,j);
                help(str,swap-1);
                str=swapped(str,i,j);
            }
        }
    }

}

