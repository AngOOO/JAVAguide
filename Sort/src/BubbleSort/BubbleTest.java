package BubbleSort;


import SortUtil.SortUtil;

public class BubbleTest {
    public static void main(String[] args) {
        int[] data = SortUtil.makeRandom(100);
        BubbleSort.bubbleSort2(data);
        SortUtil.printData(data);
    }
}
