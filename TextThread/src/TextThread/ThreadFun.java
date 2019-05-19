package TextThread;

import java.util.Date;

class TextThreadSleep implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread:" + i + "  " + Thread.currentThread().getName());
            try {
                //指的是让线程暂缓执行，sleep不释放对象锁
                Thread.sleep(1000);//以毫秒为单位
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TextThreadYield implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Thread.yield();
            System.out.println("Thread:" + i + "  " + Thread.currentThread().getName());
        }
    }
}

class TextThreadJoin implements Runnable {
    @Override
    public void run() {
        System.out.println("主线程开始时间：");
        ThreadFun.printTime();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("睡眠结束时间");
        ThreadFun.printTime();
    }
}

public class ThreadFun {
    public static void TextSleep() {
        TextThreadSleep thread = new TextThreadSleep();
        new Thread(thread, "Thread-TextSleep-1").start();
        new Thread(thread, "Thread-TextSleep-2").start();
        new Thread(thread, "Thread-TextSleep-3").start();
    }

    public static void TextYield() {
        TextThreadYield thread = new TextThreadYield();
        new Thread(thread, "Thread-TextYield-1").start();
        new Thread(thread, "Thread-TextYield-2").start();
        new Thread(thread, "Thread-TextYield-3").start();
    }

    public static void TextJoin() {
        TextThreadJoin threadJoin = new TextThreadJoin();
        Thread thread = new Thread(threadJoin, "TextThreadJoin");
        thread.start();
        System.out.println(Thread.currentThread().getName());
        try {
            thread.join();//让主线程休眠等待run方法执行完成后，再继续执行主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");//不调用join时end先于睡眠结束时间执行
    }

    public static void main(String[] args) {
        //TextSleep();
        //TextYield();
        TextJoin();
    }

    public static void printTime() {
        Date date = new Date();
        System.out.println(date);
    }
}
