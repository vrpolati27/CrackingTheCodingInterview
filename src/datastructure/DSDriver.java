package datastructure;

/**
 * Created by vinayreddypolati on 7/27/17.
 */
public class DSDriver {
    public static void main(String[] args) throws Exception{
        int[] array = {7,2,1,25,3,17,36,19,100};
        HeapTree tree = new HeapTree(false);
        tree.insertAll(array);
        for(int c1=0;c1<array.length;c1++){
            System.out.println(tree.deleteRoot());
            System.out.println(tree);
        }
    }
}
