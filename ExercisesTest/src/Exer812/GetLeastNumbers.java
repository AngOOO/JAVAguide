package Exer812;

import java.util.ArrayList;
import java.util.Arrays;

public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] ints = new int[]{5,4,6,7,1,3,5,4,4,5,7,8,7,5,};
        ArrayList<Integer> small = GetLeastNumbers_Solution(ints,5);
        System.out.println(small);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> small = new ArrayList<>();
        Arrays.sort(input);
        for(int i = 0;i < k;i++){
            small.add(input[i]);
        }
        return small;
    }
}
