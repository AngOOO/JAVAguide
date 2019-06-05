package ExerDay14;

import java.util.Scanner;

public class MinNum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[10];
        for (int i = 0;i < 10;i++){
            num[i] = scanner.nextInt();
        }
        for(int j = 1;j < 10;j++){
            if(num[j] != 0){
                System.out.print(j);
                num[j]--;
            }
        }
        while(num[0] != 0){
            System.out.print(0);
            num[0]--;
        }
        for(int j = 1;j < 10;j++){
            while (num[j] != 0){
                System.out.print(j);
                num[j]--;
            }
        }
    }
}
