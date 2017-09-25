package ctci.bitmanipulation;


public class Insertion {
    /* insert m into n starting at a given index.
    * n = 10000000000
    * m = 10011
    * index = 2
     ----------------
    * result = 10001001100. */
    private static int insert(int n, int m, int startIndex, int endIndex){
       int c3 = startIndex;
       for(int c1=0;c1<(endIndex-startIndex+1);c1++){
           int z1 = (m & (1<<c1))>0?1:0;
           System.out.print(z1);
           if(z1==1) n = setBit(n,c3++);
           else n = clearBit(n,c3++);
       } System.out.println();
       return n;
    }

    private static int setBit(int num, int position){
       return num | (1<<position);
    }

    private static int clearBit(int num,int position){
        int result;
        int mask = ~(1<<position);
        result = mask&num;
        return result;
    }

    /**/
    private static int insert2(int n, int m, int startIndex, int endIndex){
        int left = (~0)<<(endIndex+1);/* 11111000 endIndex=2*/
        int right = ~((~0)<<(startIndex));/* 00000011 startIndex=2*/
        int mask = (left|right)&n;/* (111100000111)&n*/
        n = mask|(m<<startIndex);
        return n;
    }

    public static void main(String[] args){
       int n = Integer.parseInt("10000000000",2);
       int m = Integer.parseInt("10011",2);
       System.out.println(Integer.toBinaryString(insert(n,m,2,6)));
                       /* 10001001100.*/
        System.out.println(Integer.toBinaryString(insert2(n,m,2,6)));
    }
}
