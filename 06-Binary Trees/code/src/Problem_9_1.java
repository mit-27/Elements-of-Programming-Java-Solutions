public class Problem_9_1 {

    // TEST IF A BINARY TREE IS HEIGHT-BALANCED

    // A binary tree is said to be height-balanced if for each node in the tree, the difference
    //in the height of its left and right subtrees is at most one. A perfect binary tree is
    //height-balanced, as is a complete binary tree. A height-balanced binary tree does not
    //have to be perfect or complete


    // Write a program that takes as input the root of a binary tree and checks whether the
    //tree is height-balanced.

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = createBinaryTree2();

        System.out.println("Tree Balanced : "+checkTreeBalanced(root));

    }

    public static boolean checkTreeBalanced(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return true;
        }

        // Here we call left and right subtree height
        int leftSubTreeHeight = getHeight(root.left);

        // If we get -1 that means tree is unbalance
        if(leftSubTreeHeight==-1)
        {
            return false;
        }

        int rightSubTreeHeight = getHeight(root.right);

        if(rightSubTreeHeight==-1)
        {
            return false;
        }

        // check diffrence of left and right for balaced tree <=1

        if(Math.abs(leftSubTreeHeight-rightSubTreeHeight)<=1)
        {
            // Tree is balaced
            return true;
        }

        return false;


    }

    // It will get left and right sub trees height and compares to check whether it balance or not
    // It not balance then it return -1
    public static int getHeight(BinaryTreeNode<Integer> root)
    {
        int height = 0;
        if(root!=null)
        {   // make curent height 1
            height=1;

            int leftSubTreeHeight = getHeight(root.left);

            // check if leftTreeHeight is -1 then tree is unbalanced and so return
            if(leftSubTreeHeight==-1)
            {
                return -1;
            }

            int rightSubTreeHeight = getHeight(root.right);

            if(rightSubTreeHeight==-1)
            {
                return -1;
            }

            // for balance tree difference of left and right subtree would be <=1
            if(Math.abs(leftSubTreeHeight-rightSubTreeHeight)<=1)
            {
                // it is balance so we add current node height with max depth from left and right

                int returnHeight = Math.max(leftSubTreeHeight,rightSubTreeHeight) + height;

                return returnHeight;
            }
            else
            {
                return -1;
            }


        }

        return height;

    }

    public static BinaryTreeNode createBinaryTree2(){

        BinaryTreeNode<Integer> d1 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> d2 = new BinaryTreeNode<>(3);

        BinaryTreeNode<Integer> c1 = new BinaryTreeNode<>(1,d1,null);
        BinaryTreeNode<Integer> c2 = new BinaryTreeNode<>(0,null,d2);
        BinaryTreeNode<Integer> c3 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> c4 = new BinaryTreeNode<>(8);

        BinaryTreeNode<Integer> b1 = new BinaryTreeNode<>(4,c1,c2);
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(2,c3,c4);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5,b1,b2);

        return root;
    }
}
