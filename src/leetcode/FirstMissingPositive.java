package leetcode;

public class FirstMissingPositive {

    public static void main(String[] args){
       int[] nums = {0};
       System.out.println(" First missing positive integer :"+
                 firstMissingPositive(nums));
    }

    /* T(n)=O(n), Linear time and
    *  space complexity = O(1) */
    private static int firstMissingPositive(int[] nums){
       int pointer1 = 0; int pointer2 = nums.length-1;
       while(pointer1<=pointer2){
           while(pointer1<nums.length && nums[pointer1]>0)
               pointer1 = pointer1+1;
           while(pointer2>=0 && nums[pointer2]<=0)
               pointer2 = pointer2-1;
           /* swap wrongly placed entries*/
           if(pointer1<pointer2){
               int temp = nums[pointer1];
               nums[pointer1] = nums[pointer2];
               nums[pointer2] = temp;
           }
       }
       if(pointer2<0) return 1;
       else{
           for(int c=0;c<pointer1;c++){
               int num = Math.abs(nums[c]);
               if((num-1)<pointer1){
                   nums[num-1] = -1*Math.abs(nums[num-1]);
               }
           }

           for(int c=0;c<pointer1;c++){
               if(nums[c]>0) return (c+1);
           } return pointer2+2;
       }
    }
}
