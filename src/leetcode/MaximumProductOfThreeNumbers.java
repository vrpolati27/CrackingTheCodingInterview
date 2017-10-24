package leetcode;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    public static void main(String[] args){
       int[] array = {-4,14,5,6,-13,-12,4,5,34};
       System.out.println(maximumProduct(array));
        System.out.println(maxProduct(array));
    }

    /* T(n) = O(nlogn) and
     * space complexity = O(1)  */
    private static int maximumProduct(int[] nums){
        Arrays.sort(nums);
        int maxProduct = Integer.MAX_VALUE;
        int lastIndex = nums.length-1;
        int _3positive = nums[lastIndex] * nums[lastIndex-1] * nums[lastIndex-2];
        int _2Negative1Positive = nums[lastIndex] * nums[0] * nums[1];
        maxProduct = Math.max(_3positive, _2Negative1Positive);
        return maxProduct;
    }

    /* T(n) = O(n) and
    *  space complexity = O(1).
    *  parse array and Find 3 largest numbers and 2 smallest numbers,
     *  maxProduct = Max(product(3large), product(2mall,1large));*/
    private static int maxProduct(int[] numbers){
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int number: numbers){
            if(number > max1){
                max3 = max2;
                max2 = max1;
                max1 = number;
            }else if(number > max2){
                max3 = max2;
                max2 = number;
            }else if(number > max3){
                max3 = number;
            }

            if(number < min1){
                min2 = min1;
                min1 = number;
            }else if(number < min2){
                min2 = number;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
