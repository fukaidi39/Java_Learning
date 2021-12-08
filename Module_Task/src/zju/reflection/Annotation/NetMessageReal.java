package zju.reflection.Annotation;

/**
 * @Autor:godfu
 * @Date:2021/12/4-21:42
 */
//核心业务类
public class NetMessageReal implements IMessage{
    @Override
    public void send(String msg) {
        System.out.println("[网络信息发送]:"+msg);
    }
}
