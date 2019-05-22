package QueueTest;

public interface Queue<E> {
    //入栈
    void enQueue(E e);
    //出栈
    E deQueue();
    //返回队首元素
    E peek();
    //返回队列长度
    int getSize();
    //判断队列是否为空
    boolean isEmpty();
}
