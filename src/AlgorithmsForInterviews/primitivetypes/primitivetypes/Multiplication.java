package AlgorithmsForInterviews.primitivetypes.primitivetypes;

public class Multiplication {

    public static void main(String[] args){
      long c1 = 231, c2 = 34;
      System.out.println("sum of "+c1+" n "+c2+" :"+add(c1,c2));
        System.out.println("product of "+c1+" n "+c2+" :"+multiply(c1,c2));
        System.out.println("product of "+c1+" n "+c2+" :"+multiply2(c1,c2));
    }

    /* This is a BruteForce method to multiply 2 numbers.
        this add y x times.
        T(n)=O(x*n), where n is the operand size.*/
    private static long multiply2(long x,long y){
        long product = 0;
        for(int c1=0;c1<x;c1++){
            product = add(y,product);
        } return product;
    }

    /* This method returns x*y, does this without Arithmetic Operations.
       T(n)=O(n^2).*/
    private static long multiply(long x, long y){
        long result = 0;
        while(x!=0){
           if((x&1)!=0) result = add(result,y);
           x=x>>>1;
           y=y<<1;
        }
        return result;
    }

    /* This method returns the addition of two integers. performs bitwise binary addition
       T(n) = O(n), where n is the number of bits needed to represent the operands
       i.e, n = Long.SIZE;
       */
    private static long add(long c1,long c2){
        long sum=0, carryIn = 0, tempA = c1, tempB = c2, k=1;
        while(tempA!=0 | tempB!=0){
           long aK = (c1&k), bK = (c2&k);
           sum = sum|(aK^bK^carryIn);
           long carryOut = (aK&bK)|(aK&carryIn)|(bK&carryIn);
           carryIn = carryOut<<1;
           k= k<<1;
           tempA>>>=1;
           tempB>>>=1;
        } return sum|carryIn;
    }
}
