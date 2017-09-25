package sorting_n_searching;

/**
 * Created by vinayreddypolati on 7/19/17.
 */
public class MergeSort {

    public void sort(int[] array){
        if(array.length!=1){
            int midIndex = array.length/2;
            int[] leftArray = new int[midIndex];
            for(int c1=0;c1<leftArray.length;c1++)
                leftArray[c1] = array[c1];
            int[] rightArray = new int[array.length-midIndex];
            for(int c2=0;c2<rightArray.length;c2++)
                rightArray[c2] = array[midIndex+c2];
            sort(leftArray);sort(rightArray);
            merge(leftArray,rightArray,array);
        }
    }

    private void merge(int[] array1, int[] array2,int[] mergedArray){
        int ar1Index = 0, ar2Index = 0, arrIndex = 0;
        while(ar1Index<array1.length && ar2Index<array2.length){
            if(array1[ar1Index]<=array2[ar2Index])
                mergedArray[arrIndex++] = array1[ar1Index++];
            else mergedArray[arrIndex++] = array2[ar2Index++];
        }
        while(ar1Index<array1.length) mergedArray[arrIndex++] = array1[ar1Index++];
        while(ar2Index<array2.length) mergedArray[arrIndex++] = array2[ar2Index++];
    }
}
