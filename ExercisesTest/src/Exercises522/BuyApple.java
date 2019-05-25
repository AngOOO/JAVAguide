package Exercises522;

import java.util.Scanner;

public class BuyApple {
    public static void main(String[] args){
        //输入一个数字
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        //如果输入的是奇数直接返回-1
        if(num % 2 != 0){
            System.out.println(-1);
            return;
        }else{
            //让两个数双重循环，寻找a*6+b*8==num的结果
            for(int a = 0;a <= num;a++){
                for(int b = 0;b <= num;b++){
                    if(a * 6 + b * 8 == num){
                        if(min > (a+b)){
                            min = a+b;
                        }
                    }else if(a * 6 + b * 8 > num){
                        break;
                    }
                }
            }
            //输出最小的a+b
            System.out.println(min);
        }
    }
}
