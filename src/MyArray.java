/**
 * Created by FWU31 on 4/9/2019.
 */
public class MyArray {
    private int[] data;
    private int size;

    public MyArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public MyArray() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addToLast(int e) {
        if(size == data.length) {
            throw new IllegalArgumentException("addToLast failed, the array is full");
        }
        data[size] = e;
        size++;
    }
}
