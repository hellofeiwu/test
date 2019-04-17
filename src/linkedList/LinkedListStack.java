package linkedList;

import array.Stack;

public class LinkedListStack<E> implements Stack<E> {
    private MyLinkedList<E> linkedList;
    public LinkedListStack() {
        this.linkedList = new MyLinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addToFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.deleteFirst();
    }

    @Override
    public E peek() {
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
        result.append(String.format("Stack size %d : top [", getSize()));
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
        LinkedListStack linkedListStack = new LinkedListStack();
        for(int i=0; i<5; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack);
    }
}
