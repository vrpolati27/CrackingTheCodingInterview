package ctci.bitmanipulation;

public class FlipBitToWin {

    public static void main(String[] args){
       System.out.println("#bitsCount:"+bitsCount(Integer.MAX_VALUE));/* 31*/
       System.out.println("#maxContiguousBitsCount:"+maxContiguousBits(1775));/* 4*/
       System.out.println(maxBitsToWin(1775));/* 8*/
       System.out.println(maxBitsToWin2(1775));/* 8*/
       int c1 = Integer.parseInt("0011111111100111101111111011111",2);
       System.out.println(maxBitsToWin2(c1));/* 13*/
       System.out.println(maxBitsToWin(c1));/* 13*/
    }

    /* BruteForce method
    *  1775 = 11011101111
    *  should return 8. */
    private static int maxBitsToWin(int number){
        if(number==Integer.MAX_VALUE) return 31;
        int maxBitsCount = 0;
        for(int c1=0;c1<32;c1++){
          int bit = ((1<<c1)&number)>0?1:0;
          if(bit==0){
             maxBitsCount = Math.max(maxContiguousBits(setBit(number,c1)),maxBitsCount);
          }
        } return maxBitsCount;
    }

    /* T(n) = O(n), Linear time complexity.*/
    private static int maxBitsToWin2(int number){
        int maxBitsCount = 0;
        int c1 = 0;
        int c2 = 0;
        for(int c3=0;c3<32;c3++){
          int bit = ((1<<c3)&number)>0?1:0;
          if(bit==0){
              maxBitsCount = Math.max(c1+c2+1,maxBitsCount);
              c1 = c2;
              c2=0;
          }else c2 = c2+1;
        }
        maxBitsCount = Math.max(c1+c2+1,maxBitsCount);
        return maxBitsCount;
    }

    private static int setBit(int number,int position){
        int result;
        int mask = 1<<position;
        result = mask|number;
        return result;
    }

    /* returns count of all 1 bits in a number's Binary representation. */
    private static int bitsCount(int number){
        int bitsCount = 0;
        for(int c1=0;c1<32;c1++){
            bitsCount += ((1<<c1)&number)>0?1:0;
        } return bitsCount;
    }

    /* returns count of maximum contiguous 1bits.*/
    private static int maxContiguousBits(int number){
        int maxBits = 0;
        int bits = 0;
        for(int c1=0;c1<32;c1++){
            int bit = ((1<<c1)&number)>0?1:0;
            if(bit==1) bits++;
            else{
                if(bits>maxBits) maxBits = bits;
                bits = 0;
            }
        } maxBits = bits>maxBits?bits:maxBits;
        return maxBits;
    }

}
