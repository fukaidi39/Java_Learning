package zju.store;

/**
 * @Autor:godfu
 * @Date:2021/11/19-13:44
 */
//向用户发送消息
class Message{
    private String info;
    public Message(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
class Channel{//定义通道类
    private  static final ThreadLocal<Message> THREADLOCAL = new ThreadLocal<>();//静态方法只能调用静态属性
    private Channel(){}//私有化
    //保存传入的Message对象
    public static void setMessage(Message m){
       THREADLOCAL.set(m) ;
    }
    public static void send(){
        System.out.println(Thread.currentThread().getName()+":"+THREADLOCAL.get().getInfo());
    }
}

public class Javademo {
    public static void main(String[] args) {
        new Thread(()->{
            Message msg = new Message("第一个线程的消息.");
            Channel.setMessage(msg);
            Channel.send();
        },"线程A").start();
        new Thread(()->{
            Message msg = new Message("第二个线程的消息.");
            Channel.setMessage(msg);
            Channel.send();
        },"线程B").start();
        new Thread(()->{
            Message msg = new Message("第三个线程的消息.");
            Channel.setMessage(msg);
            Channel.send();
        },"线程C").start();
    }
}
