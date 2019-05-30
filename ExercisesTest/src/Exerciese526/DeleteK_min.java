package Exerciese526;

import java.util.Scanner;
import java.util.Stack;

public class DeleteK_min {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        while (scanner.hasNext()) {
            stack.push(scanner.nextInt());
        }
        int length = stack.size();
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = stack.pop();
        }
        int k = data[length-2];
    }
}
