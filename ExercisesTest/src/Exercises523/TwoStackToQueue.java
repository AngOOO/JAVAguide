package Exercises523;

import java.util.Stack;

public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        popStack2();
        pushStack1();
        return stack2.pop();
    }
    private int popStack2(){
        if(stack1.isEmpty()){
            throw new RuntimeException();
        }else{
            for(int i = 0;i < stack1.size();i++){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    private void pushStack1(){
        for (int i = 0;i < stack2.size();i++){
            stack1.push(stack2.pop());
        }
    }

    public static void main(String[] args) {
        TwoStackToQueue queue = new TwoStackToQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
