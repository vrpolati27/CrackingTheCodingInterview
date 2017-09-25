package ctci.linkedlist;

public class ReturnKthToLast {

    public static void main(String[] args){
       Node linkedList = new Node(10);
       for(int c=9;c>0;c--)
          linkedList.appendToTail(c);
       /* kth node from last. */
       System.out.println(" 3rd from last :"+_kthToLast(linkedList,3));
       IntWrap result = new IntWrap(Integer.MIN_VALUE);
        _kthToLast2(linkedList,10, result);
       System.out.println(" 10th from last is :"+result.data);
    }

    /* returns _kth to Last Node from a given LinkedList.
    * T(n)=O(n)*/
    private static int _kthToLast(Node head, int k){
        int listLength = listLength(head);
        return getNode(head,listLength+1-k);
    }

    /* returns the number of Nodes in a LinkedList.
    * T(n)=O(n). */
    private static int listLength(Node head){
        int length = 0;
        Node cur=head;
        while(cur!=null){
           length++;
           cur = cur.next;
        } return length;
    }

    /* returns cth node from start
    * T(n)=O(n). */
    private static int getNode(Node head, int c){
        Node node = null;
        int  m = 0;
        Node cur = head;
        while(cur!=null){
           m++;
           if(m==c) return cur.data;
           cur = cur.next;
        }
        return node==null?Integer.MIN_VALUE:node.data;
    }

    /* This method returns kth to the last element without calculating Length.
    *  T(n)=O(n), linear time. [Recursion.]*/
    private static int _kthToLast2(Node head, int k, IntWrap kth2LastElement){
        if(head==null) return 0;
        int index = _kthToLast2(head.next,k,kth2LastElement)+1;
        if(index==k){
            kth2LastElement.data=head.data;
        } return index;
    }
}

class IntWrap{
    int data;
    public IntWrap(int data){
        this.data = data;
    }
}
