package leetcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*source: https://leetcode.com/problems/jump-game-ii/description/
* */
public class JumpGame2 {

    /* runnable method. */
    public static void main(String[] args){
        try {
            try(BufferedReader reader = new BufferedReader(new FileReader("jump2.txt"))){
                try(Scanner sc = new Scanner(reader)){
                    String[] strs = sc.nextLine().split(",");
                    int[] nums = new int[strs.length]; int index = 0;
                    for(String str:strs){
                        nums[index++] = Integer.valueOf(str);
                    }
                    System.out.println(jump(nums));
                    System.out.println(jump2(nums));
                    System.out.println(jump3(nums));
                    sc.close();
                }
            }
        }catch(FileNotFoundException exception){
            System.out.println(exception.getMessage());
            System.out.println(exception);
        }catch(java.io.IOException exception){
            System.out.println(exception.getMessage());
            System.out.println(exception);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    /* T(n) = O(n^2) and
    *  space complexity = O(n). */
    private  static int jump(int[] nums) {
        int[] result = new int[nums.length];
        for(int m1=1;m1<nums.length;m1++){
            result[m1] = Integer.MAX_VALUE;
            for(int m2=0;m2<m1;m2++){
                if((m2+nums[m2]) >= m1){
                    result[m1] = Math.min(result[m1],1+result[m2]);
                }
            }
        }
        return result[result.length-1];
    }

    /* T(n)=O(n^2), BreadthFirstTraversal and
    * space complexity = O(n). */
    private static int jump2(int[] nums){
        int[] result = new int[nums.length];
        outerLoop:
        for(int c1=0;c1<nums.length-1;c1++){
            for(int c2=c1+1;c2<=(c1+nums[c1]);c2++){
                if(result[c2]==0){
                    result[c2] = result[c1]+1;
                    if(c2==nums.length-1)
                        break outerLoop;
                }
            }
        }
        return result[result.length-1];
    }

    /* T(n)=O(n), linear time and
    * space complexity = O(1), constant time. */
    private static int jump3(int[] nums){
        int moves = 0;
        int lastElementIndex = 0;
        int nextLastSoFar = 0;
        for(int m1=0;m1<nums.length;m1++){
            int c = m1+nums[m1];
            nextLastSoFar = Math.max(nextLastSoFar,c);
            nextLastSoFar = Math.min(nextLastSoFar,nums.length-1);
            if(nextLastSoFar==nums.length-1) return ++moves;
            if(m1==lastElementIndex){
                moves++;
                lastElementIndex = nextLastSoFar;
            }
        }
        return moves;
    }


}
