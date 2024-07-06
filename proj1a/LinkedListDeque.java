
/*
 *@title LinkedListDeque
 *@author NorBury
 *@version 1.0
 *@create 2024/7/3 19:06
 *@description
 */



public class LinkedListDeque<T> {
    private Node<Integer> sentinel = new Node<>(63);
    private int size;


    private static class Node<T> {
        public Node prev;
        public T item;
        public Node next;

        public Node(T item) {
            this.item = item;
            prev = null;
            next = null;
        }
    }

    public  LinkedListDeque(){
//        sentinel = new Node<>(63);
        size = 0;

    }

    /**
     * add an item of type T to the front of the Deque
     * @param item
     */
    public void addFirst(T item) {
        Node<Integer> node = sentinel;
        Node<T> p = new Node<T>(item);

        if (node.next != null) {
            node.next.prev = p;
            p.next = node.next;
        }

        node.next = p;
        p.prev = node;
        size += 1;
    }

    /**
     * add an item of type T to the back of the Deque
     * @param item
     */
    public void addLast(T item) {
        Node node = sentinel;
        while (node.next != null) {
            node = node.next;
        }
        Node<T> p = new Node(item);
        node.next = p;
        p.next = null;
        p.prev = node;
        size++;
    }

    /**
     * return true if Deque is empty, false otherwise;
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the number of items in the Deque;
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * prints the items in the Deque from first to last, separated by a space
     */
    public void printDeque() {
        Node node = sentinel.next;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the Deque, if not no such item exists, return null
     * @return
     */
    public T removeFirst() {
//        if the Deque is empty return null;
        if (isEmpty()) {
            return null;
        }

        Node node = sentinel.next;
        T temp = (T)node.item;

        if (node.next == null) {
            sentinel.next = null;
        } else {
            node.next.prev = sentinel;
            sentinel.next = node.next;
        }
        size--;

        return temp;
    }

    /**
     * Removes and return the item at the back of the Deque, if no such item exists return null;
     * @return
     */
    public T removeLast() {
        Node node = sentinel;

        if (isEmpty()) {
            return null;
        }

        while (node.next != null) {
            node = node.next;
        }
        T temp = (T)node.item;
        node.prev.next = null;

        size--;
        return temp;
    }

    /**
     * Get the item at the given index, where 0 is the front, 1 is the next item, and so forth, if no such item exists, return null, must not alter the Deque;
     * @param index
     * @return
     */
    public T get(int index) {
        if (index > size) {
            return null;
        }

        Node node = sentinel;
        for (int i = ++index;i > 0; i--) {
            node = node.next;
        }
        T temp = (T) node.item;

        return temp;
    }

    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }

        Node node = sentinel;
        for (int i = ++index;i > 0; i--) {
            node = node.next;
        }
        T temp = (T) node.item;

        return temp;
    }

}
