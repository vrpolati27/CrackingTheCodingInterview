package ctci.treesNgraphs;

import ctci.stacksNqueues.MyQueue;

import java.util.ArrayList;
import java.util.List;

public class ListOfDepths {

    public static void main(String[] args){
        String[] tree = {"4","39","41","null","3","8","91","null","null",
                                   "29","null","null","null","null","34"};
        BinaryTreeNode<Integer> root = BTTraversal.buildTree(tree);
        List<List<BinaryTreeNode<Integer>>> lists = depthsList(root);
        for(int c=0;c<lists.size();c++){
            List<BinaryTreeNode<Integer>> row = lists.get(c);
            for(BinaryTreeNode<Integer> node:row)
                System.out.print(node.content+" ");
            System.out.println();
        }
    }

    private static int height(BinaryTreeNode<Integer> root){
        int height = 0;
        if(root!=null){
          height = 1 + Math.max(height(root.left),height(root.right));
        } return height;
    }

    private static List<List<BinaryTreeNode<Integer>>> depthsList(BinaryTreeNode<Integer> root){
        List<List<BinaryTreeNode<Integer>>> lists = new ArrayList<>();
        MyQueue<BinaryTreeNode<Integer>> queue = new MyQueue<>();
        queue.enqueue(root);
        while(!queue.isEmpty()){
           List<BinaryTreeNode<Integer>> thisLevelNodes = new ArrayList<>(queue.size);
           while(!queue.isEmpty())
               thisLevelNodes.add(queue.dequeue());
           for(BinaryTreeNode<Integer> node:thisLevelNodes){
               if(node.left!=null) queue.enqueue(node.left);
               if(node.right!=null) queue.enqueue(node.right);
           } lists.add(thisLevelNodes);
        } return lists;
    }
}
