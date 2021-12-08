package zju.reflection.Annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Autor:godfu
 * @Date:2021/12/4-21:43
 */
//代理业务类
public class MessageProxy implements InvocationHandler {
    private Object target;//接受核心业务类
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(),this);
    }
    private boolean connect(){
        System.out.println("[代理业务]:建立网络连接");
        return true;
    }
    private void close(){
        System.out.println("[代理业务]:关闭连接");
    }
    //实现代理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnData = null;
        if (this.connect()){
            returnData = method.invoke(this.target,args);
        }
        this.close();
        return returnData;
    }
}
