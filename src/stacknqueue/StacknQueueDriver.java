package stacknqueue;

import java.util.Stack;

/**
 * Created by vinayreddypolati on 7/16/17.
 */
public class StacknQueueDriver {
    public static void main(String[] args) throws Exception{
        myStackDemo();
        newLine("/*");
        /* Java in-built Stack. */
        inBuiltStackDemo();
        newLine("/*");
        /* MyQueue*/
        myQueueDemo();
        newLine("/*");
    }

    private static void newLine(String str){
        StringBuilder sb = new StringBuilder();
        for(int m1=0;m1<60;m1++)
            sb.append(str);
        System.out.println(sb);
    }
    private static void myStackDemo() throws Exception{
        MyStack<String> stack = new MyStack();
        System.out.print("push Vinay");stack.push("Vinay");
        System.out.println(stack);
        System.out.print("push Reddy");stack.push("Reddy");
        System.out.println(stack);
        System.out.print("push Polati");stack.push("Polati");
        System.out.println(stack);
        System.out.print("peek()");System.out.println(stack.peek());
        System.out.print("pop()");System.out.println(stack.pop());
        System.out.println(stack);

        System.out.print("push One");stack.push("One");
        System.out.println(stack);
        System.out.print("push Two");stack.push("Two");
        System.out.println(stack);
        System.out.print("push Three");stack.push("Three");
        System.out.println(stack);
        System.out.print("push Four");stack.push("Four");
        System.out.println(stack);
        System.out.print("push Five");stack.push("Five");
        System.out.println(stack);
        System.out.print("pop()");System.out.println(stack.pop());
        System.out.println(stack);
        System.out.print("pop()");System.out.println(stack.pop());
        System.out.println(stack);
        System.out.print("push Six");stack.push("Six");
        System.out.println(stack);
        System.out.print("push Seven");stack.push("Seven");
        System.out.println(stack);
    }

    /* demonstrates Java in built Stack class*/
    private static void inBuiltStackDemo(){
        Stack<Integer> stack = new Stack();
        System.out.println("push 1");stack.push(1);
        System.out.println(stack);
        System.out.println("push 2");stack.push(2);
        System.out.println(stack);
        System.out.println("push 3");stack.push(3);
        System.out.println(stack);
        System.out.println("push 4");stack.push(4);
        System.out.println(stack);
        System.out.println("pop()");stack.pop();
        System.out.println(stack);
        System.out.println("pop()");stack.pop();
        System.out.println(stack);
        System.out.println("isEmpty():"+stack.isEmpty());
        System.out.println("pop()");stack.pop();
        System.out.println(stack);
        System.out.println("pop()");stack.pop();
        System.out.println(stack);

    }

    private static void myQueueDemo() throws Exception{
        MyQueue<Integer> queue = new MyQueue();
        System.out.println("push 1");queue.push(1);
        System.out.println(queue);
        System.out.println("push 2");queue.push(2);
        System.out.println(queue);
        System.out.println("push 3");queue.push(3);
        System.out.println(queue);
        System.out.println("push 4");queue.push(4);
        System.out.println(queue);
        System.out.println("pop()");queue.pop();
        System.out.println(queue);
        System.out.println("pop()");queue.pop();
        System.out.println(queue);
        System.out.println("isEmpty():"+queue.isEmpty());
        System.out.println("pop()");queue.pop();
        System.out.println(queue);
        System.out.println("pop()");queue.pop();
        System.out.println(queue);
        System.out.println("isEmpty():"+queue.isEmpty());
        System.out.println("push 13");queue.push(13);
        System.out.println(queue);
        System.out.println("peek():"+queue.peek());
        System.out.println(queue);
    }


}
