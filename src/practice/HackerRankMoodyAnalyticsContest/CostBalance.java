package practice.HackerRankMoodyAnalyticsContest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 sourec: https://www.hackerrank.com/contests/moodys-analytics-fall-university-codesprint/challenges/cost-balancing */
public class CostBalance {
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int totalTransactions = sc.nextInt();
         int friendsCount = sc.nextInt();
         int[][] transactions = new int[totalTransactions][2];
         for(int c1=0;c1<transactions.length; c1++){
             int tranId = sc.nextInt();
             int amount = sc.nextInt();
             transactions[c1][0] = tranId;
             transactions[c1][1] = amount;
         }
         splitwise(transactions,friendsCount);
         sc.close();
     }

     private static void splitwise(int[][] transactions, int friendsCount){
         int[] transSheet = new int[friendsCount];
         Arrays.fill(transSheet,0);
         int tripTotalExpenses = 0;
         for(int[] transaction: transactions){
             tripTotalExpenses += transaction[1];
             transSheet[transaction[0]-1] += transaction[1];
         }

         int eachSplitAmount = tripTotalExpenses/transSheet.length;
         int anitaShare = eachSplitAmount + (tripTotalExpenses % friendsCount);
         System.out.println("1 "+(transSheet[0]-anitaShare));
         for(int c=1;c<transSheet.length;c++){
             System.out.println((c+1)+" "+(transSheet[c]-eachSplitAmount));
         }
     }
}
