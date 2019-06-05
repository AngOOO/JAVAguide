package ExerDay13;

import java.util.Scanner;

public class printSquare {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int n = 0;
        if(N >= 3 && N <= 20){
            n = N;
        }
        String str = scanner.next();
        char c = str.charAt(0);
        //构建第一行与最后一行输出的字符串
        StringBuilder sb1 = new StringBuilder(c);
        for (int i = 0;i < n;i++){
            sb1.append(c);
        }
        //构建除了第一行和最后一行输出的字符串
        StringBuilder sb2 = new StringBuilder(c);
        for (int i = 0;i < n;i++){
            if (i == 0 || i == n-1){
                sb2.append(c);
            }else {
                sb2.append(" ");
            }
        }
        for(int i = 0;i < (n+1)/2;i++){
            if(i == 0 || i == (n+1)/2-1){
                System.out.println(sb1);
            }else {
                System.out.println(sb2);
            }
        }
    }
}
