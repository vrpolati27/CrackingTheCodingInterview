package ctci.treesNgraphs;

import ctci.stacksNqueues.MyQueue;
import ctci.stacksNqueues.MyStack;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeBoundaryTraversal {

    public static void main(String[] args){
        /* Travelling tree boundary in anti-clockwise direction*/
        MyStack<Integer> right = new MyStack<>(); /* right boundary*/
        MyQueue<Integer> left = new MyQueue<>();/* left Boundary*/
        int[] tree = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        BinaryTreeNode<Integer> root = BTTraversal.buildTree(tree);
        lefttbRightbt(root,right,left);
        MyQueue<Integer> leafs = new MyQueue<>();
        leafsL2R(root,leafs);
       StringBuilder sb = new StringBuilder();
       /*left.dequeue();*/
       while(!left.isEmpty())
           sb.append(left.dequeue()+" ");
       /*leafs.dequeue();*/
       while(!leafs.isEmpty())
           sb.append(leafs.dequeue()+" ");
       /*right.pop();*/
       while(!right.isEmpty())
           sb.append(right.pop()+" ");
    }

    /* print Left boundary(top-to-bottom) of a Tree,
    *  Right boundary(bottom-to-top)*/
    private static void lefttbRightbt(BinaryTreeNode<Integer> root,
            MyStack<Integer> right, MyQueue<Integer> left){
        BinaryTreeNode<Integer> treeRoot = root;
        /* left */
        while(root!=null){
             left.enqueue(root.content);
             root = root.left;
        }

        /* right */
        while(treeRoot!=null){
            right.push(treeRoot.content);
            treeRoot = treeRoot.right;
        }
    }

    /* prints leaf nodes from Left to Right. */
    private static void leafsL2R(BinaryTreeNode<Integer> root, MyQueue<Integer> leafs){
        MyStack<BinaryTreeNode<Integer>> stack = new MyStack<>();
        stack.push(root);
        Map<BinaryTreeNode<Integer>,Boolean> visit = new HashMap<>();
        while(!stack.isEmpty()){
            BinaryTreeNode<Integer> cur = stack.peek();
            if(cur.left==null && cur.right==null){
                stack.pop();
                visit.put(cur,true);
                leafs.enqueue(cur.content);
            }
            else{
                if(cur.left!=null && !visit.getOrDefault(cur.left,false)){
                    stack.push(cur.left);
                    continue;
                }
                if(cur.right!=null && !visit.getOrDefault(cur.right,false)){
                    stack.push(cur.right);
                    continue;
                }
                    stack.pop();
                    visit.put(cur,true);

            }
        }
    }

}
