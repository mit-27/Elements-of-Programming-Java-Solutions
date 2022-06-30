import java.util.*;

public class Problem_9_13 {

    // RECONSTRUCT A BINARY TREE FROM A PREORDER TRAVERSAL WITH MARKERS

    // Design an algorithm for reconstructing a binary tree from a preorder traversal visit
    //sequence that uses null to mark empty children.

    // (H, B,F, null,null, E,A,null,null,null, C, null,D, null, G, I, null,null,null)

    public static void main(String[] args) {
        List<Integer> preOrderList = new ArrayList<Integer>(
                Arrays.asList(5,4,1,9,null,null,null,0,null,3,null,null,2,7,null,null,8,null,null)
        );

        BinaryTreeNode<Integer> root = createTreePreOrder(preOrderList);

        System.out.println(Problem_9_Binary_Tree_Initial.preOrderTraversal(root));


    }

    // Time 0(n) and space 0(h)
    public static BinaryTreeNode<Integer> createTreePreOrder(List<Integer> preOrder)
    {
        // we will use stack to track
        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();



        // we start iterate preOrder from behind
        for(int i=preOrder.size()-1;i>=0;i--)
        {
            // if val is null then we push to stack
            if(preOrder.get(i)==null)
            {
                stack.addFirst(null);
            }
            else
            {
                // make node from current val and left and right would be on top of stack
                BinaryTreeNode<Integer> currRoot = new BinaryTreeNode<>(preOrder.get(i));
                currRoot.left = stack.removeFirst();
                currRoot.right = stack.removeFirst();

                // now add this node to stack
                stack.addFirst(currRoot);
            }
        }

        // after this only one node remain in stack which is root
        return stack.removeFirst();
    }
}
