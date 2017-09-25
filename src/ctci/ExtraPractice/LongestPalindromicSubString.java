package ctci.ExtraPractice;

import java.util.Arrays;

/**
 * Created by vinayreddypolati on 7/3/17.
 */
public class LongestPalindromicSubString {

    /* T(n) = O(n^3)
    *   Here, I am checking every possible string if its a palindrome
     *   #Total possible strings = n+(n-1)+(n-2)+...+1
     *             = n(n+1)/2
     *             = O(n^2)
      *             and for every string I am checking if its a palindrome
      *            so, T(n) = O(n^3)  */
    public String longestPalindromicSubString(String str){
        int maxLength = 0;
        String longestPalindromicSubstring = new String();
        for(int len=1;len<=str.length();len++){
            for(int c1=0;c1<=(str.length()-len);c1++){
                String s1 = str.substring(c1,c1+len);
                if(isPalindrome(s1) && maxLength<len){
                    longestPalindromicSubstring = s1;
                    maxLength = len;
                }
            }
        }
        return longestPalindromicSubstring;
    }

    /* T(n) = O(n).*/
    private boolean isPalindrome(String str){
        boolean isPalindrome;
        isPalindrome = str.equals(new StringBuffer(str).reverse().toString());
        return isPalindrome;
    }

/* using Dynamic programming to find LongestPalindromic substring,
 *    T(n) = O(n^2)
  *    here we are reducing the complexity from O(n^3) to O(n^2) by avoiding calling
  *                      isPalindrome(String str). */
    public String dynamicLongestPalindromicSubstring(String str){
        boolean[][] result = new boolean[str.length()][str.length()];
        //Arrays.fill(result,false);
        String longestPalindromicSubstring = new String();
        /*int maxLength = 0;*/
        /* all strings of length 1 are palindromes*/
        for(int c1=0;c1<str.length();c1++){
           result[c1][c1] = true;
            /*maxLength = 1;*/
            longestPalindromicSubstring = Character.toString(str.charAt(c1));
        }
        /* check for substrings of length 2*/
        for(int c2=0;c2<str.length()-1;c2++){
            if(str.charAt(c2)==str.charAt(c2+1)){
                result[c2][c2+1] = true;
                /*maxLength = 2;*/
                longestPalindromicSubstring = str.substring(c2,c2+2);
            }

        }

        for(int len=3;len<=str.length();len++){
            for(int c3=0;c3<str.length()-len-1;c3++){
                if(str.charAt(c3)==str.charAt(c3+len-1) && result[c3+1][c3+len-2]){
                    result[c3][c3+len-1] = true;
                    /*maxLength = len;*/
                    longestPalindromicSubstring = str.substring(c3,c3+len);
                }

            }
        }
        /*System.out.println("Length: "+maxLength);*/
        return longestPalindromicSubstring;
    }

}
