package QueueTest.Impl;

import QueueTest.Queue;

public class ArrayQueueTest<E> implements Queue<E> {
    private Object[] data;
    private int head;
    private int tail;

    public ArrayQueueTest(int maxSize) {
        data = new Object[maxSize];
    }

    @Override
    public void enQueue(E e) {
        if (tail == data.length) {
            System.err.println("当前队列已满！");
        }
        data[tail++] = e;
    }

    @Override
    public E deQueue() {
        if (head == tail) {
            System.err.println("当前队列为空！");
            return null;
        }
        return (E) data[head--];
    }

    @Override
    public E peek() {
        if (head == tail) {
            System.err.println("当前队列为空！");
            return null;
        }
        return (E) data[head];
    }

    @Override
    public int getSize() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
