package Sort.MergeSort;
//优化点：元素个数少用插入排序
//当分为两个有序数组时，最小的数组最后一个元素比最大的数组第一个元素小，就已经有序，直接合在一起
public class MergeSort {
    public static void mergeSort(int[] data){
        if(data.length <= 1){
            return;
        }
        else{
            mergeResolve(data,0,data.length - 1);
        }
    }
    private static void mergeResolve(int[] data,int low,int high){
        int mid = low + (high - low) / 2;
        if(low >= high){
            return;
        }
        mergeResolve(data,low,mid);
        mergeResolve(data,mid+1,high);
        merge(data,low,mid,high);
    }
    private static void merge(int[] data,int l,int mid,int r){
        int i = l;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[r - l + 1];
        while(i <= mid && j <= r){
            if(data[i] <= data[j]){
                tmp[k++] = data[i++];
            }
            else{
                tmp[k++] = data[j++];
            }
        }
        int start = i;
        int end = mid;
        if(j <= r){
            j = start;
            r = end;
        }
        while(start <= end){
            tmp[k++] = data[start++];
        }
        for(i = 0;i < r - l + 1; i++){
            data[l+i] = tmp[i];
        }
    }
}
