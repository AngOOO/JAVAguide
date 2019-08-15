package QuickSort;
import SortUtil.SortUtil;

public class QuickTest {
    public static void main(String[] args) {
        int[] data = SortUtil.makeRandom(500);
        QuickSort.quickSort1(data);
        SortUtil.printData(data);
    }
}
