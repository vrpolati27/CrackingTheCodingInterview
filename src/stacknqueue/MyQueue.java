package stacknqueue;

/**
 * Created by vinayreddypolati on 7/16/17.
 */
public class MyQueue<T> {
    private static class QueueNode<T>{
        T data;
        QueueNode<T> next;
        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> front;
    private QueueNode<T> back;

    public void push(T item){
       QueueNode<T> node = new QueueNode(item);
       if(isEmpty()){
           front = node;
           back = front;
       }else{
           back.next = node;
           back = node;
       }
    }
    public T pop() throws Exception{
        if(isEmpty()) throw new Exception("EmptyQueueException");
        QueueNode<T> node = front;
        front = front.next;
        if(front==null) back = null;
        node.next = null;
        return node.data;
    }
    public T peek() throws Exception{
        if(isEmpty()) throw new Exception("EmptyQueueException");
        return front.data;
    }
    public boolean isEmpty(){
        return front==null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(!isEmpty()){
          QueueNode<T> curr = front;
          while(curr.next!=null){
              sb.append(curr.data+", ");
              curr = curr.next;
          }sb.append(curr.data);
        } sb.append("]");
        return sb.toString();
    }
}
