package sorting_n_searching;

/**
 * Created by vinayreddypolati on 7/18/17.
 */
public class SortingDriver {
    public static void main(String[] args){
        int[] array = new int[10000];
        for(int c1=10000;c1>0;c1--){
            array[10000-c1] = c1;
        }
        System.out.println("Array before sorting is as Follows");
        printArray(array);
        /* Selection sorting */
        selectionSort(array.clone());
        /* Bubble Sorting*/
        printArray(array);
        bubbleSort(array.clone());
        /* insertion sort*/
        printArray(array);
        insertionSort(array.clone());
        /* Merge sort*/
        printArray(array);
        int[] m1 = {10,9,8,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,9,11,11,2,2,2,2,4,4,4};
        mergeSort(array.clone()/*m1*/);

        /* Quick sort*/
        printArray(array);
        quicksort(array.clone());

        /*counting sort*/
        printArray(array);
        countingSort(/*array.clone()*/m1);

        /* Radix sorting*/
        printArray(array);
        radixSort(array.clone());

        /* Bucket sorting*/
        bucketSort();
    }

    private static void bucketSort(){
        int[] arr = new int[100000];
        for(int c1=0;c1<arr.length;c1++){
            arr[c1] = (int)(Math.random()*100+1);
        }
        printArray(arr);
        BucketSort bs = new BucketSort();
        bs.sort(arr);
        System.out.println("Array After bucket sort");
        printArray(arr);
        newLine("-");
    }

    private static void radixSort(int[] array){
        RadixSort rs = new RadixSort();
        rs.sort(array);
        System.out.println("Array After Radix sort");
        printArray(array);
        newLine("-");
    }

    private static void countingSort(int[] array){
        CountingSort cs = new CountingSort();
        cs.sort(array);
        System.out.println("Array After counting sort");
        printArray(array);
        newLine("-");
    }

    private static void newLine(String str){
        /*System.out.println();*/
        for(int c2=0;c2<70;c2++)
            System.out.print(str);
        System.out.println();
    }

    private static void mergeSort(int[] array){
       MergeSort ms = new MergeSort();
       ms.sort(array);
        System.out.println("Array After Merge sort");
        printArray(array);
        newLine("-");
    }

    private static void insertionSort(int[] array){
        InsertionSort is = new InsertionSort();
        is.sort(array);
        System.out.println("Array After Insertion sort");
        printArray(array);
        newLine("-");
    }

    private static void bubbleSort(int[] array){
        BubbleSort bs = new BubbleSort();
        bs.sort(array);
        System.out.println("Array After Bubble sort");
        printArray(array);
        newLine("-");
    }

    private static void selectionSort(int[] array){
        SelectionSort ss = new SelectionSort();
        ss.sort(array);
        System.out.println("Array After Selection sort");
        printArray(array);
        newLine("-");
    }

    private static void quicksort(int[] array){
        QuickSort qs = new QuickSort();
        qs.sort(array,0,array.length-1);
        System.out.println("Array After Quick sort");
        printArray(array);
        newLine("-");
    }

    private static void printArray(int[] array){
        StringBuilder sb = new StringBuilder("[");
        for(int c1=0;c1<array.length-1;c1++)
            sb.append(array[c1]+", ");
        sb.append(array[array.length-1]+"]\n");
        System.out.print(sb.toString());
    }
}
