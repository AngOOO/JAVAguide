package Exerciese525;

import java.util.Scanner;

public class LastCommonMultiple {
    public static void main(String[] args) {
        //输入两个数字
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        //找出两个数字的最大公因数
        int max = 0;
        int num = a;
        if (a < b) {
            num = b;
        }
        for (int i = 1; i <= num; i++) {
            while (a % i == 0 && b % i == 0) {
                max = i;
                break;
            }
        }
        //因为两数的最大公因数与最小公倍数的乘积等于两数的乘积
        //最小公倍数=两数乘积/最大公因数
        int min = (a * b) / max;
        System.out.println(min);
    }
}
