package ctci.treesNgraphs;

public class PostorderFrom2other {

    public static void main(String[] args){
        int[] _in = {8,4,9,2,10,5,11,1,12,6,13,3,14,7,15};
        int[] _pre = {1,2,4,8,9,5,10,11,3,6,12,13,7,14,15};
        BinaryTreeNode<Integer> tree = construct(_in,_pre,0,0,14);
        postorder(tree);
        /* level order traversal of a Tree*/
        int treeHeight = height(tree);
        System.out.println();
        for(int level=0;level<treeHeight;level++){
            levelTravel(tree,level+1);
            System.out.println();
        }
        /* post order without constructing a Tree. */
        int[] post = new int[_in.length];
        postorder(_in,_pre,post,0,14,0,14);
        for(int c:post){
            System.out.print(c+" ");
        }
    }

    /* print all nodes at a given Level*/
    public static void levelTravel(BinaryTreeNode<Integer> root,int level){
       if(level==1){
           System.out.print(root.content+" ");
       }else if(level>1){
           levelTravel(root.left,level-1);
           levelTravel(root.right,level-1);
       }
    }

    /* Finding height of a Tree  */
    public static int height(BinaryTreeNode<Integer> root){
        if(root!=null){
           return 1+Math.max(height(root.left),height(root.right));
        } return 0;
    }

    public static void postorder(BinaryTreeNode<Integer> node){
        if(node!=null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.content+", ");
        }
    }

    /* construct a BinaryTree from given inorder and preorder Traversal.*/
    private static BinaryTreeNode<Integer> construct(int[] _in, int[] _pre,
                                                     int preStart,
                                                     int inStart,int inEnd){
        BinaryTreeNode<Integer> root = null;
        root = new BinaryTreeNode<>(_pre[preStart]);
        if(inStart<inEnd){
          int c1 = _pre[preStart];
          int _inEnd = -1;
          for(int c=inStart;c<_in.length;c++){
              if(_in[c]==c1){
                  _inEnd = c-1;
                  break;
              }
          }
            BinaryTreeNode<Integer> left = construct(_in,_pre,preStart+1,
                    inStart,_inEnd);
            BinaryTreeNode<Integer> right = construct(_in,_pre,
                    _inEnd-inStart+2+preStart, _inEnd+2,inEnd);
            root.left = left;
            root.right = right;
        }
        return root;
    }

    /* printing postorder traversal From given inorder and preorder traversal
      this method generates post order without constructing a tree. */
    private static void postorder(int[] in,int[] pre,int[] post,
                                  int instart, int inend, int prestart,
                                  int postend){
        post[postend] = pre[prestart];
        if(instart!=inend){
            int root = pre[prestart];
            int leftInEnd = -1;
            for(int c=instart;c<in.length;c++){
                if(root==in[c]){
                    leftInEnd = c-1;
                    break;
                }
            }
            int rightInStart = leftInEnd+2;
            /* left subtree*/
           postorder(in,pre,post,instart,leftInEnd,prestart+1,
                   postend-(leftInEnd-instart+2));
           /* right subtree.*/
           postorder(in,pre,post,rightInStart,inend,leftInEnd-instart+2+prestart,
                   postend-1);
        }
    }

}
