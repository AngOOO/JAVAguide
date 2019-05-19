package TextThread;


//1，设置标志位使线程停止
class TextStop1 implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "执行" + i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

//2,使用stop方法停止线程
class TextStop2 implements Runnable {
    @Override
    public void run() {
        int x;
        int y;
        int z = 0;
        try {
            x = 20;
            y = 30;
            System.out.printf("第一次print：x = %d,y = %d,z = %d", x, y, z);
            Thread.sleep(5000);
            z = y;
            System.out.printf("第二次print：x = %d,y = %d,z = %d", x, y, z);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//3，使用interrupt方法中断
class TextStop3 implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            try {
                Thread.sleep(1000);
                boolean bool = Thread.currentThread().isInterrupted();
                if (bool) {
                    System.out.println("bool状态：" + bool);
                }
                System.out.println(Thread.currentThread().getName() + "执行" + i);
                i++;
            } catch (InterruptedException e) {
                boolean bool = Thread.currentThread().isInterrupted();
                System.out.println(bool);
                return;
            }
        }

    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class StopThread {
    public static void TextStopThread1() {
        TextStop1 stop1 = new TextStop1();
        Thread thread = new Thread(stop1, "stopThread-1");
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop1.setFlag(false);//使线程停止
    }

    public static void TextStopThread2() throws InterruptedException {
        TextStop2 stop2 = new TextStop2();
        Thread thread = new Thread(stop2, "stopThread-2");
        thread.start();
        Thread.sleep(6000);
        thread.stop();//被废弃，因为不安全，容易造成线程中赋值不完整现象
    }

    public static void TextStopThread3() throws InterruptedException {
        TextStop3 stop3 = new TextStop3();
        Thread thread = new Thread(stop3,"stopThread-3");
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        System.out.println("end");
    }
    public static void main(String[] args) {
        //TextStopThread1();
        /*try {
            TextStopThread2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        try {
            TextStopThread3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
