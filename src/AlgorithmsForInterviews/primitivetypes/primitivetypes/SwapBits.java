package AlgorithmsForInterviews.primitivetypes.primitivetypes;

public class SwapBits {

    public static void main(String[] args){
      long c1 = Long.parseLong("1110000100010111110000",2);
      System.out.println(Long.toBinaryString(c1)+" after reverse is:"+
      Long.toBinaryString(swapBits(c1,4,13)));
    }

    /* This method returns the number formed after swapping bits at position1 and position2 in
        a given number.
        T(n) = O(1), constant time. */
    public static long swapBits(long c1, int pos1, int pos2){
        long bitAtPos1 = (c1>>>pos1)&1;
        long bitAtPost2 = (c1>>>pos2)&1;
        /* swap bits only when they are different*/
        if(bitAtPos1!=bitAtPost2)
            c1 = c1 ^((1L<<pos1)|(1L<<pos2));
        return c1;
    }
}
