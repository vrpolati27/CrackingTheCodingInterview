package ctci.linkedlist;

public class LinkedList{

  public static void main(String[] args){
     LinkedList list = new LinkedList();
      list.appendToTail(3);
      list.appendToTail(13);
      list.appendToTail(21);
      list.appendToTail(39);
      list.appendToFront(123);
      list.appendToFront(1212);
      list.appendToFront(9);
      list.appendToFront(9);
      list.appendToTail(9);
     System.out.println("LinkedList :"+list);
     list.delete(9);
     System.out.println("after delete(9) :"+list);
     list.deleteAll(9);
     System.out.println("after deleteAll(9)"+list);
  }

  /* This class represents a each single Node of a LinkedList.*/
  private static class Node{
      Node next;
      int data;

      public Node(int data){
          this.data = data;
      }
  }

  LinkedList.Node  head;

  /* This method adds an element to the Front of a LinkedList.
  * T(n)=O(1), constant time. */
  public void appendToFront(int element){
     Node front = new Node(element);
     front.next = head;
     this.head = front;
  }

    @Override
    public String toString() {
        LinkedList.Node cur = head;
        StringBuilder sb = new StringBuilder("[");
        while(cur!=null){
            sb.append(cur.data+", ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /* This adds a Node at the end of a LinkedList.
      * T(n)=O(n), linear time. */
  public void appendToTail(int element){
      Node end = new Node(element);
      if(head==null) head = end;
      else{
          Node cur = head;
          while(cur.next!=null)
              cur = cur.next;
          cur.next = end;
      }
  }

  /* This method deletes First entry whose value is same as given.
  * T(n)=O(n).*/
  public void delete(int element){
    if(head==null) return;
    else{
        if(head.data==element) head=head.next;
        else{
            Node cur = head;
            while(cur.next!=null){
                if(cur.next.data==element){
                    cur.next=cur.next.next;
                    return;
                } cur = cur.next;
            }
        }
    }
  }

  /* This method deletes all entries.
  * T(n)=O(n).*/
  public void deleteAll(int element){
      Node cur = head;
      Node prev = null;
      while(cur!=null){
          if(cur.data==element){
              if(prev==null) head=cur.next;
              else prev.next=cur.next;
          }
          prev = prev==null?cur:prev.next;
          cur = cur.next;
      }
  }

}
