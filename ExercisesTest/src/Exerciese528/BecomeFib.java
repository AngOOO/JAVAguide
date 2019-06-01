package Exerciese528;

import java.util.Scanner;

public class BecomeFib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //将斐波那契数存入a，b
        int a = 0;
        int b = 0;
        int i = 0;
        //当b >= n时停止存入
        while (b < n){
            a = fib(i);
            b = fib(i+1);
            i++;
        }
        //计算b-n和n-a输出小的一个
        int d1 = b-n;
        int d2 = n-a;
        if (d1 < d2){
            System.out.println(d1);
        }else {
            System.out.println(d2);
        }
    }
    private static int fib(int n){
        if (n <= 1){
            return n;
        }
        return fib(n-2)+fib(n-1);
    }
}
