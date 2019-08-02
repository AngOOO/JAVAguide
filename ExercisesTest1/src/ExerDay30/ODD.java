package ExerDay30;

import java.util.Scanner;

public class ODD {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            if(str.length() > 100){
                throw new IllegalArgumentException();
            }
            //将str分割成一个个字符，存入char[]中
            char[] chars = str.toCharArray();
            for(int i = 0;i < str.length();i++){
                System.out.println(ODD(chars[i]));
            }
        }
    }
    //计算二进制形式的字符中1的个数，偶数在其最高位加上1，反之加上0
    public static String ODD(char chars){
        //将字符转换为二进制数
        String result = Integer.toBinaryString(chars);
        String binary = new String();
        //记录1的个数
        int count = 0;
        if (result.length() == 6){
            result = '0'+result;
        }
        for(int i = 0;i < result.length();i++){
            if(result.charAt(i) == '1'){
                count++;
            }
        }
        //偶数在其最高位加上1，反之加上0
        if(count%2 == 0){
            binary = '1'+result;
        }else if(count%2 == 1){
            binary = '0'+result;
        }
        return binary;
    }
}
