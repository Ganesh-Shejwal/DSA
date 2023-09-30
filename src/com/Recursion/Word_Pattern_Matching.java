package com.Recursion;

import javax.crypto.spec.PSource;
import java.util.HashMap;

public class Word_Pattern_Matching {
    // T.C. str.length()! => O(N*2^N) ...
    // S.C. pat.length()  => O(M) (Auxillary Space)
    public static void main(String[] args) {
      String str="graphmatchgraph";
      String pat="pep";
      help(str,pat,0,new HashMap<>());
    }
    public static void help(String str, String pat,int ind, HashMap<Character,String> map){
        if(ind==pat.length()){
            if(str.isEmpty()){
              // Visited HashMap used to avoid reprinting of character
              // e.g. pep => avoid reprinting of 'p'
              HashMap<Character,Boolean> isVisited = new HashMap<>();
              for(int i=0;i<pat.length();i++){
                  char ch=pat.charAt(i);
                  if(isVisited.get(ch)==null) System.out.println(ch+"-->"+map.get(ch));
                  isVisited.put(ch,true);
              }
                System.out.println("---------------------------------------------------------------------------");

            }
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=pat.charAt(ind);
            String left=str.substring(0,i+1);
            String right=str.substring(i+1);
            if(map.containsKey(ch)){
                if(left.equals(map.get(ch))){
                    help(right,pat,ind+1,map);
                }
            }
            else{
                map.put(ch,left);
                help(right,pat,ind+1,map);
                map.remove(ch);
            }
        }

    }
}
