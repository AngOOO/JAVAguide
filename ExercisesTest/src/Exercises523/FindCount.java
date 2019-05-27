package Exercises523;

import java.util.Scanner;

public class FindCount {
    static int[] num = null;
    static int n = 0;
    static int count = 0;

    public static void main(String[] args) {
        //输入n为数组容量
        //分别将物品重量放入数组
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        num = new int[n+1];
        for (int i = 1; i <= n; i++) {
            num[i] = scanner.nextInt();
        }
        //计算成功次数
        count(40, n);
        System.out.println(count);
    }

    private static void count(int capacity, int n) {
        if (capacity == 0) {//恰好所取物品重量和等于40
            ++count;
            return;
        }
        if (capacity < 0 || (capacity > 0 && n < 1)) {
            //剩余物品为负数或个数小于一个不满足情况
            return;
        }
        count(capacity - num[n], n - 1);
        count(capacity, n - 1);
    }
}
