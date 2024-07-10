
/*
 *@title Deque
 *@author NorBury
 *@version 1.0
 *@create 2024/7/9 22:20
 *@description
 */


public interface Deque<T> {
    public boolean isEmpty();

    public void addFirst(T item);

    public void addLast(T item);

    public int size();

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);

    public T getRecurtive(int index);







}
