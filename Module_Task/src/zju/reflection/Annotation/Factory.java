package zju.reflection.Annotation;


/**
 * @Autor:godfu
 * @Date:2021/12/4-21:55
 */
public class Factory {
    private Factory(){}

    /**
     * //直接返回一个与接口属性相关的实例化对象
     * @param clazz 核心业务的类属性
     * @param <T> 接口属性，由外部指定
     * @return 实例化对象
     */

    public static <T>T getInstance(Class<T> clazz){
        try {
            return (T) new MessageProxy().bind(clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
