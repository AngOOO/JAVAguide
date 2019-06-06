package ExerDay15;

import java.util.Scanner;

public class HungerYi {
    public static void main(String[] args) {
        //输入一个数(1~1,000,000,006)
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        //统计(4x+3)%1000000007=0的次数count
        int count = 0;
        int result = 0;
        while (result <= 100000){
            if ((4*x+3)%100000007 == 0){
                count++;
            }
            //最终次数为result=count/3+count%3
            result = count/3+count%3;
        }

    }
}
