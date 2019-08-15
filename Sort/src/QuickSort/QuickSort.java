package QuickSort;

public class QuickSort {
    public static void quickSort1(int[] data) {
        if (data.length <= 0)
            return;
        quickInternal1(data, 0, data.length - 1);
    }

    private static void quickInternal1(int[] data, int l, int r) {
        if (l >= r) return;
        int q = partition2(data, l, r);
        quickInternal1(data, l, q - 1);
        quickInternal1(data, q + 1, r);
    }

    private static int partition1(int[] data, int l, int r) {
        /*int val = data[l];
        int j = l;
        int i = l+1;
        for (;i<=r;i++){
            if (data[i] < val){
                swap(data,j+1,i);
                j++;
            }
        }
        swap(data,j,l);
        return j;*/
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(data, l, randomIndex);
        int val = data[l];
        int j = l;
        int i = l + 1;
        for (; i <= r; i++) {
            if (data[i] < val) {
                swap(data, i, j + 1);
                j++;
            }
        }
        swap(data, j, l);
        return j;
    }

    private static int partition2(int[] data, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        swap(data,l,randomIndex);
        int val = data[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && data[i] < val) {
                i++;
            }
            while (j >= l + 1 && data[j] > val) {
                j--;
            }
            if (i > j) {
                break;
            }
            if (data[i] >= val && data[j] <= val) {
                swap(data, i, j);
            }
        }
        swap(data, l, j);
        return j;
    }

    private static void swap(int[] data, int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
