public class Problem_9_4 {

    // COMPUTE THE LCA WHEN NODES HAVE PARENT POINTERS

    // Given two nodes in a binary tree, design an algorithm that computes their LCA.
    //Assume that each node has a parent pointer.

    public static void main(String[] args) {

    }

    static class BinaryTree<T>{
        BinaryTree<T> left,right,parent;
        T data;

        public BinaryTree(T data,BinaryTree<T> parent,BinaryTree<T> left,BinaryTree<T> right){
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    // TIme 0(h) and space 0(1)
    public static BinaryTree<Integer> LCA(BinaryTree<Integer> node1,BinaryTree<Integer> node2)
    {
        // we get depth for both nodes
        int depth1 = getDepth(node1);
        int depth2 = getDepth(node2);

        // now get depths at same level so we can simultaneously go up and compare both nodes and LCA found easily
        if(depth1>depth2)
        {
            int difference = depth1 - depth2;
            while(difference-->0)
            {
                node1 = node1.parent;
            }
        }

        if(depth2>depth1)
        {
            int difference = depth2 - depth1;
            while (difference-->0)
            {
                node2 = node2.parent;
            }
        }

        // now go up in both nodes and compare
        while(node1!=node2)
        {
            node1 = node1.parent;
            node2=node2.parent;
        }

        return node1;
    }

    public static int getDepth(BinaryTree<Integer> node)
    {
        int depth=0;
        while(node.parent!=null)
        {
            depth++;
            node = node.parent;
        }

        return depth;
    }


}
