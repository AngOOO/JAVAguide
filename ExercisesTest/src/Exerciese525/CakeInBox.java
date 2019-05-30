package Exerciese525;

import java.util.Scanner;

public class CakeInBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int count = 0;
        if ((H * W) % 4 == 0) {
            if (H % 4 == 0 || W % 4 == 0) {
                count = H * W / 2;
            } else if (H % 2 == 0 || W % 2 == 0) {
                count = H * W / 2 + 2;
            }
        } else {
            count = H * W / 2 + 1;
        }
        System.out.println(count);
    }
}
