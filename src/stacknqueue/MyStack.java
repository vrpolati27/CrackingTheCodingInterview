package stacknqueue;

/**
 * Created by vinayreddypolati on 7/16/17.
 */
public class MyStack<T> {
    private static class StackNode<T>{
        T data;
        StackNode<T> next;
        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    /* returns true if Stack is Empty, false otherwise.
    * T(n) = O(1).*/
    public boolean isEmpty(){
        return top==null;
    }


    public void push(T element){
       StackNode<T> node = new StackNode(element);
       node.next = top;
       top = node;
    }

    /* remove and return top element in the Stack,
     *  T(n) = O(1). */
    public T pop() throws Exception{
        if(isEmpty()) throw new Exception("EmptyStack Exception");
        StackNode<T> temp = top;
        top = top.next;
        temp.next = null;
        return temp.data;
    }

    /* returns top element in the Stack,
    *  T(n) = O(1).*/
    public T peek() throws Exception {
        if(isEmpty()) throw new Exception("");
        return top.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[");
        if(!isEmpty()){
            StackNode<T> curr = top;
            while(curr.next!=null){
                sb.append(curr.data+", ");
                curr = curr.next;
            }sb.append(curr.data);
        }
        sb.append("]");
        return sb.toString();
    }
}
