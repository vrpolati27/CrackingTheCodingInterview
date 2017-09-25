package AlgorithmsForInterviews.primitivetypes.primitivetypes;

public class Division {
    public static void main(String[] args){
       long c1=123456, c2 =123;
       System.out.println(c1+"/"+c2+":"+divide(c1,c2));
        System.out.println(c1+"/"+c2+":"+divide2(c1,c2));
    }


    /* This functions tries to do more work in each iteration,
        find max k such that (2^k)y<=x, quotient+=2^k and
        repeat this by making x=(x-(2^k)y). */
    private static long divide2(long x,long y){
        int quotient = 0;
        int power = 32;
        long yPower = y<<power;
        while(!(x<y)){
            while(yPower>x){
                yPower = yPower>>>1;
                power--;
            }
            quotient += 1L<<power;
            x = x-yPower;
        }
        return quotient;
    }

    /* This is a BruteFore method to find quotient when we divide 1 number by another.
       return x/y.
       T(n)= c1(x/y). */
    private static long divide(long x,long y){
        long quotient = 0;
        while(!(x<y)){
            quotient += 1;
            x = x-y;
        }
        return quotient;
    }

}
