package ctci.bitmanipulation;

public class PairwiseSwap {

    public static void main(String[] args){
        int c1 = Integer.parseInt("11111110101011101010",2);
        int res = pairwiseSwap(c1);
        System.out.println(res+", "+Integer.toBinaryString(res));/* 11111101010111010101*/
        res = pairwiseSwap2(c1);
        System.out.println(res+", "+Integer.toBinaryString(res));/* 11111101010111010101*/
    }

    private static int pairwiseSwap2(int number){
       StringBuilder sb = new StringBuilder();
       for(int c1=15;c1>=0;c1--){
          int b1 = 2*c1;
          int bit1 = ((1<<b1)&number)>0?1:0;
          int bit2 = ((1<<(b1+1))&number)>0?1:0;
          sb.append(bit1+""+bit2);
       }
       int result = Integer.parseInt(sb.toString(),2);
       return result;
    }

    /* BruteForce method to pairwise swap.*/
    private static int pairwiseSwap(int number){
       for(int c1=0;c1<16;c1++){
           int bitEven = ((1<<(2*c1))&number)>0?1:0;
           int bitOdd = ((1<<(2*c1+1))&number)>0?1:0;
           if(bitEven!=bitOdd){
               if(bitEven==1){
                   number = setBit(number,(2*c1+1));
                   number = clearBit(number,(2*c1));
               }else{
                   number = setBit(number,(2*c1));
                   number = clearBit(number,(2*c1+1));
               }
           }
       } return number;
    }

    /* sets bit at a given position.*/
    private static int setBit(int num,int position){
        int mask = 1<<position;
        return (num|mask);
    }

    /* clears the bit at given position.*/
    private static int clearBit(int number,int position){
        int mask = ~(1<<position);
        return (mask&number);
    }

}
