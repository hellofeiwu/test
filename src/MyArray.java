/**
 * Created by FWU31 on 4/9/2019.
 */
public class MyArray<E> {
    private E[] data;
    private int size;

    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
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

    public boolean exist(E e) {
        for(int i=0; i<data.length; i++) {
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for(int i=0; i<data.length; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is out of bounds");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("index is out of bounds");
        }
        data[index] = e;
    }

    public void addToLast(E e) {
        add(size, e);
    }

    public void addToFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if(size == data.length) {
            // throw new IllegalArgumentException("add failed, the array is full");
            resize(data.length * 2);
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

    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, index is out of bounds");
        }

        E temp = data[index];

        for(int i=index+1; i<size; i++) {
            data[i-1] = data[i];
        }
        size --;
        if(size <= data.length/4 && data.length/2 != 0) {
            resize(data.length/2);
        }
        return temp;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    public boolean removeElement(E e) {
        int index = find(e);
        if(index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0; i<size; i++) {
            newData[i] = data[i];
        }
        data = newData;
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
