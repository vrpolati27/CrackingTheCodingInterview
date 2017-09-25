package ctci.ArraysNstrings;

import java.util.Arrays;

public class IsUnique {
    public static void main(String[] args){
      String str = "abcdefghIXZmN";
      System.out.println(str+" is unique character string: "+isUniqueCharString(str));
      System.out.println(str+" is unique character string: "+isUniqueCharString2(str));
      System.out.println(str+" is unique character string: "+isUniqueCharString3(str));
      System.out.println(str+" is unique character string: "+isUniqueCharString4(str));
    }

    /* checks if string has all unique characters.
     T(n)=O(n^2), space complexity = O(1). */
    private static boolean isUniqueCharString2(String str){
        if(str.length()>26) return false;
        str = str.toLowerCase();
        boolean isUniqueCharString = true;
        c:for(int c1=0;c1<str.length();c1++){
            char ch1 = str.charAt(c1);
            for(int c2=c1+1;c2<str.length();c2++){
                if(ch1==str.charAt(c2)){
                    isUniqueCharString = false;
                    break c;
                }
            }
        }
        return isUniqueCharString;
    }

    /* returns true if string has all unique characters, false otherwise.
      T(n)=O(n), space complexity = O(n). */
    private static boolean isUniqueCharString(String str){
        if(str.length()>26) return false;
        boolean isUniqueCharString = true;
        str = str.toLowerCase();
        int[] chs = new int[26];
        Arrays.fill(chs,0);
        for(char ch:str.toCharArray()){
            chs[ch-'a']+=1;
            if(chs[ch-'a']>1){
                isUniqueCharString = false;
                break;
            }
        }
        return isUniqueCharString;
    }

    /* T(n)=O(n) and space complexity = O(1). */
    private static boolean isUniqueCharString3(String str){
        if(str.length()>26) return false;
        int checker = 0;
        boolean isUniqueCharString = true;
        for(int c1=0;c1<str.length();c1++){
          int val = str.charAt(c1)-'a';
          int x = (1<<val);
          if((checker&x)>0){
              isUniqueCharString = false;
              break;
          }
          checker = checker|x;
        } return isUniqueCharString;
    }


    /* T(n)=O(nlogn).
        space complexity = O(n),
        if you sort the string in place n compare subsequent characters then
         space complexity = O(1). */
    private static boolean isUniqueCharString4(String str){
        if(str.length()>26) return false;
        str = str.toLowerCase();
        char[] chs =  str.toCharArray();
        Arrays.sort(chs);
        for(int c=0;c<chs.length-1;c++){
            if(chs[c]==chs[c+1]) return false;
        }
        return true;
    }
}
