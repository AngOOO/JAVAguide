package TextTicket;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread {
    private int tickets = 10;

    @Override
    public void run() {
        while (this.tickets > 0) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "剩余票数：" + this.tickets--);
            }
        }
    }
}

class MyRunnable implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (this.ticket > 0) {
            System.out.println("剩余票数：" + --this.ticket);
        }
    }
}

class MyCallable implements Callable<String> {
    private int ticket = 10;

    @Override
    public String call() throws Exception {
        while (this.ticket > 0) {
            System.out.println("剩余票数：" + --this.ticket);
        }
        return "票卖光了！";
    }
}

class MyLock implements Runnable {
    private int ticket = 10;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();
            while (this.ticket > 0) {
                System.out.println("剩余票数：" + --this.ticket);
            }
        } finally {
            lock.unlock();
        }
    }
}

public class TextTicket {
    public static void TextMyThread() {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        MyThread myThread4 = new MyThread();
        MyThread myThread5 = new MyThread();
        //存在数据共享问题
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
    }

    public static void TextMyRunnable() {
        MyRunnable myRunnable = new MyRunnable();
        //数据可以共享
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
    }

    public static void TextMyCallable() {
        //只有一个线程在卖票
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
    }
    public static void TestMyLock(){
        MyLock myLock = new MyLock();
        new Thread(myLock).start();
        new Thread(myLock).start();
        new Thread(myLock).start();
        new Thread(myLock).start();
    }

    public static void main(String[] args) {
        //TextMyThread();
        //TextMyRunnable();
        //TextMyCallable();
        TestMyLock();
    }
}
