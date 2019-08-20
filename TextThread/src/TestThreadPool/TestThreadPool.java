package TestThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadPool implements Runnable {
    private int ticket = 10;
    //private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName()+"剩余票数" + --this.ticket);
        }
        /*try {
            lock.lock();
        } finally {
            lock.unlock();
        }*/
    }
}

public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,3,30,TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0;i < 10;i++){
            threadPoolExecutor.execute(threadPool);
        }
        threadPoolExecutor.shutdown();
    }
}
