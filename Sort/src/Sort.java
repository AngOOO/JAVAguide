public class Sort {
    public static void main(String[] args) {

    }

    public static void bubble(int[] data) {
        if (data.length <= 1) {
            return;
        } else {
            for (int i = 0; i < data.length; i++) {
                boolean flag = true;
                for (int j = 0; j < data.length - i - 1; j++) {
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

    public static void quick(int[] data) {
        if (data.length <= 1) return;
        quickInternal(data, 0, data.length - 1);
    }

    private static void quickInternal(int[] data, int r, int l) {
        if (l >= r) return;
        int q = partition(data, l, r);
        quickInternal(data, l, q - 1);
        quickInternal(data, q + 1, r);
    }

    private static int partition(int[] data, int l, int r) {
        int randomIndex = (int) (Math.random() * (r - l + 1) + 1);
        swap(data, l, randomIndex);
        int val = data[l];
        int small = l;
        int i = l + 1;
        int big = r + 1;
        while (i < big) {
            if (data[i] < val) {
                swap(data, i, small + 1);
                i++;
                small++;
            } else if (data[i] > val) {
                swap(data, i, big - 1);
                big--;
            } else {
                i++;
            }
        }
        swap(data, small, l);
        return small;
    }

    private static void swap(int[] data, int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    public static void insert(int[] data) {
        if (data.length <= 1) return;
        else {
            for (int i = 1; i < data.length; i++) {
                int val = data[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (data[j] > val) {
                        data[j + 1] = data[j];
                    } else break;
                }
                data[j + 1] = val;
            }
        }
    }
    public static void selection(int[] data){
        if (data.length>=1)return;
        else {
            for (int i = 0;i < data.length;i++){
                int minIndex = i;
                for (int j = i+1;j < data.length;j++){
                    if (data[j] < data[minIndex]){
                        minIndex = j;
                    }
                    swap(data,i,minIndex);
                }
            }
        }
    }
}
