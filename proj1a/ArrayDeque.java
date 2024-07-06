
/*
 *@title ArrayDeque
 *@author NorBury
 *@version 1.0
 *@create 2024/7/5 22:52
 *@description
 */


public class ArrayDeque<T> {
    private int size;
    private T[] lists;


    public ArrayDeque() {
        lists = (T[]) new Object[8];
        size = 8;
    }

    public ArrayDeque(ArrayDeque other) {
        System.arraycopy(other, 0, lists,8,other.size());
    }

    /**
     * add an item of type T to the front of the Deque
     * @param item
     */
    public void addFirst(T item) {
       lists[size] = item;
       size++;
    }

    /**
     * add an item of type T to the back of the Deque
     * @param item
     */
    public void addLast(T item) {
        lists[7] = item;
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
        T temp = lists[0];
        lists[0] = null;
        return temp;
    }

    /**
     * Removes and return the item at the back of the Deque, if no such item exists return null;
     * @return
     */
    public T removeLast() {
        T temp = lists[size - 1];
        lists[size - 1] = null;
        return temp;
    }

    /**
     * Get the item at the given index, where 0 is the front, 1 is the next item, and so forth, if no such item exists, return null, must not alter the Deque;
     * @param index
     * @return
     */
    public T get(int index) {
        return lists[index];
    }
}
