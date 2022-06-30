public class BinaryTreeNode<T> {
    public T data; // value of node
    public BinaryTreeNode<T> left,right;

    public BinaryTreeNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T data, BinaryTreeNode left, BinaryTreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
