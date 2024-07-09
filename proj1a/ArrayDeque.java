
/*
 *@title ArrayDeque
 *@author NorBury
 *@version 1.0
 *@create 2024/7/5 22:52
 *@description
 */


public class ArrayDeque<T> {
    // the number of the items in the lists;
    private int size;
    // the pos of the ArrayDeque
    private int nextFirst; // 队尾
    private int nextLast; // 队头
    private T[] lists;


    public ArrayDeque() {
        lists = (T[]) new Object[8];
        size = 0;
        nextFirst = lists.length - 1;
        nextLast = 0;
    }

//    public ArrayDeque(ArrayDeque other) {
//        System.arraycopy(other,0,lists,0,other.size());
//    }

    /**
     * add an item of type T to the front of the Deque
     * @param item
     */
    public void addFirst(T item) {
        if (size == lists.length) {
            resizeFirst(size+1);
        }
       lists[nextFirst] = item;
       size++;
       nextFirst--;
    }

    /**
     * add an item of type T to the back of the Deque
     * @param item
     */
    public void addLast(T item) {
        if (size == lists.length) {
            resizeLast(size+1);
        }
        lists[nextLast] = item;
        size++;
        nextLast++;
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
        for (T list: lists) {
            System.out.printf(list + " ");
        }
        System.out.println();

    }

    /**
     * Removes and returns the item at the front of the Deque, if not no such item exists, return null
     * @return
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T temp = lists[nextFirst];
        lists[nextFirst] = null;
        size--;
        return temp;
    }

    /**
     * Removes and return the item at the back of the Deque, if no such item exists return null;
     * @return
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T temp = lists[nextLast];
        lists[nextLast] = null;
        size--;
        return temp;
    }

    /**
     * Get the item at the given index, where 0 is the front, 1 is the next item, and so forth, if no such item exists, return null, must not alter the Deque;
     * @param index
     * @return
     */
    public T get(int index) {
        if (size <= index) {
            return null;
        }
        return lists[index];
    }

    private void resizeFirst(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(lists,nextLast,a,nextFirst+2,lists.length);
        nextFirst = nextLast;
        lists = a;

    }

    private void resizeLast(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(lists,0,a,0,nextLast);
        nextFirst = lists.length;
        lists = a;
    }
}
