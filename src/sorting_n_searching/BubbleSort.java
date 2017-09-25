package sorting_n_searching;

/**
 * Created by vinayreddypolati on 7/18/17.
 */
public class BubbleSort {
    public void sort(int[] array){
        for(int c1=0;c1<array.length;c1++){
            boolean isSorted = true;
           for(int c2=0;c2<array.length-c1-1;c2++){
               if(array[c2]>array[c2+1]){
                   int temp = array[c2];
                   array[c2] = array[c2+1];
                   array[c2+1] = temp;
                   isSorted = false;
               }
           }
           if(isSorted) break;
        }
    }
}
