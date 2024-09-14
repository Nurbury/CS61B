package synthesizer;
/*
 *@title BoundedQueue
 *@author NorBury
 *@version 1.0
 *@create 2024/9/13 23:23
 *@description
 */

import java.util.Iterator;
public interface BoundedQueue<T> extends Iterable<T> {
//    return size of the buffer
    int capacity();
//    return number of items currently in the buffer
    int fillCount();
//    add item x to the end
    void enqueue(T x);
//    delete and return item from the front
    T dequeue();
//    return ( but do not delete) item from the front
    T peek();

/**
 * default methods
 */
// is the buffer empty (fillcount equals zero)
default boolean isEmpty() {
    if (fillCount() == 0) {
        return true;
    }
    return false;
}

// is the buffer full (fillcount is same as capacity)
default boolean isFull() {
    if (fillCount() == capacity()) {
        return true;
    }
    return false;
}


    @Override
    default Iterator<T> iterator() {
        return null;
    }
}
