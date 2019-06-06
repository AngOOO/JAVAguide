package ExerDay16;

import java.util.Scanner;
import java.util.Stack;

public class XiPai {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        if(T > 100 || n < 1 || k > 100){
            throw new IllegalArgumentException();
        }
        long[] num = new long[2*n];
        int i = 0;
        while(in.hasNext()){
            if(i < 2*n){
                num[i] = in.nextInt();
                i++;
            }
            break;
        }
    }
    private static void Myshuffle(int[] num,int n,int i){
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        for(int j = 0;j < n;j++){
            stack1.push(num[i]);
            stack2.push(num[i+1]);
        }
    }
}
