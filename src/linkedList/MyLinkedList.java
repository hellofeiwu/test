package linkedList;

public class MyLinkedList<E> {
    private Node dummyHead;
    private int size;

    public MyLinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addToIndex(int index, E e) {
        if(index<0 || index>size) {
            throw new IllegalAccessError("index out of bounds");
        }

        Node pre = dummyHead;
        for(int i=0; i<index; i++) {
            pre = pre.next;
        }

        Node node = new Node(e, pre.next);
        pre.next = node;
        size++;
    }

    public void addToFirst(E e) {
        addToIndex(0, e);
    }

    public void addToLast(E e) {
        addToIndex(size, e);
    }

    public E delete(int index) {
        if(index<0 || index>size) {
            throw new IllegalAccessError("index out of bounds");
        }
        Node pre = dummyHead;
        for(int i=0; i<index; i++) {
            pre = pre.next;
        }
        Node result = pre.next;
        pre.next = result.next;
        result.next = null; // for JVM to clean this memory space
        size--;

        return (E)result.getE();
    }

    public E get(int index) {
        if(index<0 || index>size) {
            throw new IllegalAccessError("index out of bounds");
        }

        Node<E> cur = dummyHead.next;
        for(int i=0; i<index; i++) {
            cur = cur.next;
        }

        return cur.getE();
    }

    public void set(int index, E e) {
        if(index<0 || index>size) {
            throw new IllegalAccessError("index out of bounds");
        }

        Node cur = dummyHead.next;
        for(int i=0; i<index; i++) {
            cur = cur.next;
        }
        cur.setE(e);
    }

    public boolean exist(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur.getE().equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("LinkedList size is %d : ", size));
        Node cur = dummyHead.next;
        for(int i=0; i<size; i++) {
            result.append(cur);
            if(i != size-1) {
                result.append("->");
            }
            cur = cur.next;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for(int i=0; i<5; i++) {
            myLinkedList.addToLast(i);
        }
        System.out.println(myLinkedList);
        myLinkedList.addToIndex(2, 9);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(4));
        myLinkedList.set(3, 12);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.exist(3));

        System.out.println(myLinkedList.delete(2));
        System.out.println(myLinkedList);
    }
}
