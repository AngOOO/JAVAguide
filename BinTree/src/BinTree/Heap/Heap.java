package BinTree.Heap;


import java.util.Arrays;
import java.util.Comparator;

public class Heap<E> {
    private int size;
    private E[] data;
    private Comparator<E> comparator;
    private static final int InitialCapacity = 10;

    public Heap() {
        this(InitialCapacity, null);
    }

    public Heap(int initial) {
        this(initial, null);
    }

    public Heap(int initial, Comparator<E> comparator) {
        this.data = (E[]) new Object[initial];
    }

    public void add(E e) {
        if (size == data.length) {
            grow();
        }
        data[size++] = e;
        siftUp(size - 1);
    }

    public E findMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("数组为空！");
        }
        return data[0];
    }

    public E extractMax() {
        E result = data[0];
        swap(size-1, 0);
        data[--size] = null;
        siftDown(0);
        return result;
    }

    public int compare(E o1, E o2) {
        if (comparator == null) {
            return ((Comparable<E>) o1).compareTo(o2);
        }
        return comparator.compare(o1, o2);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    private void grow() {
        int oldSize = data.length;
        int newSize = oldSize + (oldSize > 64 ? oldSize : oldSize >> 1);
        if (data.length > Integer.MAX_VALUE - 8) {
            throw new IllegalArgumentException("数组太大！");
        }
        data = Arrays.copyOf(data, newSize);
    }

    private void siftUp(int index) {
        while (index > 0 &&
                compare(data[index], data[parent(index)]) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void siftDown(int index) {
        while (leftChild(index) < size) {
            int j = leftChild(index);
            if (j + 1 < size) {
                if (compare(data[j], data[j + 1]) < 0) {
                    j++;
                }
            }
            if (compare(data[index], data[j]) < 0) {
                swap(index, j);
            }
            index = j;
        }
    }

    private void swap(int indexA, int indexB) {
        E tmp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = tmp;
    }
}
