import java.util.ArrayList;
import java.util.List;

public class Problem_9_15 {

    // COMPUTE THE EXTERIOR OF A BINARY TREE

    // Write a program that computes the exterior of a binary tree.

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = Problem_9_1.createBinaryTree2();

        System.out.println(getExterior(root));


    }

    // Time 0(n)
    static List<Integer> getExterior(BinaryTreeNode<Integer> root)
    {
        List<Integer> ans = new ArrayList<>();

        // first add root
        if(root==null)
        {
            return ans;
        }

        ans.add(root.data);

        ans.addAll(getLeftBoundaryAndLeaves(root.left,true));

        ans.addAll(getRightBoundaryAndLeaves(root.right,true));


        return ans;
    }

    static List<Integer> getLeftBoundaryAndLeaves(BinaryTreeNode<Integer> node,boolean isBoundary)
    {
        List<Integer> ans = new ArrayList<>();

        // base condition
        if(node==null)
        {
            return ans;
        }

        // we add this only if  boundary or leaves

        if(isBoundary || (node.left==null && node.right==null))
        {
            ans.add(node.data);
        }

        List<Integer> leftNodes = getLeftBoundaryAndLeaves(node.left,isBoundary);

        // in right path only boundary will continue if left path is null
        List<Integer> rightNodes = getLeftBoundaryAndLeaves(node.right,(isBoundary && node.left==null));

        ans.addAll(leftNodes);
        ans.addAll(rightNodes);

        return ans;
    }

    static List<Integer> getRightBoundaryAndLeaves(BinaryTreeNode<Integer> node,boolean isBoundary)
    {
        List<Integer> ans = new ArrayList<>();

        // base condition
        if(node==null)
        {
            return ans;
        }

        if(isBoundary || (node.left==null && node.right==null))
        {
            ans.add(node.data);
        }


        // here we have to go right
        List<Integer> rightNodes = getRightBoundaryAndLeaves(node.right,isBoundary);

        // go with boundary if right subtree is null
        List<Integer> leftNodes = getRightBoundaryAndLeaves(node.left,(isBoundary && node.right==null));

        // here we do leftNodes + rightNodes + ans as we have to first add leaves which obviously in left to right

        leftNodes.addAll(rightNodes);

        leftNodes.addAll(ans);

        return leftNodes;
    }
}
