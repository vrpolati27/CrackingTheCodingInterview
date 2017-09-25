package ctci.ArraysNstrings;

public class RotateMatrix {
    public static void main(String[] args){
      int[][] matrix = new int[4][4]; int c=1;
      for(int row=0;row<matrix.length;row++){
          for(int col=0;col<matrix[row].length;col++){
              matrix[row][col] = c++;
          }
      }
      System.out.println("Initial matrix is as Follows");
      print(matrix);
      System.out.println("----------------------------------------\n " +
              "Matrix after 90 degrees rotation is as Follows");
      print(rotate(matrix));
    }

    /* This method returns a given matrix rotated 90 degrees.*/
    public static int[][] rotate(int[][] matrix){
       int layersCount = (matrix.length+1)/2;
       for(int layer=0;layer<layersCount;layer++){
           matrix = rotateLayer(matrix,layer);
       } return  matrix;
    }

    /* This method rotates a given layer of a matrix by 90 degrees.*/
    private static int[][] rotateLayer(int[][] matrix, int layer){
        int r = matrix.length-(2*layer)-1;
        int mc = (layer&1)==0?r:r+1;
      for(int c=layer;c<mc;c++){
          int temp = matrix[c][layer];
          matrix[c][layer]=matrix[matrix.length-1-layer][c];
          matrix[matrix.length-1-layer][c] = matrix[matrix.length-1-c][matrix.length-1-layer];
          matrix[matrix.length-1-c][matrix.length-1-layer]=matrix[layer][matrix.length-1-c];
          matrix[layer][matrix.length-1-c] = temp;
      } return matrix;
    }

    /* This method prints all the elements of a matrix in a row by row fashion,
      T(n)=O(m*n). where (m,n) are (#rows,#columns).*/
    public static void print(int[][] matrix){
        System.out.println();
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
               System.out.print(matrix[row][col]+"  ");
            } System.out.println();
        }
    }
}
