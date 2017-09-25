package ctci.linkedlist;

public class Partition {

    public static void main(String[] args){
      Node list = new Node(13);
      list.appendToTail(9);
      list.appendToTail(31);
      list.appendToTail(11);
      list.appendToTail(39);
      list.appendToTail(2);
      System.out.print("list before partitioning :");
      print(list);
      System.out.print("list after partitioning around 13 :");
      list = partition(list,13);
      print(list);
      System.out.print("new list after partitioning around 7 :");
      list = partition2(list,7);
      print(list);
    }

    /* prints the LinkedList.
       T(n)=O(n), linear time.*/
    private static void print(Node node){
        StringBuilder sb = new StringBuilder("[");
        while(node!=null){
            sb.append(node.data+", ");
            node = node.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /* partition the LinkedList such that all the elements less than x comes before all
    * the elements greater than or equals to x.
    * here in this method order is not preserved. */
    private static Node partition(Node node, int x){
       Node newHead = null;
       Node lastNode = node;
       while(lastNode.next!=null){
           lastNode = lastNode.next;
       }
       Node prev = null;
       Node finalNode = lastNode;
       while(node!=finalNode){
           if(node.data>=x){
               lastNode.next = node;
               lastNode = node;
               node = node.next;
             if(prev!=null){
               prev.next = node;
             } lastNode.next = null;
           }else{
               if(prev==null){
                   newHead = node;
                   prev=node;
               } else{
                   prev = prev.next;
               } node = node.next;
           }
       } if(prev==null) newHead = node;
       return  newHead;
    }

    /* method2. here The order is preserved(stable).
       T(n)=O(n)*/
    private static Node partition2(Node node, int x){
        Node smallerList = null;
        Node largerList = null;
        Node newHead = null, c1 = null;
        while(node!=null){
          if(node.data<x){
            if(smallerList==null){
                smallerList = node;
                newHead = node;
            }else{
                smallerList.next = node;
                smallerList = node;
            }
          }else{
            if(largerList==null){
                largerList = node;
                c1 = node;
            }
            else{
                largerList.next = node;
                largerList = largerList.next;
            }
          } node = node.next;
        }
        if(largerList!=null) largerList.next = null;
        else if(smallerList!=null){
            smallerList.next =null;
        }
        /* [smallerList]-->[largerList]*/
        if(smallerList!=null) smallerList.next = c1;
        else if(largerList!=null) newHead = c1;

        return newHead;
    }
}
