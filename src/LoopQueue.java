public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity+1];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length == front) {
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalAccessError("cannot dequeue from an empty queue");
        }
        E result = data[front];
        front = (front + 1) % data.length;
        size--;
        if(size <= getCapacity()/4) {
            resize(getCapacity()/2);
        }
        return result;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i=0; i<size; i++) {
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue size %d capacity %d : front [", getSize(), getCapacity()));
        for(int i=0; i<getSize(); i++) {
            result.append(data[(i+front)%data.length]);
            if(i != getSize()-1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>(3);
        for(int i=0; i<5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        System.out.println(queue);
    }
}
