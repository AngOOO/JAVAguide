package Exerciese525;

import java.util.Scanner;

public class CakeInBox {
    public static void main(String[] args){
        //输入两个数，分别为W、H
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int H = scanner.nextInt();
        //由W、H构造一个W*H的二维数组
        char[][] box = new char[W][H];
        //遍历二维数组的坐标,在距离为2的位置放入*
        for(int i = 0;i < W;i++){
            for(int j = 0;j < H;j++){
                for(int x = 0;x < W;x++){
                    for(int y = 0;y < H;y++){
                        while(x != i && y != j){
                            double d = Math.sqrt((j-y)*(j-y)+(i-x)*(i-x));
                            if(d == 2){
                                box[x][y] = '*';
                            }
                        }
                    }
                }
            }
        }
        //再遍历一遍后记录没有*的个数
        int count = 0;
        for(int i = 0;i < W;i++){
            for(int j = 0;j < H;j++){
                if(box[i][j] != '*'){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
