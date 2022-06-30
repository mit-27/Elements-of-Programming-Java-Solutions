import java.util.ArrayList;

public class Problem_9_5 {

    // SUM THE ROOT-TO-LEAF PATHS IN A BINARY TREE

    // Design an algorithm to compute the sum of the binary numbers represented by the
    //root-to-leaf paths.

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = createBinaryTree();


        int totalPathSum = getPathsSum(root,0);

        System.out.println(totalPathSum);



    }

    public static BinaryTreeNode createBinaryTree(){

        BinaryTreeNode<Integer> d1 = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> d2 = new BinaryTreeNode<>(0);

        BinaryTreeNode<Integer> c1 = new BinaryTreeNode<>(1,d1,null);
        BinaryTreeNode<Integer> c2 = new BinaryTreeNode<>(1,null,d2);
        BinaryTreeNode<Integer> c3 = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> c4 = new BinaryTreeNode<>(1);

        BinaryTreeNode<Integer> b1 = new BinaryTreeNode<>(0,c1,c2);
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(1,c3,c4);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1,b1,b2);

        return root;
    }

    // Time 0(n) and space 0(h)
    public static int getPathsSum(BinaryTreeNode<Integer> node,int partialSum)
    {
        // Base condition
        if(node==null)
        {
            return 0;
        }

        // we use preorder type recursive
        // get root and add in currentPath
        int newPartialSum = (partialSum * 2) + node.data;

        // Left now if we react at left node then add newCurrentPath and return
        if(node.left==null && node.right==null)
        {
            return newPartialSum;
        }


        // non - left we sum left and right subtree path sum
        return getPathsSum(node.left,newPartialSum) + getPathsSum(node.right,newPartialSum);

    }
}
