import java.util.*;

public class Problem_9_11 {

    // IMPLEMENT AN INORDER TRAVERSAL WITH 0(1) SPACE

    // Write a nonrecursive program for computing the inorder traversal sequence for a
    //binary tree. Assume nodes have parent fields.

    public static void main(String[] args) {
        BinaryTreeWithParent<Integer> root = createBinaryTreeWithParent();
        System.out.println(getPreOrder(root));
    }


    // TIme o(n) and space 0(1)
    public static List<Integer> getInOrder(BinaryTreeWithParent<Integer> root)
    {
        List<Integer> ans = new ArrayList<>();

        // we have to use two traversal pointer
        BinaryTreeWithParent<Integer> curr=root,prev=null;

        while(curr!=null)
        {
            BinaryTreeWithParent<Integer> next=null;

            if(curr.parent==prev)
            {
                // here we came down from prev
                // so we have to first keep going left
                if(curr.left!=null)
                {
                    // going left
                    next = curr.left;
                }
                else
                {
                    // left is null it means add curr one data
                    ans.add(curr.data);

                    // and go right if possible otherwise go up
                    next = (curr.right!=null) ? curr.right : curr.parent;
                }
            }
            else if(curr.left==prev)
            {
                // here its only possible when curr left subtree completed so we add curr data
                ans.add(curr.data);

                // and go right subtree of curr if posssible otherwise go up
                next = (curr.right!=null) ? curr.right : curr.parent;

            }
            else
            {
                // here only goes when both left and right subtree completed of curr node
                // so only go up
                next = curr.parent;
            }


            // update curr and prev nodes
            prev = curr;
            curr = next;
        }

        return ans;

    }

    public static List<Integer> getPostOrder(BinaryTreeWithParent<Integer> root)
    {
        List<Integer> ans = new ArrayList<>();

        BinaryTreeWithParent<Integer> curr=root,prev=null;

        while(curr!=null)
        {
            // next to replace curr with next and prev with curr
            BinaryTreeWithParent<Integer> next=null;

            // first check if current below from prev then go left and right
            if(curr.parent==prev)
            {
                // go left if possible
                if(curr.left!=null)
                {
                    next = curr.left;
                }
                else if(curr.right!=null)
                {
                    next = curr.right;
                }
                else
                {
                    // both done so add into ans
                    ans.add(curr.data);

                    // go up
                    next = curr.parent;
                }
            }
            else if(curr.left==prev)
            {
                // here we knew prev nodes done so curr left sub tree completed then go right subtree of curr if possible
                if(curr.right!=null)
                {
                    next = curr.right;
                }
                else
                {
                    // right subtree of curr is null so add curr to ans
                    ans.add(curr.data);
                    // go up
                    next = curr.parent;
                }
            }
            else
            {
                // here prev is in right subtree of curr so add curr and go up
                ans.add(curr.data);

                next = curr.parent;
            }

            // interchange curr with next and prev with curr
            prev = curr;
            curr = next;
        }

        return ans;

    }

    public static List<Integer> getPreOrder(BinaryTreeWithParent<Integer> root)
    {
        List<Integer> ans = new ArrayList<>();

        BinaryTreeWithParent<Integer> curr=root,prev=null;

        while(curr!=null)
        {
            // next to replace curr with next and prev with curr
            BinaryTreeWithParent<Integer> next=null;

            if(curr.parent==prev)
            {
                // add root and then go left and right
                ans.add(curr.data);
                if(curr.left!=null)
                {
                    next = curr.left;
                }
                else if(curr.right!=null)
                {
                    next = curr.right;
                }
                else
                {
                    // go up as left and right done of prev node
                    next = curr.parent;
                }
            }
            else if(curr.left==prev)
            {
                // here curr should already added so go to right subtree of curr if possible
                if(curr.right!=null)
                {
                    next=curr.right;
                }
                else
                {
                    // go up
                    next = curr.parent;
                }
            }
            else
            {
                // here curr right subtree is completed so go up
                next = curr.parent;
            }



            // interchange curr with next and prev with curr
            prev = curr;
            curr = next;
        }

        return ans;

    }



    public static BinaryTreeWithParent createBinaryTreeWithParent(){

        BinaryTreeWithParent<Integer> d1 = new BinaryTreeWithParent<>(9);
        BinaryTreeWithParent<Integer> d2 = new BinaryTreeWithParent<>(3);

        BinaryTreeWithParent<Integer> c1 = new BinaryTreeWithParent<>(1,d1,null);
        BinaryTreeWithParent<Integer> c2 = new BinaryTreeWithParent<>(0,null,d2);
        BinaryTreeWithParent<Integer> c3 = new BinaryTreeWithParent<>(7);
        BinaryTreeWithParent<Integer> c4 = new BinaryTreeWithParent<>(8);

        BinaryTreeWithParent<Integer> b1 = new BinaryTreeWithParent<>(4,c1,c2);
        BinaryTreeWithParent<Integer> b2 = new BinaryTreeWithParent<>(2,c3,c4);

        BinaryTreeWithParent<Integer> root = new BinaryTreeWithParent<>(5,b1,b2);

        b1.parent = root;
        b2.parent = root;

        c1.parent = b1;
        c2.parent = b1;
        c3.parent = b2;
        c4.parent = b2;

        d1.parent = c1;
        d2.parent = c2;

        return root;
    }
}
