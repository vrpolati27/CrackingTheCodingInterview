package ctci.treesNgraphs;

public class MinimalTree {

    public static void main(String[] args){
        int[] tree = {13,29,31,47,71,111,117,219};
        BinaryTreeNode<Integer> root = minimalTree(tree,0,7);
        System.out.println("left subtree height :"+height(root.left));
        System.out.println("right subtree height :"+height(root.right));
    }

    private static int height(BinaryTreeNode<Integer> root){
        int height = 0;
        if(root!=null)
            height = 1 + Math.max(height(root.left),height(root.right));
        return height;
    }

    private static BinaryTreeNode<Integer> minimalTree(int[] sortedArray,int start, int end){
        if(end<start) return null;
        int mid = start+(end-start)/2/*(start+end)/2*/;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(sortedArray[mid]);
        root.left = minimalTree(sortedArray,start,mid-1);
        root.right = minimalTree(sortedArray,mid+1,end);
        return root;
    }
}
