package zju.com.Factory;

/**
 * @Autor:godfu
 * @Date:2021/11/28-22:32
 */
public class Factory {
    private Factory(){}  //没有实例化对象的意义，所以构造方法私有化
    //传统定义泛型工厂类
    // public static <T>T getInstance(String classname){
    //     switch (classname) {
    //         case "NumberServiceImpl":
    //             return (T) new NumberServiceImpl();//向下转型
    //         case "FileServiceImpl":
    //             return (T) new FileServiceImpl();
    //         case "StringServiceImpl":
    //             return (T) new StringServiceImpl();
    //         case "StudentServiceImpl":
    //             return (T) new StudentServiceImpl();
    //         case "UserServiceImpl":
    //             return (T) new UserServiceProxy(new UserServiceImpl());
    //         case "VoteServiceImpl":
    //             return (T) new VoteServiceImpl();
    //         default:
    //             return null;
    //     }
    // }

    /**
     *
     * @param className :接口子类名称(含路径)
     * @param clazz 指定接口类型，要用接口实例化Class
     * @param <T>  <T>T 为定义泛型数据类型
     * @return 返回指定接口的实例化对象
     */
    public static <T>T getInstance(String className, Class<T> clazz){
        T instance = null;
        try {
            instance = (T) Class.forName("zju.com.service." + className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

}
