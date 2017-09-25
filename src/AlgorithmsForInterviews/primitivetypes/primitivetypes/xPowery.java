package AlgorithmsForInterviews.primitivetypes.primitivetypes;


public class xPowery {
    public static void main(String[] args){
       double d1 = 12.56; int y = 12;
       System.out.println("Math,pow("+d1+","+y+"):"+power(d1,y));
    }

    /* this method calculate x^y, does this without using library functions
       such as Math.pow(x,y). */
    private static double power(double x,int y){
        double product = 1.0;
        /*for(int c1=0;c1<y;c1++){
           product = product*x;
        }*/
        long power = y;
        while(power!=0){
            if((power&1L)!=0) product *= x;
            x = x*x;
            power = power >>>1;
        } return product;
    }

    /* This method returns true if given number is even, false otherwise.
       T(n) = O(1), constant time. */
    private static boolean isEven(int c1){
        return (c1&1)==0;
    }

}
