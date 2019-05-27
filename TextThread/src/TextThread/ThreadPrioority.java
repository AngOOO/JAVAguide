package TextThread;


class A implements Runnable{

    @Override
    public void run() {
        System.out.println("A线程的优先级："+Thread.currentThread().getPriority());
        Thread thread = new Thread(new B());
        thread.start();
    }
}
class B implements Runnable{

    @Override
    public void run() {
        System.out.println("B线程的优先级："+Thread.currentThread().getPriority());
    }
}
public class ThreadPrioority {
    public static void main(String[] args) {
        Thread thread = new Thread(new A());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }
}
