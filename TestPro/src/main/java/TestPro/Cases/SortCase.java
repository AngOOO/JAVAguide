package TestPro.Cases;

import TestPro.Case;
import TestPro.annotation.Benchmark;
import TestPro.annotation.Measurement;

import java.util.Arrays;
import java.util.Random;

/**
 * 1，快速排序和归并排序
 * 2，自己实现的归并排序和Arrays.sort对比
 */
@Measurement(iterations = 10,group = 3)
public class SortCase implements Case {
    //快速排序
    public void quickSort(int[] data){
        if(data.length <= 1){
            return;
        }
        quickSortInternal(data,0,data.length-1);
    }
    private void quickSortInternal(int[] data,int l,int r){
        if(l >= r){
            return;
        }
        int q = partition(data, l, r);//分区函数,取得基准值
        quickSortInternal(data, l, q-1);
        quickSortInternal(data,q+1,r);
    }
    private int partition(int[] data,int l,int r){
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
    }
    private void swap(int[] data,int a,int b){
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
    //归并排序
    public void mergeSort(int[] data){
        if(data.length <= 1){
            return;
        }
        else{
            mergeResolve(data,0,data.length - 1);
        }
    }
    private void mergeResolve(int[] data,int low,int high){
        int mid = low + (high - low) / 2;
        if(low >= high){
            return;
        }
        mergeResolve(data,low,mid);
        mergeResolve(data,mid+1,high);
        merge(data,low,mid,high);
    }
    private void merge(int[] data,int l,int mid,int r){
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
    @Benchmark
    public void testQuickSort(){
        int[] a = new int[100000];
        Random random = new Random(20190713);
        for (int i = 0;i < a.length;i++){
            a[i] = random.nextInt(100000);
        }
        mergeSort(a);
    }
    @Benchmark
    public void ArraysSort(){
        int[] a = new int[100000];
        Random random = new Random(20190713);
        for (int i = 0;i < a.length;i++){
            a[i] = random.nextInt(100000);
        }
        Arrays.sort(a);
    }
}
