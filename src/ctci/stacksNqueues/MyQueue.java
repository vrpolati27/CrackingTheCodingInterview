package ctci.stacksNqueues;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private static class QueueNode<T>{
        T data;
        QueueNode<T> next;

        /* constructor*/
        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> front;
    private QueueNode<T> end;
    public int size;

    public void enqueue(T element){
       QueueNode<T> node = new QueueNode<>(element);
       size = size+1;
       if(end!=null){
           end.next = node;
       }else{
           front = node;
       } end = node;

    }

    public T dequeue() throws NoSuchElementException{
      if(isEmpty()) throw new NoSuchElementException();
      T start = front.data;
      front = front.next;
      if(front==null) end = null;
      size = size-1;
      return start;
    }

    public T peek() throws NoSuchElementException{
        if(isEmpty()) throw new NoSuchElementException();
        T start = front.data;
        return start;
    }

    public boolean isEmpty(){
        return front==null;
    }
}
