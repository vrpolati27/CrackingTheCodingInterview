package practice;

import java.util.Arrays;
import java.util.Scanner;

/*
source: https://www.hackerrank.com/contests/moodys-analytics-fall-university-codesprint/challenges/modified-subsequence-sum
  */
public class ModifiedSubsequenceSum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] array = new long[n]; int lastPositiveIndex = -1;
        for(int c=0; c<array.length; c++){
            array[c] = sc.nextLong();
            if(array[c]>0)
                lastPositiveIndex = c;
        }
        System.out.println(maxSubsequenceum(array,k,lastPositiveIndex));
        sc.close();
    }

    private static long maxSubsequenceum(long[] array,int k, int tillIndex){
        long output = Integer.MIN_VALUE;
        if(array.length > 0){
            output = Math.max(output, array[0]);
            for(int c1=1;c1<=tillIndex;c1++){
                long current = array[c1];
                for(int c2=0; c2<c1; c2++){
                    long temp = (long)(current - (k* Math.pow((c1-c2)-1,2)));
                    temp = array[c2] + temp;
                    array[c1] = Math.max(array[c1],temp);
                }
                output = Math.max(output, array[c1]);
            }
        }
        return output;
    }
}
