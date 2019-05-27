package Exercieses524;

import java.util.Scanner;

public class Candy {
    public static void main(String[] args) {
        //输入四个数字w,x,y,z
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        //(w+y)/2=A;(x+z)/2=B;z-B=C;
        int A = 0;
        A = (w + y) / 2;
        int B = 0;
        B = (x + z) / 2;
        int C = 0;
        C = z - B;
        //三个数字存在输出、不存在输出No
        if (((A != 0) && (B != 0) && (C != 0)) && (A != B) && (A != C) && (B != C)) {
            System.out.println(A + "," + B + "," + C);
        } else {
            System.out.println("No");
        }
    }
}
