package ExerDay13;

import java.math.BigInteger;
import java.util.Scanner;

public class MaxNumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String a = scanner.next();
            String b = scanner.next();
            BigInteger A = new BigInteger(a);
            BigInteger B = new BigInteger(b);
            System.out.println(A.add(B));
        }
    }
}
