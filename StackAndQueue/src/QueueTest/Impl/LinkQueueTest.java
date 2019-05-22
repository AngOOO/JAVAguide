package QueueTest.Impl;

import QueueTest.Queue;

public class LinkQueueTest<E> implements Queue<E> {
    private class Note {
        private E data;
        private Note next;

        public Note(E data, Note next) {
            this.data = data;
            this.next = next;
        }
    }

    private Note head;
    private Note tail;
    private int size;

    @Override
    public void enQueue(E e) {
        Note newNote = new Note(e, null);
        if (head == null) {
            head = tail = newNote;
        }
        tail.next = newNote;
        tail = newNote;
        size++;
    }

    @Override
    public E deQueue() {
        if (head == null) {
            System.err.println("当前队列为空！");
            return null;
        }
        E tmp = head.data;
        head = head.next;
        size--;
        return tmp;
    }

    @Override
    public E peek() {
        if (head == null) {
            System.err.println("当前队列为空！");
            return null;
        }
        return head.data;
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
