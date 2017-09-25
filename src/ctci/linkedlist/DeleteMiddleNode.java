package ctci.linkedlist;

public class DeleteMiddleNode {
    public static void main(String[] args){
      Node list = new Node(1);
      list.appendToTail(22);
      list.appendToTail(333);
      list.appendToTail(4444);
      list.appendToTail(55555);
      list.appendToTail(666666);
      list.appendToTail(55555);
      list.appendToTail(22);
      list.appendToTail(1);/* 1->22->333->4444->55555->666666->55555->22->1*/
      System.out.print("initially List :");
        print(list);
      deleteMiddle(list.next.next.next);/* 4444 should be deleted.*/
      System.out.print("after deleting 4444, list is :");
      print(list);
    }

    /* This method prints linkedList.
       T(n)=O(n). */
    private static void print(Node node){
      StringBuilder sb = new StringBuilder("[");
      while(node!=null){
          sb.append(node.data+", ");
          node = node.next;
      } sb.append("]");
      System.out.println(sb.toString());
    }

    /* this node deletes given node from LinkedList, given only reference to that node.
       T(n)=O(n). */
    private static void deleteMiddle(Node node){
      Node lastNode = node.next;
      Node lastButOneNode = node;
       int temp = lastNode.data;
       lastNode.data=lastButOneNode.data;
       lastButOneNode.data = temp;
         while(lastNode.next!=null){
            /* this deletes given node and also preserves order of the list.*/
             lastNode= lastNode.next;
             lastButOneNode=lastButOneNode.next;
             temp = lastNode.data;
             lastNode.data=lastButOneNode.data;
             lastButOneNode.data = temp;
         } lastButOneNode.next=null;
    }
}
