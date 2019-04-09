/**
 * Created by FWU31 on 2/26/2019.
 */
public class TreeNode<E> {
    private E value;
    private TreeNode left = null;
    private TreeNode right = null;

    public TreeNode(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
