package StackText.Impl;

import StackText.Stack;

import java.util.Arrays;

public class ArrayStack1<T> implements Stack<T> {
    private Object[] arrayStack;
    private int maxSize;
    private int currentSize;

    public ArrayStack1(int maxSize) {
        this.maxSize = maxSize;
        arrayStack = new Object[maxSize];
    }

    @Override
    public boolean push(T t) {
        if (currentSize >= maxSize) {
            int oldSize = maxSize;
            maxSize = oldSize << 1;
            arrayStack = Arrays.copyOf(arrayStack,maxSize);
            if (maxSize - 8 >= Integer.MAX_VALUE){
                System.out.println("超出最大值!");
                return false;
            }
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
