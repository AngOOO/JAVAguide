package StackText;

import StackText.Impl.ArrayStack;
import StackText.Impl.ArrayStack1;
import StackText.Impl.LinkStack;

public class Test {
    public static void main(String[] args) {
        ArrayStack1<Integer> stack = new ArrayStack1<>(5);
        stack.push(999);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        /*LinkStack<Integer> stack = new LinkStack<>();
        stack.push(999);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.getSize());*/
        System.out.println(stack.isEmpty());
    }
}
