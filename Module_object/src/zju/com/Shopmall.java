package zju.com;


import zju.edu.tool.ILink;
import zju.edu.tool.ILinkImpl;

/**
 * @Autor:godfu
 * @Date:2021/11/12-13:54
 * @versoin:1.0
 */

interface IGoods {// 商品标准
    public String getName();

    public double getPrice();
}

interface IShopcar {// 购物车标准
    public void add(IGoods good);

    public void delete(IGoods good);

    public Object[] getAll();
}

class Shopcar implements IShopcar {
    ILink<IGoods> allgoods = new ILinkImpl<IGoods>();// 定义动态商品链表
    public void add(IGoods good) {
        allgoods.add(good);
    }

    public void delete(IGoods good) {
        allgoods.remove(good);
    }

    public Object[] getAll() {
        return allgoods.toArray();
    }
}

class Cashier {
    private IShopcar shopcar;

    public Cashier(IShopcar shopcar) {
        this.shopcar = shopcar;
    }

    public double getAllPrice() {
        double sum = 0.0;

        Object[] result = shopcar.getAll();// 获得对象数组
        for (Object obj : result) {
            IGoods good = (IGoods) obj;
            sum += good.getPrice();
        }
        return sum;
    }

    
    
    public int getAllCount() {
        return this.shopcar.getAll().length;// 获取链表长度

    }
}


class Book implements IGoods {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book book = (Book) obj;
        return this.price == book.price && this.name.equals(book.name);
    }

    public String toString() {
        return "【图书】名称:" + this.name + "、价格:" + this.price;
    }
}

class Bag implements IGoods {
    private String name;
    private double price;

    public Bag(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;

        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Bag bag = (Bag) obj;
        return this.price == bag.price && this.name.equals(bag.name);
    }

    public String toString() {
        return "【书包】名称:" + this.name + "、价格:" + this.price;

    }
}

public class Shopmall {
    public static void main(String[] args) {
        IShopcar shopcar = new Shopcar();// 开购物车
        shopcar.add(new Book("Java开发", 79.8));
        shopcar.add(new Book("Oracle开发", 89.8));
        shopcar.add(new Bag("小强背包", 889.8));
        Cashier cash = new Cashier(shopcar);
        System.out.println("总价格:" + cash.getAllPrice());
        System.out.println("总数量:" + cash.getAllCount());

    }
}
