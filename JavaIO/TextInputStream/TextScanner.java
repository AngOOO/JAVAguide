package TextInputStream;

import java.util.Scanner;

public class TextScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入>");
        /*while (scanner.hasNext()) {//以连续字符输出，不得以任何符号结束
            System.out.println("内容为>" + scanner.next());
        }*/
        /*if (scanner.hasNextBoolean()) {
            System.out.println(">>>"+scanner.next());
        } else {
            System.out.println("请输入boolean！");
        }*/
        System.out.print("生日>");
        if (scanner.hasNext("\\d{4},\\d{2},\\d{2}")){
            System.out.println("请校验生日输入是否正确>"+scanner.next());
        }else {
            System.out.println("请按照指定格式重新输入！");
        }
    }
}
