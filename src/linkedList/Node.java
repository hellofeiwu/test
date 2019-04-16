package linkedList;

public class Node<E> {
    private E e;
    public Node next;

    public Node(E e, Node next) {
        this.e = e;
        this.next = next;
    }

    public Node(E e) {
        this.e = e;
        this.next = null;
    }

    public Node() {
        this.e = null;
        this.next = null;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return e.toString();
    }
}