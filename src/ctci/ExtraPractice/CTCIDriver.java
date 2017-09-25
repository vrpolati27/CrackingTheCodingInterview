package ctci.ExtraPractice;

/**
 * Created by vinayreddypolati on 7/3/17.
 */
public class CTCIDriver {


    public static void main(String[] argc){
        
        /* Longest Palindromic Substring */
        longestPalindromicSubstring();
        newLine('-');
        /* Longest substring without repeating character */
        longestUniqueSubstring();
        newLine('-');
        /**/
    }

    private static void newLine(char ch){
        newLine(ch,100);
    }
    private static void newLine(char ch,int m1){
        for(int c1=0;c1<m1;c1++)
           System.out.print(ch);
        System.out.println();
    }
    private static void longestPalindromicSubstring(){
        /* Longest Palindromic Substring */
        String str = new String("forgeeksskeegfor"); /* solution is: geeksskeeg */
        String str2 = new String("babcbabcbaccba"); /* solution is: abcbabcba */
        LongestPalindromicSubString inst1 = new LongestPalindromicSubString();

        /* bruteForce method, T(n) = O(n^3)*/
        long startTime = System.nanoTime();
        System.out.println(/*"Longest palindromic substring in "+str+" is: "+*/
                inst1.longestPalindromicSubString(str));
        System.out.println(/*"Longest palindromic substring in "+str2+" is: "+*/
                inst1.longestPalindromicSubString(str2));
        long endTime = System.nanoTime();
        long programRunTime = endTime-startTime;
        System.out.println("Program runtime using Brute Force:"+programRunTime+"ns");

        /* dynamic programming, T(n) = O(n^2) */
        startTime = System.nanoTime();
        System.out.println(inst1.dynamicLongestPalindromicSubstring(str));
        System.out.println(inst1.dynamicLongestPalindromicSubstring(str2));
        endTime = System.nanoTime();
        programRunTime = endTime-startTime;
        System.out.println("Program runtime using DynamicProgramming:"+programRunTime+"ns");

    }

    private static void longestUniqueSubstring(){
        /* Longest substring without repeating character */
        _3_LongestUniqueSubstring longestUnique_inst1 = new _3_LongestUniqueSubstring();
        long startTime = System.nanoTime();
        /* T(n) = O(n^2)*/
        System.out.print(longestUnique_inst1.longestUniqueSubstring("abcdefdgabchf"));
        long endTime = System.nanoTime();
        System.out.println("\t runtime:"+(endTime-startTime)+" ns");
        /* T(n) = O(n) */
        startTime = System.nanoTime();
        System.out.print(longestUnique_inst1._hashLongestUniqueSubstring("abcdefdgabchf"));
        endTime = System.nanoTime();
        System.out.println("\t runtime:"+(endTime-startTime)+" ns");
    }
}
