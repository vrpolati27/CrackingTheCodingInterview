package ctci.treesNgraphs;

public class CheckBalanced {

    public static void main(String[] args){
        String[] tree1 = {"47","29","111","13","31","71","117","null",
                "null","null","null","null","null","null","219"};
        String[] tree2 = {"4","39","41","null","3","8","91","null","null",
                "29","null","null","null","null","34"};
        BinaryTreeNode<Integer> root = BTTraversal.buildTree(tree1);
        BinaryTreeNode<Integer> root2 = BTTraversal.buildTree(tree2);
        System.out.println("isBalanced(root1) :"+isBalanced(root ));
        System.out.println("isBalanced(root2) :"+isBalanced(root2));
    }

    private static int height(BinaryTreeNode<Integer> root){
      int height = 0;
      if(root!=null){
        height = 1+Math.max(height(root.left),height(root.right));
      } return height;
    }

    /* T(n)=O(nlog(n)).  */
    private static boolean isBalanced(BinaryTreeNode<Integer> root){
      boolean isBalanced = true;
      if(root!=null){
        isBalanced =  Math.abs(height(root.left)-height(root.right))<2 &&
                isBalanced(root.left) && isBalanced(root.right);
      } return isBalanced;
    }
}
