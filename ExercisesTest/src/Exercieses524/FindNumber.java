package Exercieses524;

import java.util.Scanner;
import java.util.Stack;

public class FindNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack1 = new Stack();
        int[] tmp = null;
        while (scanner.hasNext()){
            stack1.push(scanner.nextInt());
        }
        while (!stack1.isEmpty()){
            tmp = new int[stack1.size()];
            for (int i = 0;i < stack1.size();i++){
                tmp[i] = stack1.pop();
            }
        }
    }
}
