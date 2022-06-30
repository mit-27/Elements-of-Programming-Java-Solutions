import java.util.*;

public class Problem_9_6 {

    // FIND A ROOT TO LEAF PATH WITH SPECIFIED SUM

    // Write a program which takes as input an integer and a binary tree with integer node
    //weights, and checks if there exists a leaf whose path weight equals the given integer.


    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = Problem_9_1.createBinaryTree2();

        System.out.println(checkSum(50,root));


    }

    // Time 0(n) and space 0(h)
    static boolean checkSum(int targetSum,BinaryTreeNode<Integer> root)
    {
        return checkSumHelper(targetSum,0,root);
    }

    static boolean checkSumHelper(int targetSum,int currentSum,BinaryTreeNode<Integer> root)
    {
        // base condiotion
        // For non-leaf nodes
        if(root==null)
        {
            // not leaf node
            return false;
        }

        // add currentnode weight to currentSum
        currentSum = currentSum + root.data;


        // For leaf nodes
        if(root.left==null && root.right==null)
        {
            return currentSum==targetSum;
        }

        // call recursive to left and right sub tree to reach leafs

        return checkSumHelper(targetSum,currentSum,root.left) || checkSumHelper(targetSum,currentSum,root.right);


    }
}
