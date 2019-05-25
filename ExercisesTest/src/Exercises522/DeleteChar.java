package Exercises522;

import java.util.Scanner;
public class DeleteChar {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        StringBuilder strA = new StringBuilder(str1);
        for (int i = 0;i < str2.length();i++){
            for (int j = 0;j < strA.length();j++){
                if (str2.charAt(i) == strA.charAt(j)){
                    strA.deleteCharAt(j);
                }
            }
        }
        System.out.println(strA);
    }
}
