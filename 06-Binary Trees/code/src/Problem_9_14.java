import java.util.ArrayList;
import java.util.List;

public class Problem_9_14 {

    // FORM A LINKED LIST FROM THE LEAVES OF A BINARY TREE

    // Given a binary tree, compute a linked list from the leaves of the binary tree. The
    //leaves should appear in left-to-right order.

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = Problem_9_1.createBinaryTree2();

        System.out.println(getLeaves(root));


    }


    // Time 0(n)
    static List<Integer> getLeaves(BinaryTreeNode<Integer> root)
    {
        // follow recursive like post or inorder

        List<Integer> ans = new ArrayList<>();

        // base condition
        if(root==null)
        {
            return ans;
        }

        if(root.left==null && root.right==null)
        {
            ans.add(root.data);

            return ans;
        }

        // get left and right nodes
        List<Integer> leftLeaves = getLeaves(root.left);
        List<Integer> rightLeaves= getLeaves(root.right);

        // append to ans and return
        ans.addAll(leftLeaves);
        ans.addAll(rightLeaves);

        return ans;
    }
}
