package StackText.Impl;

import StackText.Stack;

public class ArrayStack<T> implements Stack<T> {
    private Object[] arrayStack;
    private int maxSize;
    private int currentSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arrayStack = new Object[maxSize];
    }

    @Override
    public boolean push(T t) {
        if (currentSize >= maxSize) {
            System.out.println("当前栈已满！");
            return false;
        }
        arrayStack[currentSize++] = t;
        return true;
    }

    @Override
    public T pop() {
        if (currentSize == 0) {
            System.out.println("当前栈为空！");
            return null;
        }
        return (T) arrayStack[--currentSize];
    }

    @Override
    public T peek() {
        if (currentSize == 0) {
            System.out.println("当前栈为空！");
            return null;
        }
        return (T) arrayStack[currentSize - 1];
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}
