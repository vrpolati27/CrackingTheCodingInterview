package ctci.stacksNqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks<T>{

    private int capacity;
    List<Stack<T>> stacks;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
        stacks = new ArrayList<>(3);
    }

    /* push
       T(n)=O(1). */
    public void push(T element){
        if(stacks.size()==0 || stacks.get(stacks.size()-1).size()==capacity){
            stacks.add(new Stack<>());
        }
        stacks.get(stacks.size()-1).push(element);
    }

    /* pop*/
    public T pop() throws Exception{
        if(isEmpty()) throw new Exception();
        T end = stacks.get(stacks.size()-1).pop();
        if(stacks.get(stacks.size()-1).size()==0)
            stacks.remove(stacks.get(stacks.size()-1));
        return end;
    }

    /* peek*/
    public T peek() throws Exception{
        if(isEmpty()) throw new Exception();
        T end = stacks.get(stacks.size()-1).peek();
        return end;
    }

    /* popAt, this method removes and returns top element at a given Stack number*/
    public T popAt(int index) throws Exception{
        if(index<0 || index>=stacks.size()) throw new Exception();
        T c1 = stacks.get(index).pop();
        if(stacks.get(index).size()==0)
            stacks.remove(index);
        return c1;
    }

    /* peekAt, this method returns top element at a given Stack number*/
    public T peekAt(int index) throws Exception{
        if(index<0 || index>=stacks.size()) throw new Exception();
        T c1 = stacks.get(index).peek();
        return c1;
    }

    public boolean isEmpty(){
        return stacks.size()==0;
    }


}
