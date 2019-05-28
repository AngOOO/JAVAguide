package StackText.MinStack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (tempStack.isEmpty() || x <= tempStack.peek()){
            tempStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(tempStack.peek())){
            tempStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return tempStack.peek();
    }
}
