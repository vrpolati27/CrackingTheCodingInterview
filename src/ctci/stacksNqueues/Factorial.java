package ctci.stacksNqueues;

import java.util.Stack;

public class Factorial {

    public static void main(String[] args){
        MyStack<Long> result = new MyStack<>();
        int c =14;
        factorial(c,result);
        System.out.println(" factorial of "+c+" is :"+result.pop());
        System.out.println(" factorial of "+c+" is :"+factorial2(c));
    }

    private static void factorial(int num, MyStack<Long> result){
        if(num<2) result.push(1L);
        else{
            factorial(num-1,result);
            long ans = num * result.pop();
            result.push(ans);
        }
    }

    private static long factorial2(int num){
        if(num<2) return 1;
        else{
            return num*factorial2(num-1);
        }
    }


}
