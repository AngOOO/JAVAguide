package BubbleSort;

/**
 * 时间复杂度：O(n) O(n^2)
 * 空间复杂度：O(1)
 * 稳定排序
 */
public class BubbleSort {
    public static void bubbleSort1(int[] data) {
        if (data.length <= 1) {
            return;
        } else {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length - 1 - i; j++) {
                    if (data[j] > data[j + 1]) {
                        int tmp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = tmp;
                    }
                }
            }
        }
    }

    public static void bubbleSort2(int[] data) {
        if (data.length <= 1) {
            return;
        } else {
            for (int i = 0; i < data.length; i++) {
                boolean flag = true;
                for (int j = 0; j < data.length - 1 - i; j++) {
                    if (data[j] > data[j + 1]) {
                        flag = false;
                        int tmp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = tmp;
                    }
                }
                if (flag) {
                    return;
                }
            }
        }
    }
}
