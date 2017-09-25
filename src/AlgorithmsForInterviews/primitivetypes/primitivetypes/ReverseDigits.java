package AlgorithmsForInterviews.primitivetypes.primitivetypes;

public class ReverseDigits {
    public static void main(String[] args){
      int x = Integer.MAX_VALUE; /* 2147483647*/
      System.out.println("reverse of "+x+" is:"+reverse(x));
    }

    /* This method returns reverse of a given number.
       reverse(3219) = 9123.
       T(n)=O(n) where 'n' is number of digits in a given number(x).*/
    public static long reverse(int x){
       int curLastDigit = 0;
       long reverse = 0;
       while(x!=0){
          curLastDigit = x%10;
          reverse = (reverse*10)+curLastDigit;
          x = x/10;
       } return reverse;
    }
}
