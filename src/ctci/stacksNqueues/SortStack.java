package ctci.stacksNqueues;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(3); stack.push(14);
        stack.push(6); stack.push(5);
        stack.push(23); stack.push(8);
        stack.push(48); stack.push(11); /* -> [3,14,6,5,23,8,48,11]*/
        sort(stack);
        System.out.print(" sorted stack: [");
        while(!stack.isEmpty()){
            System.out.print(stack.peek()+", ");
            stack.pop();
        } System.out.println("]");
    }

    /* T(n)=O(n^2).
     * this method uses 2 extra Stacks.  */
    private static void sort(Stack<Integer> stack){
        Stack<Integer> sortedStack = new Stack<>();
        Stack<Integer> buffer = new Stack<>();
       while(!stack.isEmpty()){
          int minSoFar = Integer.MAX_VALUE;
          while(!stack.isEmpty()){
              minSoFar = Math.min(minSoFar,stack.peek());
              buffer.push(stack.pop());
          }

          while(!buffer.isEmpty()){
              int data = buffer.peek();
              if(data==minSoFar)
                  sortedStack.push(buffer.pop());
              else stack.push(buffer.pop());
          }
       }

       while(!sortedStack.isEmpty())
           stack.push(sortedStack.pop());
    }

}
