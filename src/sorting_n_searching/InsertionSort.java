package sorting_n_searching;

/**
 * Created by vinayreddypolati on 7/19/17.
 */
public class InsertionSort {
    public void sort(int[] array){
        for(int c1=1;c1<array.length;c1++){
            int value = array[c1];
            int index = c1-1;
            while(index>=0 && array[index]>value){
                array[index+1] = array[index];
                index = index-1;
            }
            array[index+1] = value;
        }
    }
}
