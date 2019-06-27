package HeapSort;

import java.util.Random;

public class HeapTest {
    public static void main(String[] args) {
        int n = 100;
        Random random = new Random();
        int[] data = new int[n];
        for (int i = 0;i < n;i++){
            data[i] = random.nextInt(500);
        }
        HeapSort heapSort = new HeapSort();
        heapSort.HeapSort1(data);
        for (int i = 0;i < data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
}
