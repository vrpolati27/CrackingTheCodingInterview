package ctci.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Intersection {

    public static void main(String[] args){
        Node list1 = new Node(1);
        list1.appendToTail(22);
        list1.appendToTail(123); list1.appendToTail(1234);

        Node list2 = new Node(1);
        list2.appendToTail(54321);
        list2.appendToTail(432);
        list2.appendToTail(678);

        Node intersection = new Node(1013);
        intersection.appendToTail(1);
        intersection.appendToTail(22);
        intersection.appendToTail(333);

        list1.appendToTail(intersection);/* 1->22->123->1234->[1013,1,22,333]*/
        list2.appendToTail(intersection); /* 1->54321->432->678->[1013,1,22,333]*/

        Node common = intersection(list1,list2);
        System.out.println("list1 :"+ _toString(list1));
        System.out.println("list2 :"+ _toString(list2));
        System.out.println("intersection of Lists: "+common.data);
    }

    /* returns list data as string*/
    private static String _toString(Node node){
        StringBuilder sb = new StringBuilder("[");
        while(node!=null){
          sb.append(node.data+",");
          node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /* returns intersecting node in given two LinkedList
      T(n)=O(n+m) and
      space complexity = O(n). */
    private static Node intersection(Node list1, Node list2){
        Node intersectingNode = null;
        /* put list1 in HashMap*/
        Map<Node,Boolean> map = new HashMap<>();
        while(list1!=null){
            map.put(list1,true);
            list1 = list1.next;
        }
        /* Traverse list2 and check for it in hashtable.*/
        while(list2!=null){
          boolean isIntersection = map.getOrDefault(list2,false);
          if(isIntersection){
              intersectingNode = list2;
              break;
          } list2 = list2.next;
        } return intersectingNode;
    }

}
