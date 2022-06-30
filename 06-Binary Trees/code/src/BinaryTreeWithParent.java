public class BinaryTreeWithParent<T> {
    BinaryTreeWithParent<T> left,right,parent;
    T data;

    public BinaryTreeWithParent(T data)
    {
        this.data = data;
    }

    public BinaryTreeWithParent(T data, BinaryTreeWithParent<T> left, BinaryTreeWithParent<T> right){
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
