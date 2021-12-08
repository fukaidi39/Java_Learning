package zju.reflection.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Autor:godfu
 * @Date:2021/12/4-14:12
 */
public class MessageProxy implements InvocationHandler {
    private Object target;//接收真实业务对象
    /**
     * 接收真实业务对象，返回代理后的业务对象
     * @param target: 真实业务对象
     * @return 生成的代理业务对象
     */
    public Object bind(Object target){
        this.target = target;
        //返回代理业务对象，传入真实业务类加载器、代理接口、代理方法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
    //代理业务逻辑
    public boolean connect(){
        System.out.println("[代理业务]建立连接");
        return true;
    }
    public void close(){
        System.out.println("[代理业务]关闭连接");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //定义方法返回值
        Object returnData = null;
        if(this.connect()){
            //反射真实业务的方法
            returnData = method.invoke(this.target,args);
            this.close();
        }
        return returnData;
    }
}
