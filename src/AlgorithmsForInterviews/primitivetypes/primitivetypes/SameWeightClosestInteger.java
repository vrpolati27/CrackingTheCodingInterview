package AlgorithmsForInterviews.primitivetypes.primitivetypes;

public class SameWeightClosestInteger {
    public static void main(String[] args){
       long c1 = Long.parseLong("10100100011101000001101001111100000",2);
       System.out.println("("+c1+"),bitsCount:"+countBits(c1));
       System.out.println("closestInteger:"+closestIntSameBitCount(c1));
       System.out.println("closestInteger:"+closestIntSameBitCount2(c1));
    }


    /* This method returns closest long that has same weight as given number.
        We get closest integer by swapping rightmost two consecutive bits that are different.
        T(n) = O(n) where n is the Size of long type. */
    private static long closestIntSameBitCount2(long c1){
        final int numUnsignedBits = Long.SIZE-1;
        for(int c=0;c<numUnsignedBits-1;c++){
            if(((c1>>>c)&1) != ((c1>>>(c+1))&1)){
                c1 = SwapBits.swapBits(c1,c,c+1);
                break;
            }
        }
        return c1;
    }

    /* This method returns closest integer that has same #bits as given number.
        this is BruteForce approach.*/
    private static long closestIntSameBitCount(long c1){
       int bitsCount = countBits(c1);
       int diff = 1;
       while(true){
           if(bitsCount==countBits(c1-diff)) return (c1-diff);
           else if(bitsCount==countBits(c1+diff)) return (c1+diff);
           diff += 1;
       }
    }

    /* returns the count of bits set in a given numbers Binary representation.
    * T(n) = O(n). where 'n' is the size of a Long type.*/
    private static int countBits(long c1){
        int bitCount = 0;
        while(c1!=0){
            bitCount++;
            c1 = c1&(c1-1);
        }
        return bitCount;
    }
}
