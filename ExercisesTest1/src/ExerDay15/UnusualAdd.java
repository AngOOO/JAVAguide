package ExerDay15;

public class UnusualAdd {
    public static int addAB(int A, int B) {
        if(B == 0) return A;
        int sum = A^B;
        int num = (A&B)<<1;
        int result = addAB(sum,num);
        return result;
    }
    public static int subAB(int A,int B){
        return A+addAB(~B,1);
    }

    public static void main(String[] args) {
        int sum = addAB(777,222);
        int sub = subAB(999,222);
        System.out.println(sub);
    }
}
