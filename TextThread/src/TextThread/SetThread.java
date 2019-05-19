package TextThread;

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }
}

public class SetThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread, "Thread - printCurrentThread").start();
        Thread thread = new Thread(() -> {
            System.out.println("ThreadName - " + Thread.currentThread().getName());
        });
        thread.setName("Thread - 2");
        thread.start();
    }
}
