package practice;

public class TripleByteR2 {

    public static void main(String[] args){
       String bracketString = "())";
       System.out.println(bracketMatch(bracketString));
       String s1 = "at"; String s2 = "cat";
       System.out.println(asciiDeletionDistance(s1,s2));
    }

    private static int asciiDeletionDistance(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        dp[0][0] = 0;
        /* update First row. */
        for(int c1=1;c1<dp[0].length;c1++)
            dp[0][c1] = dp[0][c1-1] + str2.charAt(c1-1);
        /*update First column.*/
        for(int c2=1;c2<dp.length;c2++)
            dp[c2][0] = dp[c2-1][0] + str1.charAt(c2-1);
        for(int row=1;row<dp.length;row++){
            for(int col=1;col<dp[row].length;col++){
                int mn1 = str1.charAt(row-1) == str2.charAt(col-1) ? 0:
                     str1.charAt(row-1)+str2.charAt(col-1);
                int case1 = dp[row-1][col-1] + mn1;
                int case2 = dp[row][col-1] + str2.charAt(col-1);
                int case3 = dp[row-1][col] + str1.charAt(row-1);
                dp[row][col] = case1 < case2 ? (case1 < case3 ? case1: case3) :
                                    ( case2 < case3 ? case2 : case3);
            }
        }
        return dp[str1.length()][str2.length()];
    }

    /* returns minimum number of brackets we have to add to make a string
    * balanced.
    * T(n) = O(n), linear time. */
    private static int bracketMatch(String bracketString){
       int minBrackets = 0;
       int openBracketsSoFar = 0;
       for(int c1=0;c1<bracketString.length();c1++){
           char ch = bracketString.charAt(c1);
           if(ch == '('){
               openBracketsSoFar++;
           }else if(ch == ')'){
               if(openBracketsSoFar==0){
                   minBrackets++;
               }else{
                   openBracketsSoFar--;
               }
           }
       }
       minBrackets += openBracketsSoFar;
       return minBrackets;
    }

}
