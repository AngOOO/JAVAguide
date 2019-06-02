package TestThreadLocal;

public class TestThreadLocal {
    private static String commStr;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        commStr = "commStr";
        threadLocal.set("commStr");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr = "thread";
                threadLocal.set("thread");
                System.out.println(threadLocal.get());//thread
            }
        });
        thread.start();
        thread.join();//让线程先于主线程执行完
        System.out.println(commStr);//thread
        System.out.println(threadLocal.get());//commStr
    }
}
