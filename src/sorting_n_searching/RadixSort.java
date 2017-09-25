package sorting_n_searching;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinayreddypolati on 7/20/17.
 */
public class RadixSort {

    public void sort(int[] array){
        List<Integer>[] parts = new ArrayList[10];
        for(int c3=0;c3<10;c3++){
            parts[c3] = new ArrayList<>();
        }
        
        int _max = max(array);
        int maxDigitsCnt = new Integer(_max).toString().length();
        for(int c1=1;c1<=maxDigitsCnt;c1++){
            int divider = (int)Math.pow(10,c1-1);
            clear(parts);
            for(int c2=0;c2<array.length;c2++){
                int c = array[c2]/divider;
                parts[c %10].add(array[c2]);
            }
            int index = 0;
            for(List<Integer> list:parts){
                for(int num:list)
                    array[index++] = num;
            }
        }
    }

    private void clear(List<Integer>[] parts){
        for(int c1=0;c1<parts.length;c1++){
            parts[c1].clear();
        }
    }
    private int max(int[] array){
        int max = Integer.MIN_VALUE;
        for(int c1=0;c1<array.length;c1++){
            if(array[c1]>max) max = array[c1];
        } return max;
    }
}
