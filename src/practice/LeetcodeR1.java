package practice;

public class LeetcodeR1 {
    public static void main(String[] args){
       int[][] array = {
               { 1, 2, 3, 4, 5, 6, 7},
               { 8, 9, 10,11,12,13,14},
               { 15,16,17,18,19,20,21},
               { 22,23,24,25,26,27,28},
               { 29,30,31,32,33,34,35},
               { 36,37,38,39,40,41,42},
       };

       for(int[] arr:array){
           for(int num:arr){
               System.out.print(num+" ");
           }
           System.out.println();
       }
       System.out.println("------------------------------------");
       for(int layer=0;layer<array[0].length/2;layer++){
           displayLayer(array, layer);
           System.out.println();
       }
    }



    private static void displayLayer(int[][] array,int layer){
        /*top row*/
        int row = layer;
        int col=layer;
        for(;col<array[0].length-layer-1;col++){
            System.out.print(array[row][col]+" ");
        }
        /*right row*/
        for(;row<array.length-1-layer;row++){
            System.out.print(array[row][col]+" ");
        }
        /*bottom row*/
        for(;col>layer;col--){
            System.out.print(array[row][col]+" ");
        }
        /*Left row*/
        for(;row>layer;row--){
            System.out.print(array[row][col]+" ");
        }
    }


}
