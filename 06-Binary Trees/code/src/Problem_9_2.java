public class Problem_9_2 {

    // TEST IF A BINARY TREE IS SYMMETRIC

    // A binary tree is symmetric if you can draw a vertical line through the root and then
    //the left subtree is the mirror image of the right subtree.

    public static void main(String[] args) {

        BinaryTreeNode<Integer> asymetricTree = createBinaryTreeAsymmetric();
        System.out.println("Tree is Symmetric : "+checkSymmetric(asymetricTree));

        BinaryTreeNode<Integer> symetricTree = createBinaryTreeSymmetric();
        System.out.println("Tree is Symmetric : "+checkSymmetric(symetricTree));

    }

    // Time : 0(n) and space 0(h) where h = height n=nodes in tree
    static boolean checkSymmetric(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return true;
        }

        // For symmetric root's left and right subtree will check
        return checkSymmetricHelper(root.left,root.right);
    }

    // root1 = left subtree root2 = right subtree
    static boolean checkSymmetricHelper(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2)
    {

        // base condition = both are null
        if((root1==null) && (root2==null))
        {
            return true;
        }

        // For symmetric root1 and root2 would be same
        if((root1!=null && root2!=null) && root1.data==root2.data)
        {
            // NOTE (IMP) : For symmetric : root1.left should be same as root2.right, root1.right == roo2.left

            return checkSymmetricHelper(root1.left,root2.right) && checkSymmetricHelper(root1.right,root2.left);
        }

        // otherwise return false as above conditions does not matched
        return false;


    }

    public static BinaryTreeNode createBinaryTreeAsymmetric(){

//        BinaryTreeNode<Integer> d1 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> d2 = new BinaryTreeNode<>(3);

//        BinaryTreeNode<Integer> c1 = new BinaryTreeNode<>(1,d1,null);
        BinaryTreeNode<Integer> c2 = new BinaryTreeNode<>(0,null,d2);
        BinaryTreeNode<Integer> c3 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> c4 = new BinaryTreeNode<>(8);

        BinaryTreeNode<Integer> b1 = new BinaryTreeNode<>(4,null,c2);
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(2,c3,c4);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5,b1,b2);

        return root;
    }

    public static BinaryTreeNode createBinaryTreeSymmetric(){

        BinaryTreeNode<Integer> d1 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> d2 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> d3 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> d4 = new BinaryTreeNode<>(3);

        BinaryTreeNode<Integer> c1 = new BinaryTreeNode<>(1,d1,d2);
        BinaryTreeNode<Integer> c2 = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> c3 = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> c4 = new BinaryTreeNode<>(1,d3,d4);


        BinaryTreeNode<Integer> b1 = new BinaryTreeNode<>(2,c1,c2);
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(2,c3,c4);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5,b1,b2);

        return root;
    }


}
