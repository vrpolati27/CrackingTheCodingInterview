package sorting_n_searching;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vinayreddypolati on 7/20/17.
 */
public class BucketSort {

    public void sort(int[] array){
        Map<Integer,Integer> bucket = new HashMap();
        for(int c1=0;c1<array.length;c1++){
            int age = array[c1];
            bucket.put(age,bucket.getOrDefault(age,0)+1);
        }
        int index = 0;
        for(int c3=0;c3<=100;c3++){
            int cnt = bucket.getOrDefault(c3,0);
            for(int c2=0;c2<cnt;c2++){
                array[index++] = c3;
            }
        }
    }
}
