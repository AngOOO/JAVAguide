package TestSynchronized;

class Ticket1 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (this) {//同步代码块
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还有" + --this.ticket + "张票");
                }
            }
        }
    }
}

class Ticket2 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                this.SaleTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //同步方法
    private synchronized void SaleTicket() throws InterruptedException {
        Thread.sleep(200);
        if (this.ticket > 0){
            System.out.println(Thread.currentThread().getName() + "还剩" + --ticket + "张票");
        }
    }
}

public class TestSynchronized {
    public static void main(String[] args) {
        Ticket2 ticket1 = new Ticket2();
        Thread t1 = new Thread(ticket1, "A");
        Thread t2 = new Thread(ticket1, "B");
        Thread t3 = new Thread(ticket1, "C");
        Thread t4 = new Thread(ticket1, "D");
        Thread t5 = new Thread(ticket1, "E");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        /*Ticket1 ticket1 = new Ticket1();
        Thread t1 = new Thread(ticket1, "A");
        Thread t2 = new Thread(ticket1, "B");
        Thread t3 = new Thread(ticket1, "C");
        Thread t4 = new Thread(ticket1, "D");
        Thread t5 = new Thread(ticket1, "E");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();*/
    }
}
