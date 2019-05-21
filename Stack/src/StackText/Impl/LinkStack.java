package StackText.Impl;

import StackText.Stack;

public class LinkStack<T> implements Stack<T> {
    private class Note {
        private T t;
        private Note next;

        public Note(T t, Note next) {
            this.t = t;
            this.next = next;
        }

        public T getT() {
            return t;
        }
    }

    private Note head;

    @Override
    public boolean push(T t) {
        Note newNode = new Note(t, null);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head.next;
            head.next = newNode;
        }
        return true;
    }

    @Override
    public T pop() {
        if (head == null) {
            return null;
        } else {
            head = head.next;
        }
        return head.t;
    }

    @Override
    public T peek() {
        if (head == null){
            return null;
        }
        return head.next.t;
    }

    @Override
    public int getSize() {
        if (head == null){
            return 0;
        }
        int count = 1;
        for (Note note = head; note != null; note = note.next) {
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
