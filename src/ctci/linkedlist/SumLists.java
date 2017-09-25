package ctci.linkedlist;

public class SumLists {

    public static void main(String[] args){
      Node num1 = new Node(9);
      num1.appendToTail(9);
        num1.appendToTail(9); num1.appendToTail(9); num1.appendToTail(9);
        num1.appendToTail(9); num1.appendToTail(9); num1.appendToTail(9);
        num1.appendToTail(9); num1.appendToTail(9); num1.appendToTail(9);
        num1.appendToTail(9); num1.appendToTail(9); num1.appendToTail(9);
        num1.appendToTail(9); num1.appendToTail(9); num1.appendToTail(9);
        num1.appendToTail(9); num1.appendToTail(9); num1.appendToTail(9);
        /* num1 = 99999999999999999999*/
      /*Node num2 = new Node(5);
      num2.appendToTail(9);
      num2.appendToTail(2);*/ /* num2 = 295 */
      System.out.print("sum("+print(num1)+","+print(num1/*num2*/)+")="+print(sum(num1/*num2*/,num1)));
      /*    99999999999999999999
            99999999999999999999
           11111111111111111111
         --------------------------
  (result) 199999999999999999998 .*/
    }

    private static String print(Node num){
        StringBuilder sb = new StringBuilder();
        while(num!=null){
          sb.append(num.data);
          num = num.next;
        } return sb.reverse().toString();
    }

    /* T(n)=O(Math.max(num1.length(), num2.length()))
    *  T(n) = O(m+n), where m = num1.length()
    *                       n = num2.length(). */
    private static Node sum(Node num1, Node num2){
        Node result = new Node(13);
        sum(num1,num2,0,result);
        return result.next;
    }

    private static void sum(Node num1, Node num2, int carryIn, Node result){
        if(!(num1==null && num2==null && carryIn==0)){
            int n1 = 0, n2 =0;
            if(num1!=null){
                n1 = num1.data;
                num1 = num1.next;
            }

            if(num2!=null){
                n2 = num2.data;
                num2 = num2.next;
            }
            int sum = n1+n2+carryIn;
            int carryOut = sum/10;
            Node c = new Node(sum%10);
            result.next = c;
            sum(num1,num2,carryOut,c);
        }
    }


    /* Follow up.
    * list[6->1->7] unlike above it represents #617, not #716
    * sum(list[6->1->7] #617, list[9->2->3] #923) should return
    *    list(1->5->4->0)  617+923=1540. */


    
}