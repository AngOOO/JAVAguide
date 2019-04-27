package Sort.BubbleSort;

public class BubbleSort {
    /**
     * 时间复杂度：最好O(n)
     *           最坏、平均：O（n^2）
     * 空间复杂度：原地排序O（1）
     * 稳定排序
     */
    public static void bubbleSort1(int[] data){
        if(data.length <= 1){
            return;
        }else{
            for(int i = 0;i < data.length;i++){
                for(int j = 0;j < data.length - i - 1;j++){
                    if(data[j] > data[j+1]){
                        int tmp = data[j];
                        data[j] = data[j+1];
                        data[j+1] = tmp;
                    }
                }
            }
        }
    }
    //优化：设置标志位，若在某次循环结束后发现没有元素进行交换，认为已经有序
    public static void bubbleSort2(int[] data){
        if(data.length <= 1){
            return;
        }else{
            for(int i = 0;i < data.length;i++) {
                boolean flag = true;
                for (int j = 0; j < data.length - i - 1; j++) {
                    if (data[j] > data[j + 1]) {
                        flag = false;
                        int tmp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = tmp;
                    }
                }
                if(flag == true){
                    System.out.println("已经有序！");
                    return;
                }
            }
        }
    }
}
