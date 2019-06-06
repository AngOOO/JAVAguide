package BinTree.Heap;


import java.util.Comparator;

public class Heap<E> {
    private int size;
    private Object[] data;
    private Comparator<E> comparator;
    private static final int InitialCapacity = 10;

    public Heap() {
        this(InitialCapacity, null);
    }

    public Heap(int initial) {
        this(initial, null);
    }

    public Heap(int initial, Comparator<E> comparator) {
        this.data = new Object[initial];
    }

    public Comparator<E> compare(E o1, E o2) {

        return null;
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
}
