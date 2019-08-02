/*
package ExerDay27;

import java.util.Scanner;

public class IP {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuffer ipB = new StringBuffer();
        double ipD = 0;
        //输入IP地址
        if(!("\n".equals(in.next()))){
            ipB.append(in.nextInt());
        }
        //输入十进制IP地址
        ipD = in.nextDouble();
        //将十进制IP地址转为二进制数n
        StringBuffer n = transBin(ipD);
        //将n分隔为四部分，分别转换为十进制存入data[]
        int[] data = new int[4];
        StringBuffer result1 = new StringBuffer();
        for (int i = 0;i < 4;i++){
            data[i] = Integer.parseInt(n.substring(i*4,(i+1)*4-1));
            result1.append(data[i]);
            if (i != 3){
                result1.append(".");
            }
        }
        int[] ipBdata = ipNum(ipB);
        StringBuffer result2 = new StringBuffer();
        //将ipBdata中的数字拼接在一起
        for (int i = 0;i < 4;i++){
            result2.append(ipBdata[i]);
        }
    }
    //将十进制转换为二进制数
    public static StringBuffer transBin(double ipD){

    }
    //截取ipB中的两点之间的数字转换为二进制存入数组
    public static int[] ipNum(StringBuffer ipB){

    }
}
*/
