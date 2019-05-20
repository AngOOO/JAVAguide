package StackText.Impl;

import StackText.Stack;

public class LinkStack<T> implements Stack<T> {
    private class Note {
        private T t;
        private Note next;
    }

    private Note head;

    @Override
    public boolean push(T t) {
        Note newNode = new Note();
        if (newNode.next == null) {
            head = newNode;
            newNode.t = t;
        } else {

        }
        return false;
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
