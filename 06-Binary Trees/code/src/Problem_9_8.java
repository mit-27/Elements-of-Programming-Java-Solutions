import java.util.*;

public class Problem_9_8 {

    // IMPLEMENT A PREORDER TRAVERSAL WITHOUT RECURSION

    // Write a program which takes as input a binary tree and performs a preorder traversal
    //of the tree. Do not use recursion. Nodes do not contain parent references.

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = Problem_9_1.createBinaryTree2();

        // stack to store node which has right traversal remained
        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();

        // list to store ans
        List<Integer> ans = new ArrayList<>();

        BinaryTreeNode<Integer> travNode = root;

        // Time 0(n) and space 0(h)
        while(travNode!=null || !stack.isEmpty())
        {
            // For preOrder first store root and go left of root and add it to stack to remind that right trav remained

            if(travNode!=null)
            {
                ans.add(travNode.data);

                stack.addFirst(travNode);

                // go left
                travNode = travNode.left;
            }
            else
            {
                // fetch from stack and go to right
                travNode = stack.removeFirst();
                travNode = travNode.right;
            }
        }

        System.out.println(ans);

    }
}
