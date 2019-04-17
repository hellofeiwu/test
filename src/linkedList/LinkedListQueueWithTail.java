package linkedList;

import array.ArrayQueue;
import array.LoopQueue;
import array.Queue;

public class LinkedListQueueWithTail<E> implements Queue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueueWithTail() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null) {
            tail = new Node<>(e);
            head = tail;
        }else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalAccessError("dequeue failed, because queue is empty");
        }
        Node<E> result = head;
        head = head.next;
        result.next = null;
        return result.getE();
    }

    @Override
    public E getFront() {
        return head.getE();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue size %d : front [", getSize()));
        for(Node i=head; i!=null; i=i.next) {
            result.append(i);
            if(i.next != null) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        LinkedListQueueWithTail<Integer> linkedListQueue = new LinkedListQueueWithTail<>();
        for(int i=0; i<5; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue);

        System.out.println(LoopQueue.queueTest(new ArrayQueue<>(), 100000));
        System.out.println(LoopQueue.queueTest(new LoopQueue<>(), 100000));
        System.out.println(LoopQueue.queueTest(new LinkedListQueue<>(), 100000));
        System.out.println(LoopQueue.queueTest(new LinkedListQueueWithTail<>(), 100000));
    }
}
