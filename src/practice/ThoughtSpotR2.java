package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vinayreddypolati on 7/25/17.
 */
public class ThoughtSpotR2 {
    public static void main(String[] args){
       int[] coins = new int[/*2000*/30];
       int totalSum = 0;
       System.out.print("[");
       for(int c1=0;c1<coins.length-1;c1++){
           coins[c1] = (int)(Math.random()*10+1);/* 1 to 100 */
           totalSum += coins[c1];
           System.out.print(coins[c1]+" ");
       } coins[coins.length-1] = (int)(Math.random()*143+1);
         totalSum += coins[coins.length-1];
         System.out.println(coins[coins.length-1]+"]");
         List<Integer> indices = new ArrayList<>((coins.length+1)/2);
         System.out.println("player1 maxScore: "+maxMoney(coins,indices));
       /*System.out.println(indices);*/
       System.out.println("---------------------------------------");
       Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
       for(int c1=0;c1<coins.length;c1++){
           map.put(c1+1,new HashMap<>());
       }
       System.out.println("player1 maxScore: "+maxScore(coins,coins.length,0,map,totalSum));
    }

    private static int maxMoney(int[] coins,List<Integer> indices){
        int maxScore = maxMoney(coins,coins.length,0);
        return maxScore;
    }


    /* returns Amount of maximum money player1 can get.
       T(n) = O(n)+2T(n-1)
    *       = O(2^n). */
    private static int maxMoney(int[] coins,int coinsCount,int startIndex){
        int maxScore = 0;
        if(coinsCount==1) maxScore = coins[startIndex];
        else{
          maxScore = Math.max(coins[startIndex]+sum(coins,coinsCount-1, startIndex+1)-maxMoney(coins,coinsCount-1, startIndex+1),
                  coins[coinsCount+startIndex-1]+sum(coins,coinsCount-1,startIndex)-maxMoney(coins,coinsCount-1,startIndex));
        }return maxScore;
    }

    /* returns sum of first #coinsCount coins starting from startIndex */
    private static int sum(int[] coins,int coinsCount,int startIndex){
        int sum = 0;
        for(int c1=startIndex;c1<startIndex+coinsCount;c1++){
            sum += coins[c1];
        }
        return sum;
    }

    /* T(n) = (n-1)c1+T(n-1)
       T(n) = (n-1)c1+(n-2)c1+T(n-2)
            = c1(1+2+3+...+n-1)+T(1)
            = O(n(n-1)/2)
            = O(n^2).
    * */
    private static int maxScore(int[] coins, int coinsCount, int startIndex,
                                Map<Integer,Map<Integer,Integer>> map, int totalSum){
        int maxScore = 0;
        if(coinsCount==1) maxScore = coins[startIndex];
        else{
          int c1 = map.get(coinsCount-1).getOrDefault(startIndex+1,-1)==-1?
                  maxScore(coins,coinsCount-1,startIndex+1,map,
                          totalSum-coins[startIndex]):
                  map.get(coinsCount-1).get(startIndex+1);
          map.get(coinsCount-1).put(startIndex+1,c1);
          int c2 = map.get(coinsCount-1).getOrDefault(startIndex,-1)==-1?
                  maxScore(coins,coinsCount-1,startIndex,map,
                          totalSum-coins[coinsCount+startIndex-1]):
                  map.get(coinsCount-1).get(startIndex);
          map.get(coinsCount-1).put(startIndex,c2);
          maxScore = Math.max(totalSum-c1,totalSum-c2);
        } return maxScore;
    }
}
