package zju.com;

/**
 * @Autor:godfu
 * @Date:2021/11/16-16:57
 */
class Computer{
    private String name;
    private int price;
    private static int count = 0;
    public Computer(String name, int price){
        this.name = name;
        this.price = price;
        count++;
    }
    public String toString() {
        return "【电脑" + count + "】:" + " 型号：" + this.name + "  价格:" + this.price;
    }
}
class Resource{
    private Computer computer;
    public synchronized void set() throws InterruptedException {//生产电脑
        while (computer != null){
            super.wait();//当电脑还没搬走，生产线程等待
        }
        this.computer = new Computer("Dell",5000);
        System.out.println("生产电脑"+computer);
        super.notifyAll();

    }
    public synchronized void get() throws InterruptedException {//搬运电脑
        while(computer == null){
            super.wait();//电脑还没生产，搬运线程等待
        }
        System.out.println("搬运电脑"+computer);
        this.computer = null;
        super.notifyAll();
    }
}
class Producer implements Runnable{
    private Resource resource;
    public Producer(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                resource.set();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable{
    private Resource resource;
    public Consumer(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                resource.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Computer_produce {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}
