package Sort.SelectiongSort;

public class SelectionSort {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 不稳定(不推荐)
     */
    public static void selectionSort(int[] data){
        if(data.length <= 1){
            return;
        }
        else{
            for(int i = 0;i < data.length;i++){
                int minIndex = i;
                for(int j = i + 1;j < data.length;j++){
                    if(data[j] < data[minIndex]){
                        minIndex = j;
                    }
                }
                int tmp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = tmp;
            }
        }
    }
}
