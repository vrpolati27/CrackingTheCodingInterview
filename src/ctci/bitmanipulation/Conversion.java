package ctci.bitmanipulation;

public class Conversion {

   public static void main(String[] args){
       int m1 = Integer.parseInt("11101",2);/* 29*/
       int m2 = Integer.parseInt("01111",2);/* 15*/
       System.out.println("(29->15) bitsToFlip:"+bitsToConvert(m1,m2));
   }

   /* returns count of bits to flip to change num1 to num2
   * 29 (or 11101), 15 (or 01111)
   * output: 2*/
   private static int bitsToConvert(int num1,int num2){
       int bitsToFlip = 0;
       for(int c1=0;c1<32;c1++){
           int mask = 1<<c1;
           int bit1 = (mask & num1)>0?1:0;
           int bit2 = (mask & num2)>0?1:0;
           bitsToFlip += (bit1==bit2)?0:1;
       }
       return bitsToFlip;
   }
}
