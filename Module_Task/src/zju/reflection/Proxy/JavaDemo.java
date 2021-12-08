package zju.reflection.Proxy;

/**
 * @Autor:godfu
 * @Date:2021/12/4-14:11
 */
public class JavaDemo {
    public static void main(String[] args) {
        IMessage msg = (IMessage) new MessageProxy().bind(new MessageReal());
        msg.send();
    }

}
