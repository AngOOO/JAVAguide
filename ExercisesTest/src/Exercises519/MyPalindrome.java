package Exercises519;

import java.util.Scanner;

public class MyPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = null;
        String str2 = null;
        //输入字符串1
        if (scanner.hasNext()) {
            str1 = scanner.nextLine();
        }
        //输入字符串2
        if (scanner.hasNext()) {
            str2 = scanner.nextLine();
        }
        //将字符串2插入字符串1
        //判断回文串，记录成功次数
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            String str = insertString(str1, str2, i);
            if (judge(str)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static String insertString(String str1, String str2, int index) {
        char[] strA = str1.toCharArray();
        char[] strB = str2.toCharArray();
        int length = strA.length + strB.length;
        char[] resultChar = new char[length];
        if (index == 0){
            System.arraycopy(strB,0,resultChar,0,strB.length);
            System.arraycopy(strA,0,resultChar,strB.length,strA.length);
        }else {
            System.arraycopy(strA, 0, resultChar, 0, index);
            System.arraycopy(strB, 0, resultChar, index, strB.length);
            System.arraycopy(strA, index, resultChar, index + strB.length, strA.length - index);
        }
        String resultStr = new String(resultChar);
        return resultStr;
    }

    private static boolean judge(String str) {
        char[] string = str.toCharArray();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (string[i] != string[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
