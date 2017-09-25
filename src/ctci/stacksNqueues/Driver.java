package ctci.stacksNqueues;

import java.util.Stack;

public class Driver {

    public static void main(String[] args){
        stackDemo();
        System.out.println("--------------------------------");
        queueDemo();
        System.out.println("--------------------------------");
        demo3in1();
        System.out.println("--------------------------------");
        stackMinDemo();
        System.out.println("--------------------------------");
        setofStacksDemo();
        System.out.println("--------------------------------");
        queuevia2stacksDemo();
        System.out.println("--------------------------------");
        animalShelterDemo();
    }

    /* this demonstrates MyQueue.*/
    private static void queueDemo(){
      MyQueue<Integer> queue = new MyQueue<>();
      queue.enqueue(1); queue.enqueue(2); queue.enqueue(3);
        queue.enqueue(4); queue.enqueue(5); queue.enqueue(6);
        queue.enqueue(7); queue.enqueue(8); queue.enqueue(9);
        queue.enqueue(10);

        while(!queue.isEmpty()){
            System.out.print(queue.dequeue());
        } System.out.println();
    }

    /* this demonstrates MyQStack. */
    private static void stackDemo(){
        Node linkedList = new Node(10);
        linkedList.appendToTail(9); linkedList.appendToTail(8); linkedList.appendToTail(7) ;
        linkedList.appendToTail(6); linkedList.appendToTail(5); linkedList.appendToTail(4);
        linkedList.appendToTail(3); linkedList.appendToTail(2); linkedList.appendToTail(1);
        System.out.println("LinkedList is :"+ linkedList);
        /* prints kth to the last element in a LinkedList. */
        int k = 7;
        MyStack<Node> stack = new MyStack<>();
        Node c = linkedList;
        while(c!=null){
            stack.push(c);
            c = c.next;
        }

        int m1 = 0;
        while(!stack.isEmpty() && m1<k){
            if(m1==(k-1)){
                System.out.println(k+"th node from end in a LinkedList is :"+
                    stack.peek().data);
                break;
            }
            stack.pop();
            m1++;
        } if(stack.isEmpty()) System.out.println("oopc! stack size is < "+k);

    }

    /* This method demonstrates 3.1 Three in one /* implementing 3stacks using 1 array.*/
    private static void demo3in1(){
        Stack3<Integer> stack3 = new Stack3<>(5,.75f);
        try{
            stack3.push(0,11);
            stack3.push(0,12);
            stack3.push(0,13);
            stack3.push(0,14);
            stack3.push(1,21);
            stack3.push(1,22);
            stack3.push(1,23);
            stack3.push(2,31);
            stack3.push(2,32);
            System.out.print("3 stacks initially are as Follows\n"+stack3);

            stack3.push(0,15); stack3.push(0,16);
            System.out.println("\nstack1.peek():"+stack3.peek(1));
            stack3.pop(1);
            stack3.push(2,33);stack3.push(2,34);
            stack3.push(2,35);stack3.push(2,36);
            stack3.push(2,37);
            System.out.println("stack2.peek():"+stack3.peek(2));
            System.out.println("After modification stack is as Follows\n"+ stack3);

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    /* this method tests 3.2 StackMin*/
    private static void stackMinDemo(){
        StackMin<Integer> stack = new StackMin<>();
        stack.push(32); stack.push(3); stack.push(24);
        stack.push(6); stack.push(2); stack.push(76);
        stack.push(84); stack.push(31); stack.push(1);
        stack.push(100); /* stack:-> [ 32,3,24,6,2,76,84,31,1,100]*/
        while(!stack.isEmpty()){
            try{
                System.out.println("minimum element so Far:"+stack.getMin());
                System.out.println("pop():"+stack.pop());
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    /* this method checks for the correctness of 3.3 SetOfStacks. */
    private static void setofStacksDemo(){
        SetOfStacks<Integer> stacksets = new SetOfStacks<>(4);
        stacksets.push(1); stacksets.push(2); stacksets.push(3);
        stacksets.push(4); stacksets.push(5); stacksets.push(6);
        stacksets.push(7); stacksets.push(8); stacksets.push(9);
        stacksets.push(10); stacksets.push(11); stacksets.push(12);
        try{
            System.out.println("stack.peekAt(2)"+stacksets.peekAt(2));
            System.out.println("stack.peekAt(1)"+stacksets.peekAt(1));
            System.out.println("stack.peekAt(0)"+stacksets.peekAt(0));
            System.out.println("stack.popAt(1)"+stacksets.popAt(1));
            System.out.println("stack.popAt(0)"+stacksets.popAt(0));
            while(!stacksets.isEmpty()){
                System.out.println("stack.peek():"+stacksets.peek());
                stacksets.pop();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /* this method checks for the correctness of 3.4 queue via 2 stacks.*/
    private static void queuevia2stacksDemo(){
        Queue_2Stacks<Integer> queue = new Queue_2Stacks<>();
        queue.push(1); queue.push(2); queue.push(3);
        queue.push(4); queue.push(5); queue.push(6);
        try{
            /*-> [1,2,3,4,5,6]*/
            System.out.println("queue.peek() :"+queue.peek()); /* 1*/
            queue.push(7);
            System.out.println("queue.pop() :"+queue.pop()); /* 1*/
            queue.push(8); queue.push(9); queue.push(10);
            /* [ 2,3,4,5,6,7,8,9,10]*/
            while(queue.isEmpty()){
                System.out.println("queue.peeK() :"+queue.peek());
                queue.pop();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    /* this method checks for the correctness of 3.6 Animal shelter */
    private static void animalShelterDemo(){
      AnimalShelter shelter = new AnimalShelter();
      shelter.push(new Cat("cat1"));
        shelter.push(new Dog("dog1"));
        shelter.push(new Dog("dog2"));
        shelter.push(new Cat("cat2"));
        shelter.push(new Cat("cat3")); shelter.push(new Cat("cat4"));
        shelter.push(new Dog("dog3")); shelter.push(new Cat("cat5"));
        shelter.push(new Cat("cat6")); shelter.push(new Dog("dog4"));
        shelter.push(new Dog("dog5")); shelter.push(new Cat("cat7"));
        shelter.push(new Cat("cat8")); shelter.push(new Dog("dog6"));
        shelter.push(new Dog("dog7")); shelter.push(new Dog("dog8"));
        shelter.push(new Dog("dog9")); shelter.push(new Dog("dog10"));
        shelter.push(new Cat("cat9")); shelter.push(new Cat("cat10"));
        shelter.push(new Cat("cat11")); shelter.push(new Cat("cat12"));
        try{
            System.out.println("popDog() :"+shelter.pop(1).name);/* dog1*/
            System.out.println("popDog() :"+shelter.pop(1).name);/* dog2*/
            System.out.println("pop() :"+shelter.pop(2).name);/* cat1*/
            System.out.println("popDog() :"+shelter.pop(1).name);/* dog3*/
            System.out.println("popCat() :"+shelter.pop(0).name);/* cat2*/
            System.out.println("pop() :"+shelter.pop(2).name);/* cat3*/
            System.out.println("popCat() :"+shelter.pop(0).name);/* cat4*/
            while(!shelter.isEmpty()){
                System.out.println("pop() :"+shelter.pop(2).name);
                   /* [c5,c6,d4,d5,c7,c8,d6,d7,d8,d9,d10,c9,c10,c11,c12]*/
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }

    /* T(n)=O(n). */
    public void appendToTail(int c1){
        Node end = new Node(c1);
        Node cur = this;
        while(cur.next!=null){
            cur = cur.next;
        } cur.next = end;
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("[");
        Node cur = this;
        while(cur!=null){
            content.append(cur.data+", ");
            cur = cur.next;
        }
        content.append("]");
        return content.toString();
    }
}