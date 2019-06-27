package HeapSort;

/**
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
public class HeapSort {
    public void HeapSort1(int[] data){
        Heap<Integer> heap = new Heap<Integer>();
        for (int i = 0;i < data.length;i++){
            heap.add(data[i]);
        }
        for (int i = data.length-1;i >= 0;i--){
            data[i] = heap.extractMax();
        }
    }
    public void HeapSort2(int[] data){
        int length = data.length;
        //将数组变为堆
        for (int i = (length-1 - 1)/2;i >= 0;i--){
            siftDown(data,i,length);
        }
        //将最大元素依次取出放入数组最后
        for (int i = length - 1;i >= 0;i--){
            swap(data,0,i);
            siftDown(data,0,i);
        }
    }
    private static void swap(int[] data,int indexA,int indexB){
        int tmp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = tmp;
    }
    private static void siftDown(int[] data,int index,int length){
        while (index*2+1 < length){
            int j = index*2+1;
            if (j+1 < length){
                if (data[j] < data[j+1]){
                    j++;
                }
            }
            if (data[j] > data[index]){
                swap(data,j,index);
            }
            index = j;
        }
    }
}
