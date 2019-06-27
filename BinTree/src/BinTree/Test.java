package BinTree;

import BinTree.Heap.Heap;
import BinTree.SearchTree.SearchTree;

public class Test {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        int[] data = new int[]{4,6,8,42,2,545,57,84,542,90};
        for (int i = 0;i < data.length;i++){
            heap.add(data[i]);
        }
        heap.extractMax();
        System.out.println(heap.toString());
    }
}
