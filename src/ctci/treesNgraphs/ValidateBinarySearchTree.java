package ctci.treesNgraphs;


import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    public static void main(String[] args){
        String[] tree1 = {"47","29","111","13","31","71","117","null",
                "null","null","null","null","null","null","219"};
        String[] tree2 = {"4","39","41","null","3","8","91","null","null",
                "29","null","null","null","null","34"};
        BinaryTreeNode<Integer> root1 = BTTraversal.buildTree(tree1);
        BinaryTreeNode<Integer> root2 = BTTraversal.buildTree(tree2);
        System.out.println("isBinarySearchTree(tree1) :"+isBST(root1));
        System.out.println("isBinarySearchTree(tree2) :"+isBST(root2));
        System.out.println("isBinarySearchTree2(tree1) :"+isBST2(root1));
        System.out.println("isBinarySearchTree2(tree2) :"+isBST2(root2));
    }

    /* returns true given tree is Binary Search Tree, false otherwise
    * Note: This works only if tree does not contain duplicates.
    * Tree is Binary Search tree iff its inorder traversal is in ascending order.*/
    private static boolean isBST(BinaryTreeNode<Integer> root){
        List<Integer> inorder = new ArrayList<>();
        inorder(root,inorder);
        /*System.out.println("inorder("+root.content+"):"+inorder);*/
        int prev = Integer.MIN_VALUE;
        for(int c=0;c<inorder.size();c++){
            int cur = inorder.get(c);
            if(cur<prev) return false;
            prev = cur;
        }
        return true;
    }

    private static void inorder(BinaryTreeNode<Integer> root,List<Integer> order){
        if(root==null) return;
        inorder(root.left,order);
        order.add(root.content);
        inorder(root.right,order);
    }

    /* This method works just fine for tree with any kind of data, unlike above
     * method which doesn't work for trees with duplicate entries.  */
    private static boolean isBST2(BinaryTreeNode<Integer> root){
        if(root==null) return true;
        int data = root.content;
        int left = root.left!=null?root.left.content:Integer.MIN_VALUE;
        int right = root.right!=null?root.right.content:Integer.MAX_VALUE;
        return (left<=data && data<right) && isBST2(root.left) && isBST2(root.right);
    }

}
