package zju.reflection.Proxy;

/**
 * @Autor:godfu
 * @Date:2021/12/4-14:12
 */
public class MessageReal implements IMessage{

    @Override
    public void send() {
        System.out.println("[核心业务]发送");
    }
}
