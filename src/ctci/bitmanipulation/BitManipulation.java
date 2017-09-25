package ctci.bitmanipulation;

public class BitManipulation {
    /* set the bit at position to 1.*/
    private static int setBit(int num, int position){
        int mask =1<< position;
        int result = (num|mask);
        return result;
    }

    /*clear bit at a position.*/
    private static int clearBit(int num, int position){
        int mask = /*setBit(0,position)*/ 1<<position;
        mask = ~mask;
        int result = (mask & num);
        return result;
    }

    /* flip a bit*/
    private static int flipBit(int num,int position){
        int mask = 1<<position;
        int result = (num^mask);
        return result;
    }

    /* returns true if a bit is set, false otherwise*/
    private static boolean isBitSet(int num,int position){
        boolean isBitSet;
        int mask = 1<<position;
        isBitSet = (mask & num)>0?true:false;
        return isBitSet;
    }

    /* return true if number is Even. */
    private static boolean isEven(int num){
        boolean isEven = (num&1)==0?true:false;
        return isEven;
    }

    /* return if number is power of 2. /* Math.pow(2,c1)*/
    private static boolean isPower2(int num){
        boolean isPower2 = (num & (num-1))==0?true:false;
        return isPower2;
    }

    /* returns count of bits,
    * bitsCount(Integer.parseInt("101101",2)) = 4.*/
    private static int _1bitsCount(int c2){
        int bitsCount = 0;
        for(int c1=0;c1<32;c1++){
            bitsCount += ((1<<c1)&c2)>0?1:0;
        }
        return bitsCount;
    }

    /* count of bitwise different bits given 2 numbers.
       100010101
       010001010
       -------------
       7 bits */
    private static int _bitwiseDiffBitsCount(int num1,int num2){
        int diffBitsCount = 0;
        int m1 = (num1^num2);
        /*for(int c1=0;c1<32;c1++){
            diffBitsCount += (m1&(1<<c1))>0?1:0;
        }*/ diffBitsCount = _1bitsCount(m1);
        return diffBitsCount;
    }

    public static void main(String[] args){
      /* set a bit*/
      System.out.println("Math.pow(2,10):"+setBit(0,10)); /* same as Math.pow(2,10)*/
        int num = 0;
        num = setBit(num,3);
        num = setBit(num,6);
        num = setBit(num,0);
        num = setBit(num,7);
        num = setBit(num,4);
        System.out.println(Integer.toBinaryString(num));/*11011001*/
        num = clearBit(num,3);/*11010001*/
        num = clearBit(num,0);/*11010000*/
        System.out.println(Integer.toBinaryString(num));/*11010000*/
        num = flipBit(num,0);/* 11010001*/
        num = flipBit(num,2);/* 11010101*/
        num = flipBit(num,6);/* 10010101*/
        System.out.println(Integer.toBinaryString(num)); /* 10010101*/
        for(int c1=7;c1>=0;c1--){
            int c = isBitSet(num,c1)?1:0;
            System.out.print(c);
        }System.out.println(); /* 10010101*/
        System.out.println("343 isEven:"+isEven(343));
        System.out.println("342 isEven:"+isEven(342));
        System.out.println("256 is power2:"+isPower2(256*4*8*32));
        System.out.println("510 is power2:"+isPower2(510));
        System.out.println("1011010001("+Integer.parseInt("1011010001",2)+"), bitsCount:"+
                           _1bitsCount(Integer.parseInt("1011010001",2)));/* 5*/
        System.out.println("#bitwise different bits (100010101,010001010):"+
                       _bitwiseDiffBitsCount(Integer.parseInt("100010101",2),
                               Integer.parseInt("010001010",2))); /* 7*/
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(_1bitsCount(Integer.MAX_VALUE));/* 31*/

    }
}
