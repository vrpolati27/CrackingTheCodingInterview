package leetcode;

public class TrappingRainWater {

    public static void main(String[] args){
         int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
         System.out.println("Total water :"+trap(heights));/* 6.*/
    }

    /* T(n)=O(n) and
    *  space complexity = O(n). */
    private static int trap(int[] heights){
        if(heights.length<3) return 0;
        int[] maxSoFarToLeft = new int[heights.length]; maxSoFarToLeft[0] = 0;
        int[] maxSoFarToRight = new int[heights.length]; maxSoFarToRight[0] = 0;
        for(int c=1;c<heights.length;c++){
            maxSoFarToLeft[c] = Math.max(maxSoFarToLeft[c-1],heights[c-1]);
            maxSoFarToRight[heights.length-1-c] =
                    Math.max(maxSoFarToRight[heights.length-c], heights[heights.length-c]);
        }

        int totalTrap = 0;
        for(int c1=0;c1<heights.length;c1++){
            int moreHeightOnLeft = maxSoFarToLeft[c1]-heights[c1];
            int moreHeightOnRight = maxSoFarToRight[c1]-heights[c1];
            if(moreHeightOnLeft>0 && moreHeightOnRight>0)
                totalTrap += Math.min(moreHeightOnLeft,moreHeightOnRight);
        } return totalTrap;
    }
}
