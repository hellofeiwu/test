package linkedList;

public class LinkedList<E> {

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addToFirst(E e) {
        Node node = new Node(e, head);
        head = node;
        size++;
    }

    public void addToIndex(int index, E e) {
        if(index<0 || index>size) {
            throw new IllegalAccessError("index out of bounds");
        }

        if(index == 0) {
            addToFirst(e);
        }else {
            Node pre = head;
            for(int i=0; i<index-1; i++) {
                pre = pre.next;
            }

            Node node = new Node(e, pre.next);
            pre.next = node;
            size++;
        }
    }

    public void addToLast(E e) {
        addToIndex(size, e);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("LinkedList size is %d : ", size));
        Node node = head;
        result.append(head);
        if(size != 1) {
            result.append("->");
        }
        for(int i=1; i<size; i++) {
            node = node.next;
            result.append(node);
            if(i!=size-1) {
                result.append("->");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0; i<5; i++) {
            linkedList.addToLast(i);
        }
        System.out.println(linkedList);
        linkedList.addToIndex(2, 9);
        System.out.println(linkedList);
    }
}
