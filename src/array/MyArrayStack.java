package array;

import array.MyArray;

public class MyArrayStack<E> extends MyArray<E> {

    public MyArrayStack(int capacity) {
        super(capacity);
    }

    public MyArrayStack() {
        super();
    }

    public void push(E e) {
        addToLast(e);
    }

    public E pop() {
        return removeLast();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Stack size %d capacity %d : [", getSize(), getCapacity()));
        for(int i=0; i<getSize(); i++) {
            result.append(get(i));
            if(i != getSize()-1) {
                result.append(",");
            }
        }
        result.append("]top");
        return result.toString();
    }
}
