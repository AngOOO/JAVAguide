package TextThread;

import sun.awt.windows.ThemeReader;

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
class TestWaitAndNotify implements Runnable{
    private boolean flag;
    private Object object;

    public TestWaitAndNotify(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }

    public void waitFun() throws InterruptedException {
        synchronized (object){
            while (true){
                System.out.println("wait开始..."+Thread.currentThread().getName());
                object.wait();
                System.out.println("wait结束..."+Thread.currentThread().getName());
                return;
            }
        }
    }
    public void notifyFun(){
        synchronized (object){
            System.out.println("notify开始..."+Thread.currentThread().getName());
            object.notify();
            System.out.println("notify结束..."+Thread.currentThread().getName());
        }
    }
    public void notifyAllFun(){
        synchronized (object){
            System.out.println("notifyAll开始..."+Thread.currentThread().getName());
            object.notifyAll();
            System.out.println("notifyAll结束..."+Thread.currentThread().getName());
        }
    }
    @Override
    public void run() {
        if (flag){
            try {
                this.waitFun();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            //this.notifyFun();
            this.notifyAllFun();
        }
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

    public static void TestWait() throws InterruptedException {
        Object object = new Object();
        synchronized (object){
            System.out.println("等待中...");
            object.wait();
            System.out.println("完成等待!");
        }
        System.out.println("main");
    }
    public static void TestWaitAndNotify() throws InterruptedException {
        Object o = new Object();
        TestWaitAndNotify waitThread = new TestWaitAndNotify(true,o);
        TestWaitAndNotify notifyThread = new TestWaitAndNotify(false,o);
        Thread thread1 = new Thread(waitThread,"waitThread1");
        Thread thread2 = new Thread(waitThread,"waitThread2");
        Thread thread3 = new Thread(waitThread,"waitThread3");
        Thread thread4 = new Thread(waitThread,"waitThread4");
        //Thread thread2 = new Thread(notifyThread,"notifyTHread");
        Thread thread = new Thread(notifyThread,"notifyAllThread");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Thread.sleep(2000);
        thread.start();
        System.out.println("main");
    }
    public static void main(String[] args) throws InterruptedException {
        //TextSleep();
        //TextYield();
        //TextJoin();
        //TestWait();
        TestWaitAndNotify();
    }

    public static void printTime() {
        Date date = new Date();
        System.out.println(date);
    }
}
