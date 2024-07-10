
/*
 *@title LinkedListDeque
 *@author NorBury
 *@version 1.0
 *@create 2024/7/9 22:23
 *@description
 */


public class LinkedListDeque<T> implements Deque <T>{

    private Node<Integer> sentinel = new Node<>(63);
    private int size;


    private static class Node<T> {
        private Node prev;
        private T item;
        private Node next;

        public Node(T item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public  LinkedListDeque() {
//        sentinel = new Node<>(63);
        size = 0;

    }

    @Override
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

    @Override
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node node = sentinel.next;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node node = sentinel.next;
        T temp = (T) node.item;

        if (node.next == null) {
            sentinel.next = null;
        } else {
            node.next.prev = sentinel;
            sentinel.next = node.next;
        }
        size--;

        return temp;
    }

    @Override
    public T removeFirst() {
        Node node = sentinel;

        if (isEmpty()) {
            return null;
        }

        while (node.next != null) {
            node = node.next;
        }
        T temp = (T) node.item;
        node.prev.next = null;

        size--;
        return temp;
    }

    @Override
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

    @Override
    public T getRecurtive(int index) {
        if (index > size) {
            return null;
        }
        Node node = sentinel.next;
        T temp = getRecursive(node,index);
        return temp;
    }

    private T getRecursive(Node node, int index) {
        while (index != 0) {
            index--;
            node = node.next;
        }

        return (T)node.item;
    }
}
