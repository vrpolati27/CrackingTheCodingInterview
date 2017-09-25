package ctci.ArraysNstrings;

public class ZeroMatrix {

    public static void main(String[] args){
        int[][] matrix = new int[5][4];
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                matrix[row][col]=(int)(Math.random()*10);
            }
        }
        System.out.println("Initially matrix is as follows");
        print(matrix);
        zeroMatrix(matrix);
        System.out.println("-----------------------------------------------");
        print(matrix);
    }

    /* This method prints matrix on to console.*/
    private static void print(int[][] matrix){
        System.out.println();
        for(int row=0;row<matrix.length;row++){
           for(int col=0;col<matrix[row].length;col++){
               System.out.print(matrix[row][col]+" ");
           } System.out.println();
        }
    }

    private static void zeroMatrix(int[][] matrix){
       boolean rowHasZero = false;
       boolean colHasZero = false;

       /* check very first row for zero values.*/
       for(int col=0;col<matrix[0].length;col++){
           if(matrix[0][col]==0){
               rowHasZero = true;
               break;
           }
       }

       /* check first column for zero values.*/
       for(int row=0;row<matrix.length;row++){
           if(matrix[row][0]==0){
               colHasZero = true;
               break;
           }
       }

       for(int row=1;row<matrix.length;row++){
           for(int col=1;col<matrix[row].length;col++){
               if(matrix[row][col]==0){
                   matrix[row][0]=0;
                   matrix[0][col]=0;
               }
           }
       }

        for(int col=0;col<matrix[0].length;col++){
            if(matrix[0][col]==0){
                modifyCol(matrix,col,0);
            }
        }

        for(int row=0;row<matrix.length;row++){
            if(matrix[row][0]==0){
                modifyRow(matrix,row,0);
            }
        }
        
        if(rowHasZero) modifyRow(matrix,0,0);
        if(colHasZero) modifyCol(matrix,0,0);


    }

    /* This method sets all values of matrix in a given row to a given value.*/
    private static void modifyRow(int[][] matrix,int row,int value){
        for(int col=0;col<matrix[row].length;col++)
            matrix[row][col]=value;
    }

    /* This method sets all values of matrix in a given col to a given value.*/
    private static void modifyCol(int[][] matrix,int col,int value){
        for(int row=0;row<matrix.length;row++)
            matrix[row][col]=value;
    }


}
