package ExerDay27;

import java.util.Scanner;

public class One {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        int tmp = 0;
        for(int i = 0;i < n;i++){
            tmp = in.nextInt();
            for(int j = 0;j < i;j++){
                if(tmp != data[j]){
                    data[i] = tmp;
                }
            }
        }
        int x = in.nextInt();
        if(!(n <= 200 && n >=1)){
            throw new IllegalArgumentException();
        }
        System.out.println(findNum(data,x));
    }
    public static int findNum(int[] data,int x){
        int tmp = 0;
        for(int i = 0;i < data.length;i++){
            if(x == data[i]){
                tmp = i;
            }
        }
        return tmp;
    }
}
