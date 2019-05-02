package TextStark;

import java.util.Stack;

public class TextStark {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("C++");
        stack.push("PHP");
        System.out.println("栈中元素个数：" + stack.size());
        System.out.println("栈顶元素：" + stack.peek());
        System.out.println("出栈：" + stack.pop());
        System.out.println("观察栈顶元素：" + stack.peek());
        stack.pop();
        stack.pop();
        //stack.pop();EmptyStackException
        //System.out.println("观察栈顶元素："+stack.peek());EmptyStackException
        if (stack.isEmpty()) {
            System.out.println("栈空了");
            System.out.println("入栈：" + stack.push("MXM"));
        } else {
            System.out.println("出栈：" + stack.pop());
        }
        System.out.println("观察栈顶元素：" + stack.peek());
    }
}
