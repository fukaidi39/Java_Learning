package zju.Collection;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @Autor:godfu
 * @Date:2021/12/8-22:43
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        //如果要想使用Stream进行分析处理，则一定要将全部要分析的数据保存在集合中
        List<Order> all = new ArrayList<Order>();
        all.add(new Order("小强娃娃", 9.9, 10));
        all.add(new Order("林弱充气娃娃", 2987.9, 3));
        all.add(new Order("不强版笔记本电脑", 8987.9, 8));
        all.add(new Order("弱强茶杯", 2.9, 800));
        all.add(new Order("阿强版煎饼", 0.9, 138));
        //分析购买商品中带有“强”的信息数据，,并且进行商品单价和数量的处理，随后分析汇总
        DoubleSummaryStatistics stat = all.stream().filter((ele) -> ele.getName().contains("强")).mapToDouble((obj) -> obj.getAmount() * obj.getPrice()).summaryStatistics();
        System.out.println(stat.getMax());
    }
}

class Order { // 订单信息
    private String name; // 商品名称
    private double price; // 商品单价
    private int amount; // 商品数量
    public Order(String name,double price,int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
