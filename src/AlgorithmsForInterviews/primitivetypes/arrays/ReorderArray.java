package AlgorithmsForInterviews.primitivetypes.arrays;

public class ReorderArray {

    public static void main(String[] args){
      int[] array = new int[13];
      for(int c=0;c<array.length;c++)
          array[c]=(int)(Math.random()*10);
      System.out.println("initially array is as Follows.");
      print(array);
      System.out.println("Array after reordering is as Follows.");
      /* reorders such that even index entries come first n then odd index entries.*/
      print(reorderEvenOdd(array));
      print(reorderEvenOdd2(array));
      /* reorders such that even entries come first n then odd entries.*/
      print(reorderEvenOdd3(array));

    }

    /* This method writes all array elements on to console.*/
    private static void print(int[] array){
       System.out.print("[");
       for(int c1:array){
           System.out.print(c1+" ");
       }
       System.out.println("]");
    }

    /* this method reorder the entries so that even index entries appear First and then odd index entries
      This uses O(n) extra space.
      T(n)=O(n). */
    public static int[] reorderEvenOdd(int[] array){
        int[] tempArray = new int[array.length]; int index = 0;
        /* add even index entries First, to temporary new array*/
        for(int c1=0;c1<array.length;c1+=2){
            tempArray[index++]=array[c1];
        }
        /* add odd index entries then to temporary array.*/
        for(int c1=1;c1<array.length;c1+=2){
            tempArray[index++]=array[c1];
        }
        array = tempArray;
        return array;
    }

    /* This method reorders array elements such that even index entries come first and then odd index entries.
      this is an in place algorithm, i.e, space complexity = O(1).
      T(n)=O(n). linear time. */
    public static int[] reorderEvenOdd2(int[] array){
        int front = 0;
        int back = array.length-1;
        while(front<back){
            if((front&1)==0) front = front+1;
            if((back&1)==1) back = back-1;
            if(front<back){
                int temp = array[front];
                array[front]=array[back];
                array[back]=temp;
                front++;
                back--;
            }
        }
        return array;
    }

    /* This method reorders array such that even entries appear first and then odd entries.
      */
    private static int[] reorderEvenOdd3(int[] array){
       int front = 0;
       int back = array.length-1;
       while(front<back){
           while((array[front]&1)==0) front+=1;
           while((array[back]&1)==1) back = back-1;
           if(front<back){
               int temp = array[front];
               array[front]=array[back];
               array[back] = temp;
               front = front+1;
               back = back-1;
           }
       }
       return array;
    }


}
