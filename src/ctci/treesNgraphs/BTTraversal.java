package ctci.treesNgraphs;

import ctci.stacksNqueues.MyQueue;

public class BTTraversal{

    public static void main(String[] args){
      int[] tree = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
      BinaryTreeNode<Integer> root = buildTree(tree);
        System.out.print("inorder traversal :");
      inorderTravel(root);
      System.out.println();
        System.out.print("pre-order traversal :");
        preorderTravel(root);
        System.out.println();
        System.out.print("post-order traversal :");
        postorderTravel(root);
        System.out.println();

        System.out.print("Breadth First Search :");
        bfs(root); System.out.println();


    }

    /* Breadth First traversal*/
    private static void bfs(BinaryTreeNode<Integer> root){
        MyQueue<BinaryTreeNode<Integer>> queue = new MyQueue<>();
        queue.enqueue(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> node = queue.dequeue();
            sb.append(node.content+" ");
            if(node.left!=null)
                queue.enqueue(node.left);
            if(node.right!=null)
                queue.enqueue(node.right);
        } System.out.print("["+sb.toString()+"]");
    }

    /* builds complete binary tree
    *  T(n)=O(n). */
    public static BinaryTreeNode<Integer> buildTree(int[] tree){
        BinaryTreeNode<Integer> root = null;
        int index = 0;
        MyQueue<BinaryTreeNode<Integer>> queue = new MyQueue<>();
        if(index<tree.length){
            root = new BinaryTreeNode<>(tree[index]);
            queue.enqueue(root);
        }
        while(++index<tree.length){
            BinaryTreeNode<Integer> node = queue.dequeue();
            node.left = new BinaryTreeNode<>(tree[index]);
            queue.enqueue(node.left);
            if(++index<tree.length){
                node.right = new BinaryTreeNode<>(tree[index]);
                queue.enqueue(node.right);
            }
        }
        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(String[] tree){
        BinaryTreeNode<Integer> root = null;
        int index = 0;
        MyQueue<BinaryTreeNode<Integer>> queue = new MyQueue<>();
        if(index<tree.length){
            root = new BinaryTreeNode<>(Integer.parseInt(tree[index]));
            queue.enqueue(root);
        }
        while(++index<tree.length){
           BinaryTreeNode<Integer> node = queue.dequeue();
           node.left = tree[index].equals("null")?null:
                   new BinaryTreeNode<>(Integer.parseInt(tree[index]));
           if(node.left!=null) queue.enqueue(node.left);
           if(++index<tree.length){
               node.right = tree[index].equals("null")?null:
                       new BinaryTreeNode<>(Integer.parseInt(tree[index]));
               if(node.right!=null) queue.enqueue(node.right);
           }
        }
        return root;
    }

    /* In-order traversal of a Tree.
    * T(n)=O(n), where n is the #node. */
    public static void inorderTravel(BinaryTreeNode<Integer> root){
        if(root!=null){
            inorderTravel(root.left);
            System.out.print(root.content+" ");
            inorderTravel(root.right);
        }
    }

    /* pre-order traversal of a Tree.
       T(n)=O(n), where n is the #node.*/
    public static void preorderTravel(BinaryTreeNode<Integer> root){
        if(root!=null){
            System.out.print(root.content+" ");
            preorderTravel(root.left);
            preorderTravel(root.right);
        }
    }

    /* post-order traversal of a Tree.
       T(n)=O(n), where n is the #node.*/
    public static void postorderTravel(BinaryTreeNode<Integer> root){
        if(root!=null){
            postorderTravel(root.left);
            postorderTravel(root.right);
            System.out.print(root.content+" ");
        }
    }
}

class BinaryTreeNode<T extends Comparable<T>>{
    T content;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    /* constructor.*/
    public BinaryTreeNode(T content){
        this.content = content;
    }

    /* Properties of a Binary Tree.
    ---------------------------------------
    1. Maximum number of nodes at a level 'k' in BinaryTree are Math.pow(2,k-1).
    2. Maximum number of nodes in a Binary Tree of height 'm' is
                   Math,pow(2,m)-1  /*(2^m - 1)
              = 1+2+3+4+...+Math.pow(2,h-1).
    3. In a Binary Tree with 'N' nodes, minimum levels is log(n) and maximum is 'n'.
           #Levels = [log(n),N]
    4. Number of leaf nodes is always 1 more than nodes with 2 children.
        L = T + 1
        L-> number of leaf nodes
        T-> number of internal nodes with two children.
    ********************************************************
            Types of Binary Tree
        -----------------------------------
      1. Full Binary Tree:
            in a Full Binary Tree Every node has either 0 or 2 children.
      2. Complete Binary Tree
           All the levels are completely filled except possibly the last level and
         last level has all keys as left as possible.
      3. Perfect Binary Tree
           = Full Binary Tree + Complete Binary Tree
      4. Balanced Binary Tree
         Height(Balanced Binary Tree) = log(n), where 'n' is #nodes
      5. Degenerate(or pathological) tree
         skewed Tree.
   --------------------------------------------------------------
    T(traversal)=O(n), 'n' is the height of a Tree
    Space(Dfs)=O(h), h is the height of a tree.
    Space(BFS)=O(w) where w is maximum width of a Tree.

    Note: Extra space required for Bfs is likely to be more when Tree is close to Balanced and
      less when tree is close to a Skewed tree. (vice versa for DepthFirstTravel)
    */
}