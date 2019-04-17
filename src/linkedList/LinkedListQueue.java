package linkedList;

import array.Queue;

public class LinkedListQueue<E> implements Queue<E> {
    private MyLinkedList<E> linkedList;

    public LinkedListQueue() {
        linkedList = new MyLinkedList<>();
    }

    @Override
    public void enqueue(E e) {
        linkedList.addToLast(e);
    }

    @Override
    public E dequeue() {
        return linkedList.deleteFirst();
    }

    @Override
    public E getFront() {
        return linkedList.get(0);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue size %d : front [", getSize()));
        for(int i=0; i<getSize(); i++) {
            result.append(linkedList.get(i));
            if(i != getSize()-1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for(int i=0; i<5; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue);
    }
}
