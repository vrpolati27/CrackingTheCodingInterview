package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinayreddypolati on 7/27/17.
 */
public class HeapTree{
    /*private static class TreeNode<T>{
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data){
            this.data = data;
        }
    }*/

    public boolean isMinHeap = true;
    private List<Integer> tree = new ArrayList<>();

    public HeapTree(boolean isMinHeap){
        this.isMinHeap = isMinHeap;
    }


    public void insertNode(int element){
        tree.add(element);
        makeHeap();
    }

    public void insertAll(int[] array){
        for(int c1:array)
           tree.add(c1);
        makeHeap();
    }

    public int deleteRoot() throws Exception {
        if(tree.size()==0) throw new Exception("EmptyTreeException");
        int root = tree.get(0);
        tree.set(0,tree.get(tree.size()-1));
        tree.remove(tree.size()-1);
        int cur = 0;
        int _mid = isEven(tree.size()-1)?(tree.size()-3)/2:(tree.size()-2)/2;
        while(cur<=_mid){
            int right = cur*2+2;
            int left = right-1;
            if(right<tree.size()){
               if((isMinHeap && tree.get(cur)<tree.get(right) && tree.get(cur)<tree.get(left)) ||
                       (!isMinHeap && tree.get(cur)>tree.get(right) && tree.get(cur)>tree.get(left)))
                   break;
               int c1 = tree.get(left)<tree.get(right)?(isMinHeap?left:right):(isMinHeap?right:left);
               int temp = tree.get(cur);
               tree.set(cur,tree.get(c1));
               tree.set(c1,temp);
               cur = c1;
            }else if(left<tree.size()){
               if((isMinHeap && tree.get(cur)<tree.get(left)) ||
                       (!isMinHeap && tree.get(cur)>tree.get(left)))
                   break;
               int temp = tree.get(cur);
               tree.set(cur,tree.get(left));
               tree.set(left,temp);
               cur = left;
            }
        }
        return root;
    }

    private boolean isEven(int num){
        if((num & 1) == 0) return true;
        else return false;
    }
    private void makeHeap(){
        for(int c1=tree.size()/2;c1>=0;c1--){
           makeMinHeapNode(c1);
        }
    }

    private void makeMinHeapNode(int c1){
      int rightChildIndex = 2*c1+2;
      int leftChildIndex = rightChildIndex-1;
      if(rightChildIndex<tree.size()){
          int small = tree.get(rightChildIndex)<tree.get(leftChildIndex)?
                  (isMinHeap?rightChildIndex:leftChildIndex):
                  (isMinHeap?leftChildIndex:rightChildIndex);
          if( (isMinHeap && tree.get(c1)>tree.get(small)) ||
                  (!isMinHeap && tree.get(c1)<tree.get(small))){
              int temp = tree.get(c1);
              tree.set(c1,tree.get(small));
              tree.set(small,temp);
          }
      }else if(leftChildIndex<tree.size()){
         if((isMinHeap && tree.get(c1)>tree.get(leftChildIndex)) ||
                 (!isMinHeap && tree.get(c1)>tree.get(leftChildIndex))){
              int temp = tree.get(c1);
              tree.set(c1,tree.get(leftChildIndex));
              tree.set(leftChildIndex,temp);
          }
      }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int c1=0;c1<tree.size()-1;c1++){
            sb.append(tree.get(c1)+", ");
        }
        if(tree.size()>0)sb.append(tree.get(tree.size()-1));
        sb.append("]");
        return sb.toString();
    }
}
