public class ArrayStack<E> implements Stack<E> {
    private MyArray<E> array;

    public ArrayStack(int capacity) {
        array = new MyArray<>(capacity);
    }

    public ArrayStack() {
        array = new MyArray<>();
    }

    @Override
    public void push(E e) {
        array.addToLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(array.getSize()-1);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.getSize() == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Stack size %d capacity %d : [", getSize(), getCapacity()));
        for(int i=0; i<getSize(); i++) {
            result.append(array.get(i));
            if(i != getSize()-1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }
}
