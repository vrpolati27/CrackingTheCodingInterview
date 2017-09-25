package ctci.ArraysNstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {


    public static void main(String[] args){
        String s1 = "abcdefg";
        String s2 = "cegfdba";
        System.out.println("isPermutation("+s1+","+s2+"):"+isPermutation(s1,s2));
    }

    /* This method returns true if s1 is permutation of s2, false otherwise.
      T(n)=O(s1.length()), space complexity = O(n) */
    private static boolean isPermutation(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        boolean isPermutation = true;
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int c1=0;c1<s1.length();c1++){
            char ch1 = s1.charAt(c1);
            frequencyMap.put(ch1,frequencyMap.getOrDefault(ch1,0)+1);
        }

        for(int c2=0;c2<s2.length();c2++){
            char ch=s2.charAt(c2);
            if(frequencyMap.getOrDefault(ch,0)==0){
                isPermutation = false;
                break;
            }
            frequencyMap.put(ch,frequencyMap.get(ch)-1);
        }
        return isPermutation;
    }

    /* T(n)=O(nlogn). where n = s1.length().
     This method sorts strings n then compare corresponding characters in both the strings.*/
    private static boolean isPermutation2(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        boolean isPermutation = true;
        char[] chs1 = s1.toCharArray();  Arrays.sort(chs1);
        char[] chs2 = s2.toCharArray();  Arrays.sort(chs2);
        for(int c1=0;c1<s1.length();c1++){
          if(chs1[c1]!=chs2[c1]){
              isPermutation = false;
              break;
          }
        } return isPermutation;
    }
}
