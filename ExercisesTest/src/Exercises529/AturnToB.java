package Exercises529;

public class AturnToB {
    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = 1;
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                }
                B[i] *= A[j];
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4};
        int[] B = multiply(A);
        for (int i = 0;i < B.length;i++){
            System.out.println(B[i]);
        }
    }
}