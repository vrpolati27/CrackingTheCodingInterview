package ctci.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDups {

    public static void main(String[] args){
      /* constructing a LinkedList. */
      Node head = new Node(getRandomNum(0,4));
      head.appendToTail(getRandomNum(0,5));
        head.appendToTail(getRandomNum(0,5));
        head.appendToTail(getRandomNum(0,5));
        head.appendToTail(getRandomNum(0,5));
        head.appendToTail(getRandomNum(0,5));
        head.appendToTail(getRandomNum(0,5));
        print(head);
        //removeDups(head);
        removeDups2(head);
        print(head);
    }

    /* This methods prints elements in a LinkedList onto console.
      T(n)=O(n), linear time.
      where n is the number of Nodes in a list. */
    private static void print(Node head){
      System.out.println();
      System.out.print("[");
      while(head!=null){
          System.out.print(head.data+" ");
          head = head.next;
      }
      System.out.println("]");
    }


    /* This method removes duplicates from a given LinkedList.
      T(n)=O(n^2) and space complexity = O(1). */
    private static void removeDups2(Node head){
        Node c1 = head;
        while(c1.next!=null){
            Node prev = c1;
            Node c2 = prev.next;
            while(c2!=null){
                if(c2.data==c1.data)
                    prev.next = c2.next;
                else prev = prev.next;
                c2 = c2.next;
            } c1 = c1.next;
        }
    }

    /* This method removes duplicate entries in a LinkedList.
       T(n) = O(n) and space complexity = O(n). */
    public static void removeDups(Node head){
        Node c1 = head;
        Map<Integer,Integer> set = new HashMap<>();
        set.put(c1.data,1);
        while(c1.next!=null){
            if(set.getOrDefault(c1.next.data,0)==0){
                set.put(c1.next.data,1);
                c1 = c1.next;
            }
            else c1.next = c1.next.next;
        }
    }

    /* generates a Random integer [lower,upper)
       T(n)=O(1). constant time. */
    private static int getRandomNum(int lower, int upper){
         return (int)(Math.random()*(upper-lower))+lower;
    }
}


class Node{
    Node next;
    int data;

    public Node(int data){
        this.data = data;
    }

    /* This method appends a Node to the end of a given node in LinkedList.
     T(n) = O(n). */
    public void appendToTail(int d1){
        Node end = new Node(d1);
        Node c1 = this;
        while(c1.next!=null)
            c1 = c1.next;
        c1.next = end;
    }

    public void appendToTail(Node end){
       Node c1 = this;
       while(c1.next!=null){
           c1 = c1.next;
       } c1.next = end;
    }

}


