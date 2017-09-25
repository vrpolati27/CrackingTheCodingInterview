package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vinayreddypolati on 7/27/17.
 */
public class PriorityHeap<T> {
    private static class DijkstrasNode<T>{
        T nodeName;
        int priority;
        /* default priority is Integer.MAX_VALUE; */
        public DijkstrasNode(T nodeName){
            this.nodeName = nodeName;
            this.priority = Integer.MAX_VALUE;
        }
        /*public DijkstrasNode(T nodeName, int priority){
            this.nodeName = nodeName;
            this.priority = priority;
        }*/
    }



    private Map<T,Integer> map = new HashMap<>();

    /* stores */
    private List<DijkstrasNode<T>> tree = new ArrayList<>();

    public void makeHeap(List<T> nodes,T source){
        int index = 0;
       for(T node:nodes){
           DijkstrasNode<T> c1 = new DijkstrasNode<T>(node);
           if(node.equals(source)){
               map.put(node,index++);
               c1.priority = 0;
               tree.add(c1);
           }else{
               map.put(node,index++);
               tree.add(c1);
           }
           makeItMinHeap();
       }
    }

    private void makeItMinHeap(){
        if(tree.size()>1){
            int _mid = isEven(tree.size()-1)?(tree.size()-3)/2:(tree.size()-2)/2;
            for(int c1=_mid;c1>=0;c1--){
                makeItHeapNode(c1);
            }
        }
    }

    private void makeItHeapNode(int c1){
       int right = 2*c1+2;
       int left = right-1;
        int small = -1;
       if(right<tree.size()){
           small = tree.get(right).priority<tree.get(left).priority?right:left;
       }else if(left<tree.size()){
           small = left;
       }
        if(tree.get(c1).priority>tree.get(small).priority){
            /* swap node with its smallest child*/
            DijkstrasNode<T> temp = tree.get(c1);
            tree.set(c1,tree.get(small));
            tree.set(small,temp);
            /* update map for O(1) access to nodes.*/
            map.put(temp.nodeName,small);
            map.put(tree.get(c1).nodeName,c1);
        }
    }

    private boolean isEven(int num){
       if( (num & 1)==0) return true;
       else return false;
    }

    public boolean isEmpty(){
        return tree.size()==0;
    }

    public T deleteMin(){
        T minNode = tree.get(0).nodeName;
        tree.set(0,tree.get(tree.size()-1));
        tree.remove(tree.size()-1);
        int _mid = isEven(tree.size()-1)?(tree.size()-3)/2:(tree.size()-2)/2;
        int cur = 0;
        while(cur<=_mid){
          int right = 2*cur+2;
          int left = right-1;
          int small = -1;
          if(right<tree.size()){
             if(tree.get(cur).priority<tree.get(right).priority &&
                     tree.get(cur).priority<tree.get(left).priority)
                 break;
              small = tree.get(right).priority<tree.get(left).priority?right:left;
          }else if(left<tree.size()){
              if(tree.get(cur).priority<tree.get(left).priority)
                  break;
              small = left;
          }
          /* swap node.*/
          DijkstrasNode<T> temp = tree.get(cur);
          tree.set(cur,tree.get(small));
          tree.set(small,temp);
          map.put(tree.get(small).nodeName,small);
          map.put(tree.get(cur).nodeName,cur);
          cur = small;
        } return minNode;
    }

    public void updatePriority(T nodeName, int priority){
        int c1 = map.get(nodeName);
        tree.get(c1).priority = priority;
        int _c1Parent = isEven(c1)?(c1-2)/2:(c1-1)/2;
        for(int c3=_c1Parent;c3>=0;){
            makeItHeapNode(c3);
            if(c3==0) break;
            c3 = isEven(c3)?(c3-2)/2:(c3-1)/2;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int c1=0;c1<tree.size()-1;c1++){
            sb.append("("+tree.get(c1).nodeName+","+tree.get(c1).priority+"), ");
        }if(tree.size()>0)
            sb.append("("+tree.get(tree.size()-1).nodeName+","+tree.get(tree.size()-1).priority+")");
        sb.append("}");
        return sb.toString();
    }
}
