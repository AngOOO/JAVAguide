package BinTree.Heap;

import java.util.Random;

public class HeapTest {
    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();
        Heap<Integer> heap = new Heap<>(n);
        for (int i = 0;i < n;i++){
            heap.add(random.nextInt(50));
        }
        int[] num = new int[n];
        for (int i = heap.getSize()-1;i >=0;i--){
            num[i] = heap.extractMax();
        }
        for (int i:num) {
            System.out.print(i+"、");
        }
    }
}
