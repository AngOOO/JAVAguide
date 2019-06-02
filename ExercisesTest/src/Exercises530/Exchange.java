package Exercises530;

public class Exchange {
    public static int[] exchangeAB(int[] AB) {
        AB[0] = AB[0]^AB[1];
        AB[1] = AB[0]^AB[1];
        AB[0] = AB[0]^AB[1];
        return AB;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = exchangeAB(a);
        System.out.println(b[0]+" "+b[1]);
    }
}
