package StackText;

public interface Stack<T> {
    //入栈
    boolean push(T t);
    //出栈
    T pop();
    //返回栈顶元素
    T peek();
    //返回当前栈内元素个数
    int getSize();
    //判断当前栈是否为空
    boolean isEmpty();
}
