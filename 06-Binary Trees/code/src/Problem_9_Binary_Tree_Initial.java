import java.util.ArrayList;
import java.util.List;

public class Problem_9_Binary_Tree_Initial {

    // In all time would be 0(n) and space 0(k) where k is height of tree (As at a time max recursive call in stack would be no of height)

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = createBinaryTree2();

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        treeTraversalCombinedAll(root,preOrder,inOrder,postOrder);

        System.out.println("PreOrder : "+preOrder);
        System.out.println("InOrder : "+inOrder);
        System.out.println("PostOrder : "+postOrder);

        System.out.println("========= Seperate PreOrder, InOrder and PostOrder ====================");
        System.out.println("Preorder only : "+preOrderTraversal(root));
        System.out.println("InOrder only : "+inOrderTraversal(root));
        System.out.println("PostOrder only : "+postOrderTraversal(root));



    }

    public static List<Integer> preOrderTraversal(BinaryTreeNode<Integer> root){

        List<Integer> ans = new ArrayList<>();
        if(root!=null)
        {


            // add curent root
            ans.add(root.data);

            // now add result to below recursive calls as we created local variable for ans
            List<Integer> belowLeftRecursiveAns = preOrderTraversal(root.left);
            List<Integer> belowRightRecursiveAns = preOrderTraversal(root.right);

            // First add left as after root it traverse left and then right
            ans.addAll(belowLeftRecursiveAns);

            ans.addAll(belowRightRecursiveAns);


        }

        return ans;
    }

    public static List<Integer> inOrderTraversal(BinaryTreeNode<Integer> root){

        List<Integer> ans = new ArrayList<>();
        if(root!=null)
        {




            // now add result to below recursive calls as we created local variable for ans
            List<Integer> belowLeftRecursiveAns = inOrderTraversal(root.left);
            List<Integer> belowRightRecursiveAns = inOrderTraversal(root.right);

            // First add left as after root it traverse left , root and right
            ans.addAll(belowLeftRecursiveAns);

            // add current root
            ans.add(root.data);

            ans.addAll(belowRightRecursiveAns);


        }

        return ans;
    }

    public static List<Integer> postOrderTraversal(BinaryTreeNode<Integer> root){

        List<Integer> ans = new ArrayList<>();
        if(root!=null)
        {

            // now add result to below recursive calls as we created local variable for ans
            List<Integer> belowLeftRecursiveAns = postOrderTraversal(root.left);
            List<Integer> belowRightRecursiveAns = postOrderTraversal(root.right);

            // First add left as after root it traverse left and then right
            ans.addAll(belowLeftRecursiveAns);

            ans.addAll(belowRightRecursiveAns);

            // add curent root
            ans.add(root.data);


        }

        return ans;
    }

    public static void treeTraversalCombinedAll(BinaryTreeNode<Integer> root,List<Integer> preOrder,List<Integer> inOrder,List<Integer> postOrder)
    {
        if(root != null)
        {
            // For combined solution we first do preorder as in this we have to visit root first rather than traversing left or right
            preOrder.add(root.data);

            // now we traverse left
            treeTraversalCombinedAll(root.left,preOrder,inOrder,postOrder);

            // Below lines execute when left traversal completed and it comes root of last left subtree
            // Because of that we add in inOrder as it visit root after left subtree
            inOrder.add(root.data);

            // now left and root done so remain is right
            treeTraversalCombinedAll(root.right,preOrder,inOrder,postOrder);

            //Below line execute after left and right traversal complete for node
            // so we add data in postOrder
            postOrder.add(root.data);


        }

    }



    public static BinaryTreeNode createBinaryTree1(){
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

    public static BinaryTreeNode createBinaryTree2(){

        BinaryTreeNode<Integer> d1 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> d2 = new BinaryTreeNode<>(3);

        BinaryTreeNode<Integer> c1 = new BinaryTreeNode<>(1,d1,null);
        BinaryTreeNode<Integer> c2 = new BinaryTreeNode<>(0,null,d2);
        BinaryTreeNode<Integer> c3 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> c4 = new BinaryTreeNode<>(8);

        BinaryTreeNode<Integer> b1 = new BinaryTreeNode<>(4,c1,c2);
        BinaryTreeNode<Integer> b2 = new BinaryTreeNode<>(2,c3,c4);

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5,b1,b2);

        return root;
    }





}
