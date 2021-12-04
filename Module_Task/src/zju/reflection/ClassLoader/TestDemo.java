package zju.reflection.ClassLoader;

import java.lang.reflect.Method;

/**
 * @Autor:godfu
 * @Date:2021/12/3-20:27
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> cls = classLoader.loadData("zju.edu.Message");
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
        //反射调用类方法
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method method = cls.getDeclaredMethod("send");
        method.invoke(obj);
    }
}
