package Exercises521;

import java.util.Scanner;

public class MyPrintMaxNumberString {
    public static void main(String[] args) {
        //输入一串字符
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //取出是最长数字的串
        String maxNumberString = maxNumberStr(str);
        //输出最长的数字串
        System.out.println(maxNumberString);
    }

    private static String maxNumberStr(String str) {
        //先将字符串变为字符数组
        char[] strChar = str.toCharArray();
        //记录每次扫描的数字串长度，为非数字串时更新为0
        int count = 0;
        //记录数字串结束位置
        int tail = 0;
        //最长数字串长度
        int maxLength = 0;
        for (int i = 0; i < strChar.length; i++) {
            if (strChar[i] >= '0' && strChar[i] <= '9') {
                count++;
                if (maxLength < count) {
                    maxLength = count;
                    tail = i;
                }
            } else {
                count = 0;
            }
        }
        return str.substring(tail - maxLength + 1, tail + 1);
    }
}
