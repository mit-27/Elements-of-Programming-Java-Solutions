import java.util.*;

public class Problem_9_12 {

    // RECONSTRUCT A BINARY TREE FROM TRAVERSAL DATA

    // Given an inorder traversal sequence and a preorder traversal sequence of a binary
    //tree write a program to reconstruct the tree. Assume each node has a unique key.

    public static void main(String[] args) {
        int[] preOrder = new int[]{5,4,1,9,0,3,2,7,8};
        int[] inOrder = new int[]{9,1,4,0,3,5,7,2,8};
        int[] postOrder = new int[]{9,1,3,0,4,7,8,2,5};
        BinaryTreeNode<Integer> root = createTreeFromPreOrderInOrder(preOrder,inOrder);
        System.out.println("PostOrder After preInorder using : "+Problem_9_Binary_Tree_Initial.postOrderTraversal(root));

        System.out.println("PreOrder using postInorder : "+Problem_9_Binary_Tree_Initial.preOrderTraversal(createTreeFromPostOrderInOrder(postOrder,inOrder)));
    }

    private static BinaryTreeNode<Integer> createTreeFromPreOrderInOrder(int[] preOrder, int[] inOrder) {

        // store inorder with index in hashmap as inorder index will decide how much nodes we have to
        // include in left and right subtree

        Map<Integer,Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i],i);
        }

        return createTreeFromPreOrderInOrderHelper(0,preOrder.length-1,0,inOrder.length-1,inOrderMap,preOrder,inOrder);

    }

    static BinaryTreeNode<Integer> createTreeFromPreOrderInOrderHelper(int preOrderStart,int preOrderEnd,int inOrderStart,int inOrderEnd,
                                               Map<Integer,Integer> inOrderMap,int[] preOrder,int[] inOrder)
    {

        // Base Condition mostly apply for null nodes
        if(preOrderStart>preOrderEnd || inOrderStart>inOrderEnd)
        {
            return null;
        }

        // From preorder we get root
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[preOrderStart]);

        // get middle which divide left and right subtree from inorder array
        int middle = inOrderMap.get(preOrder[preOrderStart]);

        int leftTreeSize = middle - inOrderStart;

        // get left subtree
        root.left = createTreeFromPreOrderInOrderHelper(preOrderStart+1,preOrderStart+leftTreeSize,
                inOrderStart,middle-1,inOrderMap,preOrder,inOrder);

        root.right = createTreeFromPreOrderInOrderHelper(preOrderStart+leftTreeSize+1,preOrderEnd,middle+1,
                inOrderEnd,inOrderMap,preOrder,inOrder);


        return root;



    }

    private static BinaryTreeNode<Integer> createTreeFromPostOrderInOrder(int[] postOrder, int[] inOrder) {

        // store inorder with index in hashmap as inorder index will decide how much nodes we have to
        // include in left and right subtree

        Map<Integer,Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i],i);
        }

        // For postOrder root lies at end of array
        return createTreeFromPostOrderInOrderHelper(postOrder.length-1, 0,0,inOrder.length-1,inOrderMap,postOrder,inOrder);

    }

    static BinaryTreeNode<Integer> createTreeFromPostOrderInOrderHelper(int postOrderStart,int postOrderEnd,int inOrderStart,int inOrderEnd,
                                                                       Map<Integer,Integer> inOrderMap,int[] postOrder,int[] inOrder)
    {

        // Base Condition mostly apply for null nodes
        // Here we start from back in postorder and front inorder
        if(postOrderStart<postOrderEnd || inOrderStart>inOrderEnd)
        {
            return null;
        }


        // From preorder we get root
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postOrder[postOrderStart]);

        // get middle to divide left and right subtree from inOrder
        int middle = inOrderMap.get(postOrder[postOrderStart]);

        // get size of right subtree of root
        int rightSubTreeSize = inOrderEnd -  middle;

        // In PostOrder after root assigned prev elements from postStart-1 to size would be right Subtree

        root.right = createTreeFromPostOrderInOrderHelper(postOrderStart-1,postOrderStart-rightSubTreeSize,
                middle+1,inOrderEnd,inOrderMap,postOrder,inOrder);

        root.left = createTreeFromPostOrderInOrderHelper(postOrderStart-rightSubTreeSize-1,postOrderEnd,
                inOrderStart,middle-1,inOrderMap,postOrder,inOrder);


        return root;


    }
}
