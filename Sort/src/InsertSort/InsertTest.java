package InsertSort;

import SortUtil.SortUtil;

public class InsertTest {
    public static void main(String[] args) {
        int[] data = SortUtil.makeRandom(500);
        InsertSort.ShellSort(data);
        SortUtil.printData(data);
    }
}
