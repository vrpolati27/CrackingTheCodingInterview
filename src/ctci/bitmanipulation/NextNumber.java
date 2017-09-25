package ctci.bitmanipulation;

public class NextNumber {

    public static void main(String[] args){
      int c1 = Integer.parseInt("1110",2); /**/
      System.out.println(""+bitsCount(c1));
      int[] nextMinMax = nextNumber(c1);
      System.out.println(c1+" (nextSmallest:"+nextMinMax[0]+", nextLargest:"+nextMinMax[1]+")");
      System.out.println(Integer.toBinaryString(c1)+" ,( prevSmall:"+
              Integer.toBinaryString(nextMinMax[0])+", nextLargest:"+
              Integer.toBinaryString(nextMinMax[1])+" )");

    }

    private static int bitsCount(int num){
        int bitsCount = 0;
        for(int c1=0;c1<32;c1++){
            int bit = ((1<<c1)&num)>0?1:0;
            bitsCount += bit;
        }
        return bitsCount;
    }



    /* BruteForce method. */
    private static int[] nextNumber(int number){
       int bitsCount = bitsCount(number);
       int next;
       int prev = Integer.MIN_VALUE;
       for(int c1=number+1;;c1++){
           int bc = bitsCount(c1);
           if(bc==bitsCount){
               next = c1;
               break;
           }
       }

       for(int c3=number-1;c3>=0;c3--){
           int _bc = bitsCount(c3);
           if(_bc==bitsCount){
               prev = c3;
               break;
           }
       } int[] nextMinMax = {prev,next}/*new int[2]*/;
       return nextMinMax;
    }

}
