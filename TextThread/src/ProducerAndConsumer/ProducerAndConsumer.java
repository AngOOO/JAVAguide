package ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;

class Goods {
    //商品名称
    private String goodsName;
    //商品数量
    private int goodsCount;
    public int getGoodsCount(){
        return goodsCount;
    }
    //生产方法1，生产方法必须优先于消费方法执行
    /*public synchronized void set(String goodsName){
        this.goodsName = goodsName;
        this.goodsCount = goodsCount+1;
        System.out.println(toString());
    }*/

    //生产方法2，等待生产机制
    /*public synchronized void set(String goodsName) throws InterruptedException {
        if (goodsCount > 0) {
            System.out.println("库存有剩余...");
            wait();
        }
        this.goodsName = goodsName;
        this.goodsCount = goodsCount + 1;
        Thread.sleep(1000);
        System.out.println("生产商品..."+toString());
        notify();
    }*/

    //多个生产者生产方法
    public synchronized void set(String goodsName) throws InterruptedException {
        if (goodsCount > 0) {
            System.out.println(Thread.currentThread().getName()+"等待商品生产...");
            wait();
        }
        this.goodsName = goodsName;
        this.goodsCount = goodsCount + 1;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "生产商品" + toString());
        notifyAll();
    }

    //消费方法1，必须在生产方法之后执行
    /*public synchronized void get(){
        this.goodsCount = goodsCount-1;
        System.out.println(toString());
    }*/

    //消费方法2，消费者等待机制
    /*public synchronized void get() throws InterruptedException {
        if (goodsCount == 0) {
            System.out.println("等待商品生产...");
            wait();
        }
        this.goodsCount = goodsCount - 1;
        Thread.sleep(1000);
        System.out.println("消费商品..."+toString());
        notify();
    }*/

    //多个消费者消费方法
    public synchronized void get() throws InterruptedException {
        if (goodsCount == 0) {
            System.out.println(Thread.currentThread().getName()+"等待商品生产...");
            wait();
        }
        this.goodsCount = goodsCount - 1;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "消费商品" + toString());
        notifyAll();
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
class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            this.goods.set("HPcomputer");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//消费者线程
class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            this.goods.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerAndConsumer {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread proThread = new Thread(new Producer(goods), "生产者线程" + i);
            threads.add(proThread);
        }
        for (int i = 0; i < 10; i++) {
            Thread conThread = new Thread(new Consumer(goods), "消费者线程" + i);
            threads.add(conThread);
        }
        for (Thread t : threads) {
            t.start();
        }
    }
}
