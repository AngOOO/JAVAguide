package TestSynchronized;
class Ticket implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        for (int i = 0;i < 3;i++){
            synchronized (this){
                if (this.ticket > 0){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"还有"+this.ticket--+"张票");
                }
            }
        }
    }
}
public class TestSynchronized {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket,"A");
        Thread t2 = new Thread(ticket,"B");
        Thread t3 = new Thread(ticket,"C");
        Thread t4 = new Thread(ticket,"D");
        Thread t5 = new Thread(ticket,"E");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
