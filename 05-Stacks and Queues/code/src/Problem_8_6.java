import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Problem_8_6 {
    // COMPUTE BINARY TREE NODES IN ORDER OF INCREASING DEPTH

    // Binary trees are formally defined in Chapter 10. In particular, each node in a binary
    //tree has a depth, which is its distance from the root.

    // Given a binary tree, return an array consisting of the keys at the same level. Keys
    //should appear in the order of the corresponding nodes' depths, breaking ties from left
    //to right. For example, you should return ((314), (6,6), (271,561, 2, 271), (28, 0,3,1, 28),
    //(17,401, 257), (641)} for the binary tree in Figure 10.1 on Page 150

    public static void main(String[] args) {

        List<List<Integer>> ans = getBinaryTreeNodesOrder(createBinaryTree());

        for(List<Integer> l : ans)
        {
            System.out.println(l);
        }


    }

    // Time 0(n) n = no of nodes in tree space 0(m) m=max nodes in same depth
    private static List<List<Integer>> getBinaryTreeNodesOrder(BinaryTreeNode root) {

        if(root==null)
        {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();


        Deque<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        // first add root
        queue.add(root);

        while(!queue.isEmpty())
        {
            // count to tract prev elements to add in ans List as List
            int count = queue.size();
            List<Integer> currentDepthNodes = new ArrayList<>();

            while(count > 0)
            {
                BinaryTreeNode<Integer> currentNode = queue.removeFirst();
                // add left and right for currentNode at end
                if(currentNode.left != null)
                {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null)
                {
                    queue.add(currentNode.right);
                }

                currentDepthNodes.add(currentNode.data);
                count--;
            }

            ans.add(currentDepthNodes);
        }

        return ans;

    }


    public static BinaryTreeNode createBinaryTree(){
        BinaryTreeNode<Integer> f1 = new BinaryTreeNode<>(641);

        BinaryTreeNode<Integer> e1 = new BinaryTreeNode<>(17);
        BinaryTreeNode<Integer> e2 = new BinaryTreeNode<>(401,null,f1);
        BinaryTreeNode<Integer> e3 = new BinaryTreeNode<>(257);

        BinaryTreeNode<Integer> d1 = new BinaryTreeNode<>(28);
        BinaryTreeNode<Integer> d2 = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> d3 = new BinaryTreeNode<>(3,e1,null);
        BinaryTreeNode<Integer> d4 = new BinaryTreeNode<>(1,e2,e3);
        BinaryTreeNode<Integer> d5 = new BinaryTreeNode<>(28);

        BinaryTreeNode<Integer> c1 = new BinaryTreeNode<>(271,d1,d2);
        BinaryTreeNode<Integer> c2 = new BinaryTreeNode<>(561,null,d3);
        BinaryTreeNode<Integer> c3 = new BinaryTreeNode<>(2,null,d4);
        BinaryTreeNode<Integer> c4 = new BinaryTreeNode<>(271,null,d5);

        BinaryTreeNode<Integer> b1 = new BinaryTreeNode<>(6,c1,c2);
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(6,c3,c4);



        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314,b1,b2);

        return root;

    }


    public static class BinaryTreeNode<T>{
        public T data; // value of node
        public BinaryTreeNode<T> left,right;

        public BinaryTreeNode(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public BinaryTreeNode(T data,BinaryTreeNode left,BinaryTreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
