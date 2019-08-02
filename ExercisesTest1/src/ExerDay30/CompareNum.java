package ExerDay30;

import java.util.Scanner;

public class CompareNum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] data = new String[n];
        if(n>=100){
            throw new IllegalArgumentException();
        }
        for(int i = 0;i < n;i++){
            data[i] = notHasZero(in.nextLine());
        }
        data = compareNum(data);
        for(String str:data){
            System.out.println(str);
        }
    }
    //保证每个数字前缀无0
    public static String notHasZero(String str){
        if(str.charAt(0) == '0'){
            str = String.copyValueOf(str.toCharArray(),1,str.length()-1);
            notHasZero(str);
        }
        return str;
    }
    //比较这些数字，结果存入数组中
    public static String[] compareNum(String[] data){
        for(int i = 0;i < data.length;i++){
            for(int j = 0;j < data.length-i-1;j++){
                //比较数字长短
                if(data[j].length() > data[j+1].length()){
                    String tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
                //长短相同的数字，再比较大小
                if(data[j].length() == data[j+1].length()){
                    for(int k = 0;k < data[j].length();k++){
                        if(Integer.parseInt(data[j].substring(k,k+1)) >
                                Integer.parseInt(data[j+1].substring(k,k+1))){
                            String tmp = data[j];
                            data[j] = data[j+1];
                            data[j+1] = tmp;
                        }
                    }
                }
            }
        }
        return data;
    }
}
