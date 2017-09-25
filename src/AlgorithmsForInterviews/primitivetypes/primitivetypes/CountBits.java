package AlgorithmsForInterviews.primitivetypes.primitivetypes;

public class CountBits {

    public static void main(String[] args){
        System.out.println("number of bits in Integer:"+countBits(Integer.MAX_VALUE));
        System.out.println(Integer.SIZE);

    }

    /* returns count of set bits (#bits) in a given integer.*/
    public static short countBits(int c1){
        short bitsCount = 0;
        while(c1!=0){
            bitsCount += (c1 & 1);
            c1 = c1>>>1;
        }
        return bitsCount;
    }
}
