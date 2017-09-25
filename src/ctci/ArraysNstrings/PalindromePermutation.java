package ctci.ArraysNstrings;

import java.util.Arrays;

public class PalindromePermutation {

    public static void main(String[] args){
      String s1 = "aadbcbdgc";
      System.out.println("isPalindromePermutation("+s1+"):"+isPalindromePermutation(s1));
      System.out.println("isPalindromePermutation("+s1+"):"+isPalindromePermutation2(s1));
    }

    /* returns true if given string is a permutation of a Palindrome, false otherwise.
      T(n)=O(n). n space complexity = constant.*/
    private static boolean isPalindromePermutation(String s1){
        boolean isPalindromePermutation = true;
        s1 = s1.toLowerCase();
        int oddFrequencyCount = 0;
        int[] chFrequency = new int[26];
        Arrays.fill(chFrequency,0);
        for(int c1=0;c1<s1.length();c1++){
          chFrequency[s1.charAt(c1)-'a'] += 1;
          if((chFrequency[s1.charAt(c1)-'a']&1)==0) oddFrequencyCount-=1;
          else oddFrequencyCount += 1;
        }
        isPalindromePermutation = oddFrequencyCount<2?true:false;
        return isPalindromePermutation;
    }

    /* T(n)=O(n) and
       space complexity = O(1), constant time. uses 1 extra variable. */
    private static boolean isPalindromePermutation2(String s1){
        int checker = 0;
        for(int c1=0;c1<s1.length();c1++){
           int ch = s1.charAt(c1);
           checker = checker^(1<<ch);
        }
        return (checker==0)|(checker & (checker-1))==0?true:false;
    }


}
