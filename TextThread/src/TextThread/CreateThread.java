package TextThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//创建线程 1：extends Thread，覆写run方法
class MyThread1 extends Thread {
    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(name + "-i:" + i);
        }
    }
}

//创建线程 2：implements Runnable，在new的Thread对象中传入实现Runnable的类对象
class MyThread2 implements Runnable {
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(name + " i:" + i);
        }
    }
}

//创建线程 3：implements Callable，在new的FutureTask对象中传入实现Callable的类对象
//在new的Thread对象中传入FutureTask对象
class MyThread3 implements Callable<String> {
    private String name;

    public MyThread3(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 3; i++) {
            System.out.println(name + "i:" + i);
        }
        return name;
    }
}

public class CreateThread {
    public static void MyThread1() {
        MyThread1 myThread1 = new MyThread1("Java-Thread-1");
        MyThread1 myThread2 = new MyThread1("Java-Thread-2");
        MyThread1 myThread3 = new MyThread1("Java-Thread-3");
        //仅仅是调用了类中的run方法，并不是启动线程
        /*myThread1.run();
        myThread2.run();
        myThread3.run();*/

        //使用start才是真正的启动线程，只能调用一次
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

    public static void MyThread2() {
        MyThread2 myThread = new MyThread2("Java-Thread");
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名对象-Thread");
            }
        }).start();
        Runnable runnable = () -> System.out.println("lambda-Thread");
        new Thread(runnable).start();
    }

    public static void MyThread3() throws ExecutionException, InterruptedException {
        //FutureTask在多线程并发下，保证任务只执行一次
        FutureTask<String> futureTask = new FutureTask<>(new MyThread3("Java-Thread"));
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        //get方法是阻塞操作
        System.out.println(futureTask.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread2();
    }
}
