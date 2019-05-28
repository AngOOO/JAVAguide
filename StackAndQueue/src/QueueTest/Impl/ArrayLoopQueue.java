package QueueTest.Impl;

import QueueTest.Queue;

public class ArrayLoopQueue<E> implements Queue<E> {
    private int maxSize;
    private Object[] data;

    public ArrayLoopQueue(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize + 1];
    }

    private int size;
    private int head;
    private int tail;

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == head) {
            System.err.println("队列已满!");
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E deQueue() {
        if (tail == head){
            System.err.println("队列为空!");
        }
        E result = (E) data[head];
        head = (head +1) % data.length;
        size--;
        return result;
    }

    @Override
    public E peek() {
        if (head == tail){
            System.err.println("队列为空!");
        }
        return (E) data[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
