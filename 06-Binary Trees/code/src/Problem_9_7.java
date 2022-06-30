import java.util.*;

public class Problem_9_7 {

    // IMPLEMENT AN INORDER TRAVERSAL WITHOUT RECURSION

    // Write a program which takes as input a binary tree and performs an inorder traversal
    //of the tree. Do not use recursion. Nodes do not contain parent references.

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = Problem_9_1.createBinaryTree2();

        // stack to track left and right nodes
        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();

        // ArrayList to store answer
        List<Integer> ans = new ArrayList<>();

        BinaryTreeNode<Integer> travNode = root;

        // Time 0(n) and space max for stack 0(h)
        while(root!=null || !stack.isEmpty())
        {
            // first if root not null then add it to stack and travserse left
            if(root!=null)
            {
                stack.addFirst(root);
                root = root.left;
            }
            else
            {
                // further left is not possible so for inorder get top node from stack which is root and then go right
                root = stack.removeFirst();

                ans.add(root.data);

                // go right
                root = root.right;
            }
        }

        System.out.println("In Order : "+ans);
    }
}
