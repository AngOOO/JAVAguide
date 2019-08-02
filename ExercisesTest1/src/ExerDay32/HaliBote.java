package ExerDay32;

import java.util.Scanner;

public class HaliBote {
    public static void main(String[] args) {
        //1.17.17*29
        //17*29.29.1
        Scanner in = new Scanner(System.in);
        String[] p = in.next().split("\\.");
        String[] a = in.next().split("\\.");
        int tp = Integer.parseInt(p[0])*17*29+Integer.parseInt(p[1])*29+Integer.parseInt(p[2]);
        int ta = Integer.parseInt(a[0])*17*29+Integer.parseInt(a[1])*29+Integer.parseInt(a[2]);
        int result = ta - tp;
        String resStr = transform(result);
        System.out.println(resStr);
    }
    public static String transform(int n){
        int res1 = n/(17*29);
        int res2 = n%(17*29)/29;
        int res3 = n%(17*29)%29/1;
        return Integer.toString(res1)+"."+Integer.toString(res2)+"."+Integer.toString(res3);
    }
}
