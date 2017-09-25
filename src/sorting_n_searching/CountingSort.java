package sorting_n_searching;

import java.util.Arrays;

/**
 * Created by vinayreddypolati on 7/20/17.
 */
public class CountingSort {

    public void sort(int[] array){
        int[] minnmax = minnmax(array);
        int[]  hashArr= new int[minnmax[1]-minnmax[0]+1];
        /*Arrays.fill(hashArr,0);*/
        for(int c1=0;c1<array.length;c1++){
           hashArr[array[c1]-minnmax[0]] += 1;
        }
        int initIndex = 0;
        for(int c2=0;c2<hashArr.length;c2++){
            for(int m1=0;m1<hashArr[c2];m1++){
                array[initIndex++] = c2+minnmax[0];
            }
        }
    }

    /* returns an array of size 2 which holds minimum and maximum
    *   at indices 0 and 1 respectively. */
    private int[] minnmax(int[] array){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int c1=0;c1<array.length;c1++){
            if(array[c1]<min) min = array[c1];
            if(array[c1]>max) max = array[c1];
        }
        int[] result = {min,max};
        return result;
    }
}
