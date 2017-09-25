package ctci.stacksNqueues;

public class StackMin<T extends Comparable<T>>{

    private static class TMinWrap<T>{
        T node;
        T minSoFar;
        TMinWrap<T> next;

        public TMinWrap(T node, T minSoFar){
            this.node = node;
            this.minSoFar = minSoFar;
        }

    }

    private TMinWrap<T> top;

    /* push an element onto stack
        * T(n)=O(1). */
    public void push(T element){
       T minimumSoFar = isEmpty()?null:top.minSoFar;
       T newMin = minimumSoFar==null?element:(element.compareTo(minimumSoFar)>0?minimumSoFar:element);
       TMinWrap<T> data = new TMinWrap<>(element,newMin);
       data.next = top;
       top = data;
    }

    /* pop an element from the top of a Stack.*/
    public T pop() throws Exception{
       if(isEmpty()) throw new Exception();
       T data = top.node;
       top = top.next;
       return data;
    }

    /* peek an Element*/
    public T peek() throws Exception{
        if(isEmpty()) throw new Exception();
        return top.node;
    }

    /* returns true if stack is empty, false otherwise.*/
    public boolean isEmpty(){
        return top==null;
    }

    /* returns minimum element in a stack.
       T(n)=O(1) constant time.*/
    public T getMin() throws Exception{
        if(isEmpty()) throw new Exception();
        return top.minSoFar;
    }

}
