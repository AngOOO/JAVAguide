package Exerciese526;

import java.util.Scanner;

public class RemoveTwo {
    public static void main(String[] args) {
        //输入一个数字n
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 1000) {
            n = 999;
        }
        //创建一个大小为n的数组
        int[] data = new int[n];
        int index = 0;
        int flag = 0;
        //遍历数组，设置flag计数，当元素为0时，flag+1，当flag=2时将元素赋值为-1
        while (DataSum(data) != -n) {//最后一个元素被赋值为-1
            if (-1 == data[index]) {
                index = (index + 1) % data.length;
            } else {
                if (2 == flag) {
                    data[index] = -1;
                    flag = 0;
                } else {
                    flag++;
                }
                index = (index + 1) % data.length;
            }
        }
        System.out.println(index - 1);
    }

    public static int DataSum(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }
}
