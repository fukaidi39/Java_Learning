package zju.reflection.autoset.Factory;

import zju.reflection.autoset.util.BeanUtil;

/**
 * @Autor:godfu
 * @Date:2021/12/2-14:44
 */
public class ClassInstanceFactory {
    private ClassInstanceFactory() {};

    /**
     * @param clazz :要实现反射实例化的Class对象
     * @param value ：要设置给对象的属性内容
     * @param <T> ：返回的对象类型
     * @return：一个已经配置好属性内容的Java类对象
     */
    public static <T> T create(Class<?> clazz, String value) {
        try {//通过反射设置属性时，类中必须要有无参构造
            Object obj = clazz.getDeclaredConstructor().newInstance();//获取实例化对象
            BeanUtil.setValue(obj, value);//通过反射设置属性
            return (T) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;//出现错误时设置为空
        }
    }
}
