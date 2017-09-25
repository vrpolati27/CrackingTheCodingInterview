package ctci.linkedlist;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args){
       Node list = new Node(1);
       list.appendToTail(2);
       list.appendToTail(3);
       list.appendToTail(4);
       list.appendToTail(5); list.appendToTail(4); list.appendToTail(3);
       list.appendToTail(2); list.appendToTail(1); /* 1->2->3->4->5->4->3->2->1. */
       System.out.print("isPalindrome("); print(list); System.out.print(") :"+
        isPalindrome(list));
       System.out.println();
       System.out.print("reverse(");print(list); System.out.print(") :");
       print(reverse(list));
       System.out.println();
       System.out.print("isPalindrome(");print(list);System.out.print(") :"+
                isPalindrome(list));
       System.out.println();
       System.out.print("isPalindrome3(");print(list);System.out.print(") :"+
        isPalindrome(list));
    }

    /* prints list
       T(n)=O(n).*/
    private static void print(Node list){
        StringBuilder sb = new StringBuilder();
        while(list!=null){
            sb.append(list.data);
            list = list.next;
        }
        System.out.print(sb.toString());
    }

    /* Method1: reverse List and compare
    *  T(n)=O(n) linear time,
    *  space complexity = O(n). */
    private static boolean isPalindrome(Node list){
        Node reverseList = reverse(list);
        return equals(reverseList,list);
    }

    /* this returns a new reversed LinkedList without changing original.
    * space complexity = O(n). */
    private static Node reverse(Node list){
        Node reverseList = null;
        while(list!=null){
            Node c = new Node(list.data);
            c.next = reverseList;
            reverseList = c;
            list = list.next;
        }
        return reverseList;
    }

    private static boolean equals(Node list1, Node list2){
        boolean areEqual;
         while(list1!=null && list2!=null){
             areEqual = list1.data==list2.data;
             if(!areEqual) return false;
             list1 = list1.next;
             list2 = list2.next;
         } areEqual = list1==null && list2==null;
         return areEqual;
    }


    /* method2, uses stack.
    * T(n)=O(n) and
    * space complexity = O(n) but better than method1 in real time.*/
    private static boolean isPalindrome2(Node list){
        boolean isPalindrome = true;
        if(list!=null){
          if(list.next!=null){
              Node runner = list;
              Node slow = list;
              Stack<Integer> firstHalf = new Stack<>();
              while(runner.next.next!=null){
                  firstHalf.push(slow.data);
                  slow = slow.next;
                  runner = runner.next.next;
              } if(runner.next!=null) slow = slow.next;
              while(slow!=null){
                  isPalindrome = firstHalf.pop()==slow.data;
                  if(!isPalindrome) break;
                  slow = slow.next;
              }
          }
        }
        return isPalindrome;
    }

    /* method3. */
    private static boolean isPalindrome3(Node list){
       int listLength = listLength(list);
       Result result = isPalindrome(list,listLength);
       return result.isPalindrome;
    }

    private static Result isPalindrome(Node node, int length){
        if(node==null) return new Result(null,true);
        else if(length==1){
            Result p  = new Result(node.next,true);
            return p;
        }else if(length==2){
            Result res = new Result(node.next.next,node.data==node.next.data);
            return res;
        }else{
            Result result = isPalindrome(node.next,length-2);
            if(!result.isPalindrome){
                return result;
            }else{
                result.isPalindrome = result.node.data==node.data;
                result.node = result.node.next;
                return result;
            }
        }
    }

    /* returns count of nodes in a LinkedList.
    * T(n)=O(n). */
    private static int listLength(Node head){
        int length = 0;
        while(head!=null){
           length = length+1;
          head = head.next;
        } return length;
    }
}

class Result{
    public Node node;
    public boolean isPalindrome;
    public Result(Node node, boolean isPalindrome){
        this.node = node;
        this.isPalindrome = isPalindrome;
    }
}
