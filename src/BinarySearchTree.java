/**
 * Created by FWU31 on 2/26/2019.
 */
public class BinarySearchTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void add(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        root = add(root, value);
    }

    private TreeNode add(TreeNode<Integer> node, int value) {

        if (node == null) {
            node = new TreeNode<>(value);
        }

        if (node.getValue() > value) {
            node.setLeft(add(node.getLeft(), value));
        }
        if (node.getValue() < value) {
            node.setRight(add(node.getRight(), value));
        }
        return node;
    }

    public void preTraverse(TreeNode node) {
        if (node == null) {
            return;
        }else {
            System.out.println(node.getValue());
            preTraverse(node.getLeft());
            preTraverse(node.getRight());
        }
    }

    public TreeNode minimum(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() != null) {
            return minimum(node.getLeft());
        }else {
            return node;
        }
    }

    public TreeNode maximum(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.getRight() != null) {
            return maximum(node.getRight());
        }else {
            return node;
        }
    }

    public TreeNode removeMinNode(TreeNode node) {
        if(node == null) {
            return null;
        }

        if(node.getLeft() != null) {
            node.setLeft(removeMinNode(node.getLeft()));
        }else {
            TreeNode right = node.getRight();
            node.setRight(null);
            return right;
        }

        return node;
    }

    public TreeNode removeMaxNode(TreeNode node) {
        if(node == null) {
            return null;
        }
        if(node.getRight() != null) {
            node.setRight(removeMaxNode(node.getRight()));
        }else {
            TreeNode left = node.getLeft();
            node.setLeft(null);
            return left;
        }
        return node;
    }

    public TreeNode removeNode(TreeNode<Integer> node, int value) {
        if(node == null) {
            return null;
        }

        if(node.getValue() > value) {
            node.setLeft(removeNode(node.getLeft(), value));
        }else if(node.getValue() < value) {
            node.setRight(removeNode(node.getRight(), value));
        }else {
            if(node.getLeft() == null && node.getRight() != null) {
                node = node.getRight();

            }

            if(node.getRight() == null && node.getLeft() != null) {
                node = node.getLeft();
            }

            if (node.getLeft() != null && node.getRight() != null) {
                TreeNode replacement = removeMaxNode(node.getLeft());
                node.setValue((Integer) replacement.getValue());
            }

            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            }
        }

        return node;
    }
}


