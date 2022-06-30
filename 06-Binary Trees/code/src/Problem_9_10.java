import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Problem_9_10 {

    // COMPUTE THE SUCCESSOR

    // The successor of a node in a binary tree is the node that appears immediately after
    //the given node in an inorder traversal.

    // Design an algorithm that computes the successor of a node in a binary tree. Assume
    //that each node stores its parent.

    public static void main(String[] args) {



    }

    // Time 0(h)
    static BinaryTreeWithParent findSuccessor(BinaryTreeWithParent<Integer> node)
    {
        BinaryTreeWithParent<Integer> iterNode = node;

        if(iterNode.right!=null)
        {
            // ans is left most element of node's right subtree
            iterNode = iterNode.right;
            while(iterNode.left!=null)
            {
                iterNode = iterNode.left;
            }

            return iterNode;
        }

        // for node which do not have right sub tree
        // closest ancestor whose left subtree contains node
        while(iterNode.parent!=null && iterNode.parent.right==iterNode)
        {
            iterNode = iterNode.parent;
        }

        return iterNode.parent;

    }






}
