package TextQueue;

import java.util.LinkedList;
import java.util.Queue;

public class TextQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Java");
        queue.add("PHP");
        queue.add("C++");
        System.out.println("观察队首元素：" + queue.peek());
        System.out.println("出队列：" + queue.poll());
        System.out.println("出队列：" + queue.poll());
        System.out.println("出队列：" + queue.poll());
        System.out.println("出队列：" + queue.poll());//所有元素出队完成后返回null
    }
}
