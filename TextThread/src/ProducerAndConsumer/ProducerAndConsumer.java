package ProducerAndConsumer;
class Goods{
    //商品名称
    private String goodsName;
    //商品数量
    private int goodsCount;
    //生产方法
    public synchronized void set(String goodsName){
        this.goodsName = goodsName;
        this.goodsCount = goodsCount+1;
        System.out.println(toString());
    }
    //消费方法
    public synchronized void get(){
        this.goodsCount = goodsCount-1;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
//生产者线程
class Producer implements Runnable{
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.set("HPcomputer");
    }
}
//消费者线程
class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.get();
    }
}
public class ProducerAndConsumer {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods();
        Thread proThread = new Thread(new Producer(goods),"生产者线程");
        Thread conThread = new Thread(new Consumer(goods),"消费者线程");
        proThread.start();
        Thread.sleep(2000);
        conThread.start();
    }
}
