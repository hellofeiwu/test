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

    public boolean exist(int e) {
        for(int i=0; i<data.length; i++) {
            if(data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for(int i=0; i<data.length; i++) {
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is out of bounds");
        }
        return data[index];
    }

    public void set(int index, int e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is out of bounds");
        }
        data[index] = e;
    }

    public void addToLast(int e) {
        add(size, e);
    }

    public void addToFirst(int e) {
        add(0, e);
    }

    public void add(int index, int e) {
        if(size == data.length) {
            throw new IllegalArgumentException("add failed, the array is full");
        }

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, index is out of bounds");
        }
        for(int i=size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("The size is %d, and the capacity is %d\n", size, data.length));
        result.append("[");
        for(int i=0; i<size; i++) {
            result.append(data[i]);
            if(i < size-1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }
}
