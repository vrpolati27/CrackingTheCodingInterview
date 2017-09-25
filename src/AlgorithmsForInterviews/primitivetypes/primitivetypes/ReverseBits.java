package AlgorithmsForInterviews.primitivetypes.primitivetypes;

public class ReverseBits {

    public static void main(String[] args){
        long c1 = Long.parseLong("10111011101110111011101110111011101110111011",2);
        System.out.println("reverse:"+Long.toBinaryString(reverse(c1)));
        System.out.println("Reverse:"+Long.toBinaryString(reverseBits(c1)));
    }


    private static long reverseBits(long c1){
        long[] preComputedReverse = new long[(int)Math.pow(2,4)];
        for(int c=0;c<preComputedReverse.length;c++){
            preComputedReverse[c] = reverse(c);
            /*System.out.println(Long.toBinaryString(c)+", reverse:"+
            Long.toBinaryString(preComputedReverse[c]));*/
        }
        final long bitMask = 0xF;
        long result = 0L; int itr = 0; boolean startReversing = false;
        for(int c3=(Long.SIZE)/4-1;c3>=0;c3--){
            int c9 = (int)(c1>>>(4*c3) & bitMask);
            /*System.out.println(Long.toBinaryString(c9)+","+Long.toBinaryString(preComputedReverse[c9]));
            System.out.println("(4*itr):"+(4*itr)+","+Long.toBinaryString(preComputedReverse[c9]<<(4*itr)));*/
            if(c9>0) startReversing = true;
            if(startReversing)
            result = result |
                    (preComputedReverse[c9]<<(4*itr++));
            /*System.out.println("result:"+Long.toBinaryString(result));*/
        }
        return result;
    }

    /* This method returns the long that whose bit representation is exactly the reverse of
    *  given input.
       T(n) = O(n). linear time.*/
    private static long reverse(long c1){
        int y = 0;
        long x2 = c1>>y;
        while(x2!=0){
            y = y+1;
            x2 = x2>>1;
        } y--;/*System.out.println("length:"+y--);*/
        for(int x=0;x<y;x++,y--){
            c1 = SwapBits.swapBits(c1,x,y);
        }
        return c1;
    }

}
