package array;

public class ArrayQueue<E> implements Queue<E> {
    private MyArray<E> array;

    public ArrayQueue(int capacity) {
        array = new MyArray<>(capacity);
    }

    public ArrayQueue() {
        array = new MyArray<>();
    }

    @Override
    public void enqueue(E e) {
        array.addToLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
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
        return getSize() == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue size %d capacity %d : front [", getSize(), getCapacity()));
        for(int i=0; i<getSize(); i++) {
            result.append(array.get(i));
            if(i != getSize()-1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>(20);
        for(int i=0; i<5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue);
    }
}
