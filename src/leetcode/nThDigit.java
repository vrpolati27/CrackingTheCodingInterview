package leetcode;

public class nThDigit {
    public static void main(String[] args){
       int n = Integer.MAX_VALUE;
       System.out.println("nth(2147483647) digit in the sequence:"+nThDigit(n));
    }

    /* returns nth digit in the sequence,
    * 1,2,3,4,5,6,...*/
    private static int nThDigit(int n){
        int length = 1;
        long count = 9;
        int start = 1;
        while(n>(length*count)){
            n = (int)(n-(length*count));
            length += 1;
            count = count*10;
            start = start*10;
        }

        int digit = start+(n-1)/length;
        System.out.println("digit:"+digit);
        String num = Integer.toString(digit);
        return Character.getNumericValue(num.charAt((n-1)%length));
    }
}
