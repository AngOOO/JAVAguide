package Exercises527;

import java.util.Scanner;

public class FindZero {
    public static void main(String[] args) {
        //输入数字n
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n >= 1 && n <= 1000) {
            //求n!
            double num = fac(n);
            //判断阶乘中末尾0的个数
            int result = hasZero(num);
            System.out.println(result);
        } else {
            return;
        }
    }

    private static double fac(double num) {
        if (num == 1) {
            return 1;
        }
        return num * fac(num - 1);
    }

    private static int hasZero(double num) {
        int count = 0;
        double tmp = num;
        while (tmp % 10 == 0) {
            tmp /= 10;
            count++;
        }
        return count;
    }
}
