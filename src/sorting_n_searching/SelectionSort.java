package sorting_n_searching;

/**
 * Created by vinayreddypolati on 7/18/17.
 */
/* picks first smallest Element and swaps it with element at 0th index,
*  second smallest with element at 1st index,...

*  T(n)=c1(n-1)+c2(n)(n-1)/2+
*  T(n)=O(n^2). */
public class SelectionSort {
   public void sort(int[] array){
       for(int c1=0;c1<array.length-1;c1++){
           int index = c1;
           for(int c2=c1+1;c2<array.length;c2++){
               if(array[c2]<array[index])
                   index = c2;
           }
           if(index!=c1){
               int temp = array[c1];
               array[c1] = array[index];
               array[index] = temp;
           }
       }
   }
}
