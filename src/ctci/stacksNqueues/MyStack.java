package ctci.stacksNqueues;

import java.util.EmptyStackException;

public class MyStack<T> {
    /* This class is same as Legacy class Stack with following operations.
    *  push(T data) // T(n)=O(1)
    *  T pop()   // T(n) = O(1)
    *  T peek() and
    *  boolean isEmpty(). */

    private static class StackNode<T>{
        public T data;
        public StackNode<T> next;
        /* constructor. */
        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;
    private int size;

    /* pushes an Element onto top of the stack.
        T(n)=O(1).*/
    public void push(T element){
        StackNode<T> node = new StackNode<>(element);
        node.next = top;
        top = node;
        size = size+1;
    }

    /* pops an Element from the top of the stack
       T(n)=O(1).*/
    public T pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        T topElement = top.data;
        top = top.next;
        size = size - 1;
        return topElement;
    }

    /* T(n)=O(1) */
    public T peek() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        T topElement = top.data;
        return topElement;
    }

    /* returns true if stack is empty, false otherwise.*/
    public boolean isEmpty(){
        return top==null;
    }

    public int size(){
        return size;
    }

}
