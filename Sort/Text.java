package Sort;

import Sort.BubbleSort.BubbleSort;
import Sort.InsertSort.InsertSort;
import Sort.MergeSort.MergeSort;
import Sort.QuickSort.QuickSort;
import Sort.SelectiongSort.SelectionSort;

public class Text {
    public static void main(String[] args){
        int[] data = new int[]{7,8,9,1,2,3};
        SelectionSort.selectionSort(data);
        SortKit.Print(data);
    }
}
