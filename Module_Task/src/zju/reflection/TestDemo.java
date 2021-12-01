package zju.reflection;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Autor:godfu
 * @Date:2021/11/30-11:23
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        //获取Unsafe实例化对象通过私有常量属性:private static final Unsafe theUnsafe = new Unsafe();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");//获取成员
        field.setAccessible(true);//接触封装
        Unsafe instance = (Unsafe) field.get(null);//static属性不需要传递实例化对象

        // 利用Unsafe类绕过了JVM的管理机制，可以在没有实例化对象的情况下获取一个Singleton类实例化对象
        Singleton singleton = (Singleton) instance.allocateInstance(Singleton.class);
        singleton.print();
    }
}
class Singleton{
    private Singleton(){
        System.out.println("实例化对象");
    }
    public void print(){
        System.out.println("打印成功");
    }

}
