package sorting_n_searching;

/**
 * Created by vinayreddypolati on 7/19/17.
 */
public class QuickSort {

    public void sort(int[] array,int startIndex,int endIndex){
       if(startIndex<endIndex){
           int pivotIndex = partition(array,startIndex,endIndex);
           sort(array,startIndex,pivotIndex-1);
           sort(array,pivotIndex+1,endIndex);
       }
    }

    private int partition(int[] array,int startIndex,int endIndex){
        int pivotIndex = startIndex;
        int pivot = array[endIndex];
        for(int c1=startIndex;c1<=endIndex-1;c1++){
            if(array[c1]<=pivot){
                int temp = array[pivotIndex];
                array[pivotIndex] = array[c1];
                array[c1] = temp;
                pivotIndex++;
            }
        }
        int temp = array[pivotIndex];
        array[pivotIndex] = array[endIndex];
        array[endIndex] = temp;
        return pivotIndex;
    }
}
