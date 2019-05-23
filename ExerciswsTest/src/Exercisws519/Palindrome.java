package Exercisws519;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        //输入字符串A
        //输入字符串B
        Scanner scanner = new Scanner(System.in);
        String strA = scanner.nextLine();
        String strB = scanner.nextLine();
        //字符串B插入到字符串A
        int count = 0;
        for (int i = 0;i <= strA.length();i++){
            StringBuilder sb = new StringBuilder(strA);
            sb.insert(i,strB);
            //返回是回文的次数
            if (isPalindrome(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
    private static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
