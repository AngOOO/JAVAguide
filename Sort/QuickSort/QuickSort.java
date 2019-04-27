package Sort.QuickSort;

/*
快排
问题：当代排序元素近乎有序时，若选取得基准值敲好为最大值，
此时分层退化为O（n）,则复杂度退化为O(n^2)
时间复杂度：最好o(nlogn)
          最坏o(n^2)
          平均O(nlogn)
空间复杂度：o（1）
不稳定算法（若基准值为最后一个元素）
 */
public class QuickSort {
    public static void quickSort(int[] data){
        if(data.length <= 1){
            return;
        }
        quickSortInternal(data,0,data.length-1);
    }
    private static void quickSortInternal(int[] data,int l,int r){
        if(l >= r){
            return;
        }
        int q = partition3(data, l, r);//分区函数,取得基准值
        quickSortInternal(data, l, q-1);
        quickSortInternal(data,q+1,r);
    }
    private static int partition(int[] data,int l,int r){
        //优化1：随机选择基准值，较低每次都选到最大或最小值概率
        int randomIndex = (int) (Math.random()*(r-l+1)+l);
        swap(data,l,randomIndex);
        int v = data[l];
        int j = l;
        int i = l+1;
        for(;i <= r;i++){
            if(data[i] < v){
                //交换i与j+1
                swap(data,j+1,i);
                j++;
            }
        }
        swap(data,l,j);
        return j;

        /*int v = data[l];
        int j = l;
        int i = l+1;
        for(;i <= r;i++){
            if(data[i] < v){
                //交换i与j+1
                swap(data,j+1,i);
                j++;
            }
        }
        swap(data,l,j);
        return j;*/
    }
    private static int partition2(int[] data,int l,int r){
        //优化2：当大量重复元素出现时,二路快排。
        //将大于和小于v的元素放在整个数组的两端
        //i++,j--,当data[i]<=v或data[j]>=v,data[i]与data[j]交换
        int randomIndex = (int) (Math.random()*(r-l+1)+l);
        swap(data,l,randomIndex);
        int v = data[l];
        int i = l+1;
        int j = r;
        while(true){
            while (i <= r && data[i] < v){
                i++;
            }
            while (j >= l+1 && data[j] > v){
                j--;
            }
            if(i > j){
                break;
            }
            if(data[i] >= v && data[j] <= v){
                swap(data,i,j);
            }
        }
        swap(data,l,j);
        return j;
    }
    private static int partition3(int[] data,int l,int r){
        //三路快排：多一块等于的区域
        //几乎有序时，效率较高；几乎无序时，效率会降低
        int randomIndex = (int) (Math.random() * (r - l +1) + l);
        swap(data,l,randomIndex);
        int v = data[l];
        int small = l;
        int i = l + 1;
        int big = r + 1;
        while(i < big){
            if(data[i] < v){
                swap(data,small+1,i);
                small++;
                i++;
            }
            else if(data[i] > v){
                swap(data,big-1,i);
                big--;
            }
            else {
                i++;
            }
        }
        swap(data,l,small);
        return small;
    }
    private static void swap(int[] data,int a,int b){
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
