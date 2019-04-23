package linkedList;

public class Sum {
    public static int sum(int[] arr) {
        return sum(0, arr);
    }

    private static int sum(int i, int[] arr) {
        if(i == arr.length) {
            return 0;
        }
        if(i > arr.length) {
            throw new IllegalAccessError("i is out of bounds");
        }
        return arr[i] + sum(i+1, arr);
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1,2,3}));
    }
}
