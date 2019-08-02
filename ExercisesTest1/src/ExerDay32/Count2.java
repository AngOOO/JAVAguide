package ExerDay32;
import java.util.*;

public class Count2 {
    public static void main(String[] args) {
        System.out.println(countNumberOf2s(1000));
    }
    public static int countNumberOf2s(int n) {
        int count = 0;
        for(int i = 0;i < n+1;i++){
            for(int j = i;j > 0;j /= 10){
                if(j%10 == 2){
                    count++;
                }
            }
        }
        return count;
    }
}