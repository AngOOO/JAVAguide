package SelectionSort;

import SortUtil.SortUtil;

public class SelectionTest {
    public static void main(String[] args) {
        int[] data = SortUtil.makeRandom(500);
        SelectionSort.selectionSort(data);
        SortUtil.printData(data);
    }
}
