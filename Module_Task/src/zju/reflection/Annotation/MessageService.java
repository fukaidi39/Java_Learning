package zju.reflection.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Autor:godfu
 * @Date:2021/12/4-22:08
 */
//利用自定义注解指定核心业务指向
@Retention(RetentionPolicy.RUNTIME)//运行准则
@interface UserMessage{
    public Class<?> clazz();
}

@UserMessage(clazz = NetMessageReal.class)
public class MessageService {
    private IMessage message;
    public MessageService(){
        //获取注解
        UserMessage usg = MessageService.class.getAnnotation(UserMessage.class);
        this.message = (IMessage) Factory.getInstance(usg.clazz());
    }
    public void send(String msg){
        this.message.send(msg);
    }
}
