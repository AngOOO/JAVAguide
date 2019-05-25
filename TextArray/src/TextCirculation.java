public class TextCirculation {
    //1. 使用for循环打印乘法口诀表
    public static void printMultiplicationTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    //2. 递归实现20!
    public static double factorial(double data) {
        if (data == 1) {
            return 1;
        } else {
            return data * factorial(data - 1);
        }
    }

    //3. 一个斐波那契数列是由数字1、1、2、3、5、8、13、21、34等等组成的，
    //其中每一个数字(从第三个数字起)都是前两个数字的和。创建一个方法，
    //接受一个整数参数，并显示从第一个元素开始总共由该参数指定的个数所构成的所有斐波那契数字。
    //例如，如果运行 java Fibonacci 5(Fibonacci为类名)，那么输出应该是1、1、2、3、5。
    public static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        } else {
            return (fibonacci(num - 1) + fibonacci(num - 2));
        }
    }

    // 4.编程题：
    // 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，
    // 其各位数字立方和等于该数本身。例如：153是一个 "水仙花数 "，
    // 因为153=1的三次方＋5的三次方＋3的三次方。
    public static void printDaffodil() {
        int a;
        int b;
        int c;
        for (int i = 1; i < 1000; i++) {
            c = i / 100;
            b = (i / 10) % 10;
            a = i % 10;
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.print(i + "、");
            }
        }
    }

    // 5.
    // 一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。
    // 例如6=1＋2＋3.编程 找出1000以内的所有完数。
    public static void printWanNumber() {
        int i;
        int a;
        int b;
        for (i = 1; i < 1000; i++) {
            int sum = 0;
            for (a = 0; a <= i; a++) {
                for (b = 0; b <= i; b++) {
                    if (a * b == i) {
                        sum += b;
                    }
                }
            }
            if (sum == i) {
                System.out.print(i + "、");
            }
        }
    }

    public static void main(String[] args) {
        //printMultiplicationTable();
        //System.out.println("20!=" + factorial(20));
        /*for (int i = 0; i < 5; i++) {
            System.out.print(fibonacci(i) + "、");
        }*/
        //printDaffodil();
        printWanNumber();
    }
}
