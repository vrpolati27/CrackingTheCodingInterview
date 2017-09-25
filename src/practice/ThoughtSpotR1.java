package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinayreddypolati on 7/17/17.
 */  /* Pascal's Triangle v2.0
 *         [2,3]
 *         [2,5,3]
 *         [2,7,5,8,3]
 *         [2,9,7,12,5,13,8,11,3]
 *         [2,11,9,16,7,19,12,17,5,,18,13,21,8,19,11,14,3]*/
public class ThoughtSpotR1 {
    public static void main(String[] args){
        int[] firstElements = {2,3};
        printTriangle(firstElements,4);
        System.out.println(getPascalElementAt(firstElements,4,5));
    }

    private static void printTriangle(int[] firstElements,int iteration){
        int itr = 1;
        List<List<Integer>> triangle = new ArrayList();
        List<Integer> firstRow = new ArrayList();
        for(int num:firstElements)
            firstRow.add(num);
        triangle.add(firstRow);
        while(itr<=iteration){
            int prevRowLength = triangle.get(triangle.size()-1).size();
            /*System.out.println(prevRowLength*2-1);*/
            List<Integer> mRow = new ArrayList((prevRowLength*2)-1);
            for(int m1=0;m1<(prevRowLength*2-1);m1++){
                if(isEven(m1))
                    mRow.add(m1,triangle.get(triangle.size()-1).get(m1/2));
                else mRow.add(m1,triangle.get(triangle.size()-1).get(m1/2)+
                        triangle.get(triangle.size()-1).get((m1/2)+1));
            }
            triangle.add(mRow);
            itr++;
        } printTriangle(triangle);
    }
    private static void printTriangle(List<List<Integer>> triangle){
        for(int m1=0;m1<triangle.size();m1++){
            List<Integer> mthRow = triangle.get(m1);
            System.out.println(mthRow);
        }
    }

    /* returns element at given index in the Pascals triangle at mth iteration,
    * T(n) = O(2^m).// can Reduce this to O(m) by Memoizing results,
    *                                                     (Dynamic Programming) */
    private static int getPascalElementAt(int[] firstElements,int iteration/*m*/,
                                          int index){
        int result = Integer.MIN_VALUE;
        if(iteration==0){
            if(index>=0 && index<firstElements.length)
                result = firstElements[index];
            else{
                try{
                    throw new Exception("IndexOutOfBoundsException");
                }catch (Exception ex){
                    System.out.println(ex.toString());
                }
            }
        }else if(isEven(index)){
            result =  getPascalElementAt(firstElements,iteration-1,index/2);
        }else{
            result =  getPascalElementAt(firstElements,iteration-1,index/2)+
                    getPascalElementAt(firstElements,iteration-1,index/2+1);
        }
        return result;
    }

    private static boolean isEven(int number){
        if((1&number) == 1) return false;
        else return true;
    }
}
