public class Problem_9_3 {

    // COMPUTE THE LOWEST COMMON ANCESTOR IN A BINARY TREE

    // Any two nodes in a binary tree have a common ancestor, namely the root. The lowest
    //common ancestor (LCA) of any two nodes in a binary tree is the node furthest from
    //the root that is an ancestor of both nodes.

    // Q : Design an algorithm for computing the LCA of two nodes in a binary tree in which
    //nodes do not have a parent field.

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = Problem_9_1.createBinaryTree2();

        BinaryTreeNode<Integer> anc = getLCANode(root,root.left.left.left,root.left.left);
        System.out.println("Ancestor : "+anc.data);

    }


    static class ExtraInfoNode {
        public int numOfTargetNodes;
        public BinaryTreeNode<Integer> ancestor;

        public ExtraInfoNode(int numOfTargetNodes,BinaryTreeNode<Integer> ancestor)
        {
            this.numOfTargetNodes = numOfTargetNodes;
            this.ancestor = ancestor;
        }
    }

    // Time 0(n) and space 0(h)
    static BinaryTreeNode<Integer> getLCANode(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> node1,BinaryTreeNode<Integer> node2)
    {
        return getLCAHelper(root,node1,node2).ancestor;
    }

    // We use recursive like postOrder
    static ExtraInfoNode getLCAHelper(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> node1,BinaryTreeNode<Integer> node2)
    {
        // Base condition
        if(root==null)
        {
            return new ExtraInfoNode(0,null);
        }

        // get left subtree and right subtree
        ExtraInfoNode leftSubTree = getLCAHelper(root.left,node1,node2);

        // check if left subtree has two numOfExtranodes means we found both nodes in subtree so return current its ancestor
        if(leftSubTree.numOfTargetNodes==2)
        {
            return leftSubTree;
        }

        // Do same for rightsubTree
        ExtraInfoNode rightSubTree = getLCAHelper(root.right,node1,node2);

        if(rightSubTree.numOfTargetNodes==2)
        {
            return rightSubTree;
        }

        // append prev numOfNodes result
        int numOfnodes = leftSubTree.numOfTargetNodes + rightSubTree.numOfTargetNodes;

        // check for node1 and node2
        if(root==node1)
        {
            numOfnodes++;
        }

        if(root==node2)
        {
            numOfnodes++;
        }

        // if we get both nodes then add current root as ancestor
        if(numOfnodes==2)
        {
            return new ExtraInfoNode(numOfnodes,root);
        }

        // else return null as ancestor
        return new ExtraInfoNode(numOfnodes,null);

    }
}
