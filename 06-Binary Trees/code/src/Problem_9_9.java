public class Problem_9_9 {

    // COMPUTE THE km NODE IN AN INORDER TRAVERSAL

    // Write a program that efficiently computes the kth node appearing in an inorder
    //traversal. Assume that each node stores the number of nodes in the subtree rooted at
    //that node.

    public static void main(String[] args) {
        BinaryNodeWithSize root = createBinaryTree2();

        BinaryNodeWithSize iter = root;

        int k=2;

        // time 0(h)
        while(iter!=null)
        {
            // to find kth node in inorder so go through left subtree
            int leftSize = iter.leftSubTreeSize;

            // if leftsize + 1 < k means kth node in right subtree
            if(leftSize+1 < k)
            {
                // do minus from k as we assume we already traveled leftsubtree
                k -= (leftSize + 1);
                iter = iter.right;
            }
            else if(k == (leftSize+1))
            {
                // we found kth node
                break;
            }
            else
            {
                // kth node in leftsub tree
                iter = iter.left;
            }

        }

        System.out.println("kth node is "+iter.data);


    }

    public static BinaryNodeWithSize createBinaryTree2(){

        BinaryNodeWithSize d1 = new BinaryNodeWithSize(9);
        BinaryNodeWithSize d2 = new BinaryNodeWithSize(3);

        BinaryNodeWithSize c1 = new BinaryNodeWithSize(1,d1,null);
        BinaryNodeWithSize c2 = new BinaryNodeWithSize(0,null,d2);
        BinaryNodeWithSize c3 = new BinaryNodeWithSize(7);
        BinaryNodeWithSize c4 = new BinaryNodeWithSize(8);

        BinaryNodeWithSize b1 = new BinaryNodeWithSize(4,c1,c2);
        BinaryNodeWithSize b2 = new BinaryNodeWithSize(2,c3,c4);

        BinaryNodeWithSize root = new BinaryNodeWithSize(5,b1,b2);

        return root;
    }

    static class BinaryNodeWithSize{
        public int data; // value of node
        public int leftSubTreeSize,rightSubTreeSize;
        public BinaryNodeWithSize left,right;

        public BinaryNodeWithSize(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.leftSubTreeSize=0;
            this.rightSubTreeSize=0;

        }

        public BinaryNodeWithSize(int data, BinaryNodeWithSize left, BinaryNodeWithSize right){
            this.data = data;
            this.left = left;
            this.right = right;

            if(left!=null)
            {
                if(left.leftSubTreeSize==0 && left.rightSubTreeSize==0)
                {
                    this.leftSubTreeSize += 1;
                }
                else
                {
                    this.leftSubTreeSize += (left.leftSubTreeSize + left.rightSubTreeSize + 1);
                }
            }

            if(right!=null)
            {
                if(right.leftSubTreeSize==0 && right.rightSubTreeSize==0)
                {
                    this.rightSubTreeSize += 1;
                }
                else
                {
                    this.rightSubTreeSize += (right.leftSubTreeSize + right.rightSubTreeSize + 1);
                }
            }






        }
    }
}
