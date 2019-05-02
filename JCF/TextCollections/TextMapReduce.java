package TextCollections;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

class Order {
    private String title;
    private double price;
    private int amount;

    public Order(String title, double price, int amount) {
        this.title = title;
        this.price = price;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

public class TextMapReduce {
    public static void TextMapReduce1() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("苹果", 5, 20));
        orderList.add(new Order("香蕉", 3, 2));
        orderList.add(new Order("梨", 6.2, 6));
        orderList.add(new Order("橙子", 3.99, 9));
        orderList.add(new Order("榴莲", 308.7, 1));
        orderList.add(new Order("西瓜", 27.8, 1));
        System.out.println("订单数量：" + orderList.size());
        System.out.println("订单数量（流）：" + orderList.stream().count());

        double total = 0.0d;
        for (Order o : orderList) {
            total += o.getAmount() * o.getPrice();
        }
        System.out.println("总价：" + total);

        /*double totalPrice = orderList.stream()
                .map(order ->
                {
                    return order.getPrice() * order.getAmount();
                })
                .reduce((sum, item) -> sum = sum + item)
                .getAsDouble();
        System.out.println("总价（流）：" + totalPrice);*/
        double totalPrice = orderList.stream()
                .mapToDouble(order -> order.getAmount() * order.getPrice())
                .reduce((sum, item) -> sum = sum + item).getAsDouble();
        System.out.println("总价（流）：" + totalPrice);
    }

    public static void TextMapReduce2() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("苹果", 5, 20));
        orderList.add(new Order("香蕉", 3, 2));
        orderList.add(new Order("梨", 6.2, 6));
        orderList.add(new Order("橙子", 3.99, 9));
        orderList.add(new Order("榴莲", 308.7, 1));
        orderList.add(new Order("西瓜", 27.8, 1));

        /*double totalPrice = 0.0d;
        int count = 0;
        double avgPrice = 0.0d;
        double maxPrice = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;
        for (Order o : orderList) {
            count++;
            double price = o.getPrice() * o.getAmount();
            totalPrice += price;
            if (price > maxPrice) {
                maxPrice = price;
            }
            if (price < minPrice) {
                minPrice = price;
            }
        }
        avgPrice = totalPrice / count;*/
        DoubleSummaryStatistics statistics = orderList.stream()
                .mapToDouble(order->order.getPrice()*order.getAmount())
                .summaryStatistics();
        System.out.println("商品数量：" + statistics.getCount());
        System.out.println("商品总价：" + statistics.getSum());
        System.out.println("平均价格：" + statistics.getAverage());
        System.out.println("订单最大金额：" + statistics.getMax());
        System.out.println("订单最小金额：" + statistics.getMin());
    }

    public static void main(String[] args) {
        TextMapReduce2();
    }
}
