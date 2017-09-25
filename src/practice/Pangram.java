package practice;

import java.util.*;

public class Pangram {
    /* pangram is a English sentence which has all english characters in it.
    * e.g, Pack my box with five dozen liquor jugs.
    *      Jackdaws love my big sphinx of quartz. */
    public static void main(String[] args){
        String pangram = new String("abcdefghijlmnopqqrstuvwxy");
        for(char ch:getMissingChars(pangram))
            System.out.print(ch);
    }

    /* returns list of missing characters to make a string Pangram.*/
    private static List<Character> getMissingChars(String c1){
       c1 = c1.toLowerCase();
       List<Character> missingList = new ArrayList<>();
       int[] alphabets = new int[26];
        Arrays.fill(alphabets,0);
       for(int c=0;c<c1.length();c++){
         char c3 = c1.charAt(c);
         if(c3==' ') continue;
         alphabets[c3-'a'] = 1;
       }
       for(int c=0;c<26;c++){
          /*System.out.print(alphabets[c]);*/
          if(alphabets[c]==0)
              missingList.add((char)(c+97));
       }
        System.out.println();
       return missingList;
    }

}


