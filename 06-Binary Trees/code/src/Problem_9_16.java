public class Problem_9_16 {

    // COMPUTE THE RIGHT SIBLING TREE

    // Description : For this problem, assume that each binary tree node has a extra field, call it level-next,
    //that holds a binary tree node (this field is distinct from the fields for the left and right
    //children). The level-next field will be used to compute a map from nodes to their
    //right siblings. The input is assumed to be perfect binary tree.

    // Write a program that takes a perfect binary tree, and sets each node's level-next field
    //to the node on its right, if one exists.

    public static void main(String[] args) {

    }

    // TIme 0(n)
    static void addRightSibling(BinaryTreeNodeWithNext<Integer> root)
    {
        BinaryTreeNodeWithNext<Integer> leftStart = root;

        // here we go level by level and leftStart points to start of that level at left side
        while(leftStart!=null && leftStart.left!=null)
        {
            // here below function populate below level of leftStart
            populateLowerLevelWithNext(leftStart);
            leftStart = leftStart.left;
        }
    }

    static void populateLowerLevelWithNext(BinaryTreeNodeWithNext<Integer> startNode)
    {
        BinaryTreeNodeWithNext<Integer> iter = startNode;

        while(iter!=null)
        {
            // assign left child's next field
            iter.left.next = iter.right;

            // assign right child's next field if iter is not last node of this level
            if(iter.next!=null)
            {
                iter.right.next = iter.next.left;
            }

            // go to next of this level
            iter = iter.next;

        }

    }



    static class BinaryTreeNodeWithNext<T> {
        public T data; // value of node
        public BinaryTreeNodeWithNext<T> left,right,next;

        public BinaryTreeNodeWithNext(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public BinaryTreeNodeWithNext(T data, BinaryTreeNodeWithNext left, BinaryTreeNodeWithNext right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
