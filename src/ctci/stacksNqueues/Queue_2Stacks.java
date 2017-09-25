package ctci.stacksNqueues;

import java.util.Stack;

public class Queue_2Stacks<T>{
   private Stack<T> newestStack;
   private Stack<T> oldestStack;

   /* pushes an element into the queue..*/
   public void push(T element){
      if(newestStack==null)
          newestStack = new Stack<>();
      if(oldestStack!=null && !oldestStack.isEmpty()){
          while(!oldestStack.isEmpty()){
              newestStack.push(oldestStack.pop());
          }
      }
      newestStack.push(element);
   }

   /* dequeue the element in a Queue. */
   public T pop() throws Exception{
     if(oldestStack==null)
         oldestStack = new Stack<>();
     if(newestStack==null || (newestStack.isEmpty() && oldestStack.isEmpty()))
         throw new Exception();
     if(!newestStack.isEmpty()){
        while(!newestStack.isEmpty()){
            oldestStack.push(newestStack.pop());
        }
     } return oldestStack.pop();
   }

   /* peek first element to be out in a Queue*/
   public T peek() throws Exception{
       if(oldestStack==null)
           oldestStack = new Stack<>();
       if(newestStack==null || (newestStack.isEmpty() && oldestStack.isEmpty()))
           throw new Exception();
       if(!newestStack.isEmpty()){
           while(!newestStack.isEmpty()){
               oldestStack.push(newestStack.pop());
           }
       } return oldestStack.peek();
   }

   public boolean isEmpty(){
       if(newestStack==null) return true;
       return !newestStack.isEmpty() || !oldestStack.isEmpty();
   }

}
