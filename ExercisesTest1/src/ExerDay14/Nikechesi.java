package ExerDay14;

import java.util.Scanner;

public class Nikechesi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int begin = m * (m - 1) + 1;
        System.out.print(begin);
        for (int i = 1; i < m; i++) {
            System.out.print("+" + (begin += 2));
        }
        System.out.println();
    }
}
