package synthesizer;
/*
 *@title AbstractBoundedQueue
 *@author NorBury
 *@version 1.0
 *@create 2024/9/14 10:45
 *@description
 */


public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{
// the number of items currently in the buffer
    protected int fillCount;
//    size of the buffer
    protected int capacity;
    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    public abstract void enqueue(T x);


    public abstract T dequeue();

    public abstract T peek();


    public boolean isEmpty() {
        return BoundedQueue.super.isEmpty();
    }

    @Override
    public boolean isFull() {
        return BoundedQueue.super.isFull();
    }
}
