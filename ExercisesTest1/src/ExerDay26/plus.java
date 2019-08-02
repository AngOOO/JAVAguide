package ExerDay26;

import java.util.Scanner;

public class plus {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        StringBuffer sum = new StringBuffer();
        while (!(in.nextLine().equals("\n"))){
            sb.append(in.nextInt());
            sum.append(plus(sb));
            sum.append(" ");
            sum.append(plus1(sb));
            sum.append("\n");
        }
        System.out.println(sum.toString());
    }
    public static int plus(StringBuffer sb){
        int[] data = new int[sb.length()];
        int sum = 0;
        for (int i = 0;i < sb.length();i++){
            data[i] = Integer.parseInt(sb.substring(i,i+1));
            sum += data[i];
        }
        return sum;
    }
    public static int plus1(StringBuffer sb){
        int[] data = new int[sb.length()];
        int sum = 0;
        for (int i = 0;i < sb.length();i++){
            data[i] = Integer.parseInt(sb.substring(i,i+1));
            sum += (data[i]*data[i]);
        }
        return sum;
    }
}
