package TestSynchronized;
class Pen{
    private String pen = "笔";

    public String getPen() {
        return pen;
    }
}
class Book{
    private String book = "本";

    public String getBook() {
        return book;
    }

}
public class DeathLock {
    static Pen pen = new Pen();
    static Book book = new Book();
    public static void startThread(){
        //资源互相等待，造成死锁
        Thread penThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (pen){
                    System.out.println("Pen");
                    synchronized (book){
                        System.out.println("Book");
                    }
                }
            }
        });
        Thread bookThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (book){
                    System.out.println("book");
                    synchronized (pen){
                        System.out.println("pen");
                    }
                }
            }
        });
        penThread.start();
        bookThread.start();
    }
    public static void main(String[] args) {
        startThread();
    }
}
