import java.util.ArrayList;

/**
 * Created by FWU31 on 2/26/2019.
 */
public class Main {
    public static void main(String[] args) {
//        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        Integer[] arr = {10};
//        for(Integer i : arr) {
//            binarySearchTree.add(i);
//        }
//
//        //binarySearchTree.preTraverse(binarySearchTree.getRoot());
//        //System.out.println(binarySearchTree.exist(5));
//        //binarySearchTree.minimum(binarySearchTree.getRoot());
//        //binarySearchTree.maximum(binarySearchTree.getRoot());
//        //binarySearchTree.removeMinNode(binarySearchTree.getRoot());
//        binarySearchTree.removeMaxNode(binarySearchTree.getRoot());
//        binarySearchTree.preTraverse(binarySearchTree.getRoot());
        //TreeNode tree = binarySearchTree.removeNode(binarySearchTree.getRoot(), 23);
        //binarySearchTree.preTraverse(tree);
//        ArrayList arrayList = new ArrayList<>();
//        arr = new int[5];
//        arr[0] = 10;
//        insertElementIntoArray(arr, 1, 2);
        Stack stack = new ArrayStack(20);
        for(int i=0; i<5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    public static String insertElementIntoArray(int[] arr, int j, int e) {
//        if(arr.length == arr.) {
//
//        }
        if(j<1 || j>arr.length) {
            return "error";
        }
        for(int i=j-1; i<arr.length-1; i++) {
            arr[i+1] = arr[i];
        }
        arr[j-1] = e;
        for(int i=0; i<arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        return "ok";
    }
}
