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

    public static void main(String[] args) {
        //printMultiplicationTable();
        System.out.println("20!=" + factorial(20));
    }
}
