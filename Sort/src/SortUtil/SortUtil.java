package SortUtil;

import java.util.Random;

public class SortUtil {
    public static int[] makeRandom(int scope){
        int n = 50;
        Random random = new Random();
        int data[] = new int[n];
        for (int i = 0;i < n;i++){
            data[i] = random.nextInt(scope);
        }
        return data;
    }
    public static void printData(int[] data){
        for (int i = 0;i < data.length;i++){
            System.out.print(data[i]+"、");
        }
    }
}
