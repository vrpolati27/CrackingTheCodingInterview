package ctci.ExtraPractice;

import java.util.*;

/**
 * Created by vinayreddypolati on 7/4/17.
 */
public class _3_LongestUniqueSubstring {

    /* T(n) = O(n^2) */
    public int longestUniqueSubstring(String str){
        int maxLength = 0;
        Set<Character> set = new HashSet<Character>();
        int length = 0;
        for(int c1=0;c1<str.length();c1++){
            length = 1;
            set.add(str.charAt(c1));
            for(int c2=c1+1;c2<str.length();c2++){
                if(!set.add(str.charAt(c2))){
                    if(length>maxLength) maxLength = length;
                    break;
                }length++;
            }
            set.clear();
        }
        return maxLength;
    }

    /* T(n) = O(n)*/
    public int _hashLongestUniqueSubstring(String str){
        int maxLength = 0;
        if(str.length()>0){
            Map<Character,Integer> map = new HashMap<Character,Integer>();
            int startIndex = 0;
            for(int c1=0;c1<str.length();c1++){
                char ch = str.charAt(c1);
                if(map.getOrDefault(ch,-1)!=-1 && map.get(ch)>=startIndex){
                    startIndex = map.get(ch)+1;
                }map.put(ch,c1);
                maxLength = Math.max(maxLength,c1-startIndex+1);
            }
        }return maxLength;
    }

}
