package Exercises523;

import java.util.Scanner;

public class FindCount {
    static int[] num = null;
    static int maxSize = 0;
    public static void main(String[] args){
        //输入n为数组容量
        //分别将物品重量放入数组
        Scanner scanner = new Scanner(System.in);
        maxSize = scanner.nextInt();
        num = new int[maxSize];
        for(int i = 0;i < maxSize;i++){
            num[i] = scanner.nextInt();
        }
        //分别将各个物品累计相加
        count(40,maxSize);
    }
    private static void count(int capacity,int size){
        if(capacity == 0){
            return;
        }else if(capacity < 0 && size < 1){
            return;
        }else{
            count(capacity-num[size],size-1);
            count(capacity,size-1);
        }
    }
}
