package AlgorithmsForInterviews.primitivetypes.primitivetypes;

import java.util.HashMap;
import java.util.Map;

public class NumberParity {

    public static void main(String[] args){
       int c1 = Integer.parseInt("101101",2);/* c1 has 4 1's, so parity =0.*/
       System.out.println("parity of "+c1+"(101101) is:"+getParity(c1));
       System.out.println("parity of "+c1+"(101101) is:"+getParity2(c1));
       c1 = Integer.parseInt("111110000010000100001",2);
       System.out.println("parity of "+c1+"(11111000001000010000) is:"+getParity3(c1));
       System.out.println("parity of "+c1+"(11111000001000010000) is:"+getParity4(c1));
       c1 = Integer.parseInt("01010000",2);
       int result = propagateRightMostSetBit(c1);
       System.out.println("after propagating right most set bit in "+Integer.toBinaryString(c1)+
                            " result: "+result+" ("+Integer.toBinaryString(result)+")b2");
       int num = 77, _2pow = 64;
       System.out.println(num+" mod "+_2pow+" is:"+modA2pow(num,_2pow));

       int c3 = 1;
       for(int c=0;c<20;c++){
           c3 = c3*2;
           int random = Math.random()>=.5?1:0;
           System.out.println((c3+random)+" is2Power: "+is2Power(c3+random));
       }

    }

    /* BruteForce method
    * This method returns parity of a Number,
     *   parity = 1 if number of set bits is odd, is 0 otherwise.
     *   T(n) = O(m), where m is size of a int.[number(c1)]*/
    private static short getParity(int c1){
        short result = 0;
        while(c1!=0){
            result = (short)(result^(c1&1));
            c1 = c1>>>1;
        }
        return result;
    }

    /* returns parity of a Number,
    *  x = x&(x-1) clears lowest set bit.
    *  T(n) = O(c) where 'c' is number of set bits.*/
    private static short getParity2(int c1){
        short result = 0;
        while (c1!=0){
            result = (short)(result^1);
            c1 = c1&(c1-1);/* clears lowest set bit*/
        }
        return result;
    }

    /* T(n) = O(n/L) + time to initialize the Lookup table.*/
    private static short getParity3(int c1){
        Map<Integer,Integer> cache = new HashMap<>(16);
        for(int c=0;c<16;c++){
          cache.put(c,(int)getParity2(c));
        }
        short result = 0;
        int mask = (1<<4)-1;/* 1111*/ /* int BitMask = 0xF; same as {(1<<4)-1} (1111)*/
        while(c1!=0){
            result ^= cache.get(c1&mask);
            c1 = c1>>>4;
        }
        return result;
    }

    /* T(n) = O(logn), where n is the word size.*/
    private static short getParity4(int c1){
        c1 = c1^(c1>>>16);
        c1 = c1^(c1>>>8);
        c1 = c1^(c1>>>4);
        c1 = c1^(c1>>>2);
        c1 = c1^(c1>>>1);
        c1 = (c1&1)==1?1:0;
        return (short)c1;
    }

    /* This method propagates right most set bit.
       turns (01010000)b2 to (01011111)b2,
    *  T(n)=O(1). */
    private static int propagateRightMostSetBit(int num){
        int bitMask = num-1;
        int result = num | bitMask;
        return result;
    }

    /* returns x mod a power of 2,
       e.g, returns 13 for 77 mod 64.
       T(n) = O(1). constant time*/
    private static int modA2pow(int num, int _2pow){
        int bitMask = _2pow-1;
        int result = num & bitMask;
        return result;
    }

    /* returns true if given number is a power of 2.
    * T(n) = O(1). */
    private static boolean is2Power(int num){
        boolean isBoolean = false;
        isBoolean = (num&(num-1))==0?true:false;
        return isBoolean;
    }

}
