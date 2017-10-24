package leetcode;

import ctci.stacksNqueues.MyStack;

public class LargestRectangleInHistogram {
    public static void main(String[] args){
        int[] heights = {0,0,0,0,0,0,0,0,Integer.MAX_VALUE};
        //System.out.println(largestRectangleArea(heights));
        System.out.print(maxRectangleArea(heights));
    }

    /* T(n) = O(sum(heights)) and
    *  space complexity = O(sum(heights)). */
    private static int largestRectangleArea(int[] heights){
        int maxArea = 0;
        if(heights.length > 0){
            int[][] matrix = new int[heights.length][];
            matrix[0] = new int[heights[0]];
            for(int m1=0; m1<matrix[0].length; m1++){
                matrix[0][m1] = m1+1;
                if(matrix[0][m1] > maxArea)
                    maxArea = matrix[0][m1];
            }
            for(int c1=1; c1 < heights.length; c1++){
                matrix[c1] = new int[heights[c1]];
                for(int c3=0; c3<matrix[c1].length; c3++){
                    int prevResult = matrix[c1-1].length > c3 ? matrix[c1-1][c3]: 0;
                    matrix[c1][c3] = prevResult + (c3+1);
                    if(matrix[c1][c3] > maxArea)
                        maxArea = matrix[c1][c3];
                }
            }
        }
        return maxArea;

    }

    private static int maxRectangleArea(int[] heights){
        int maxArea = 0;
        MyStack<Integer> stack = new MyStack<>();
        for(int c1=0;c1<heights.length;c1++){
            if(!(stack.isEmpty() ||
                    heights[stack.peek()] <= heights[c1])){
                /* empty the stack*/
                while(!stack.isEmpty() && stack.peek()>heights[c1]){
                    int area = heights[stack.peek()]*(c1-stack.pop());
                    maxArea = Math.max(area,maxArea);
                }
            }
            stack.push(c1);
        }
        while(!stack.isEmpty()){
            int area = heights[stack.peek()]*(heights.length-stack.pop());
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
