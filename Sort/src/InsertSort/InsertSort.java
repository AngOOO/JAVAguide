package InsertSort;

/**
 * 时间复杂度：O(n) O(n^2)
 * 空间复杂度：O(1)
 * 稳定排序
 */
public class InsertSort {
    public static void insertSort(int[] data) {
        if (data.length <= 1) {
            return;
        } else {
            for (int i = 1; i < data.length; i++) {
                int val = data[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (data[j] > val) {
                        data[j + 1] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + 1] = val;
            }
        }
    }

    public static void binaryInsertSort(int[] data) {
        if (data.length <= 1) {
            return;
        } else {
            for (int i = 1; i < data.length; i++) {
                int val = data[i];
                int low = 0;
                int high = i - 1;
                int j = i - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (val < data[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                for (; j >= high + 1; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = val;
            }
        }
    }

    public static void ShellSort(int[] data) {
        if (data.length <= 1) {
            return;
        } else {
            int step = data.length / 2;
            while (step >= 1) {
                for (int i = 1; i < data.length; i++) {
                    int val = data[i];
                    int j = i - step;
                    for (; j >= 0; j -= step) {
                        if (val < data[j]) {
                            data[j + 1] = data[j];
                        } else {
                            break;
                        }
                    }
                    data[j + step] = val;
                }
                step = step / 2;
            }
        }
    }
}
