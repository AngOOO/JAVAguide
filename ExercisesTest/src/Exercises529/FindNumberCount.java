package Exercises529;

import java.util.Scanner;
public class FindNumberCount{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int[] count = new int[10];
        for(int i = 0;i < n.length();i++){
            count[n.charAt(i) - '0']++;
        }
        for(int i = 0;i < 10;i++){
            if(count[i] != 0){
                System.out.println(i+":"+count[i]);
            }
        }
    }
}