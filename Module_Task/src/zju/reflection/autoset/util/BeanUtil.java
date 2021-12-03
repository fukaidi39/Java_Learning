package zju.reflection.autoset.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Autor:godfu
 * @Date:2021/12/2-14:19
 */
public class BeanUtil {
    private BeanUtil(){}
    public static void setValue(Object obj, String value){
        String results[] = value.split("\\|");
        for (int i = 0; i < results.length; i++) {
            //data[0]保存属性类型，data[1]保存属性内容
            String data[] = results[i].split(":");
            try {
                //多级配置，首先实例化多级对象
                if(data[0].contains(".")){
                    String temp[] = data[0].split("\\.");
                    Object currentObj = obj;
                    for (int j = 0; j < temp.length - 1; j++) {//一级级实例化对象，最后一位是属性名称，不考虑
                        //调用getter方法判断是否实例化对象了
                        Method getMethod = currentObj.getClass().getDeclaredMethod("get"+ StringUtil.initCap(temp[j]));
                        //getter调用的对象
                        Object tempObject = getMethod.invoke(currentObj);
                        if (tempObject == null){//该对象没有实例化
                            Field field = currentObj.getClass().getDeclaredField(temp[j]);//获取对应属性类型
                            //调用setter方法
                            Method setMethod = currentObj.getClass().getDeclaredMethod("set"+StringUtil.initCap(temp[j]),field.getType());
                            //用object类型接受实例化对象
                            Object newInstance = field.getType().getDeclaredConstructor().newInstance();
                            setMethod.invoke(currentObj, newInstance);
                            currentObj = newInstance;
                        }else{//已经实例化，继续下一级
                            currentObj = tempObject;
                        }
                    }
                    //此时的currentObj应该指向最后一级的对象,可以进行属性内容的设置
                    Field field = currentObj.getClass().getDeclaredField(temp[temp.length - 1]);
                    Method setMethod = currentObj.getClass().getDeclaredMethod("set"+StringUtil.initCap(temp[temp.length -1]),field.getType());
                    Object convertValue = BeanUtil.convertAttributeValue(field.getType().getSimpleName(), data[1]);
                    setMethod.invoke(currentObj, convertValue);
                }else{//单级配置
                    Field field = obj.getClass().getDeclaredField(data[0]);//定义属性对象
                    Method setMethod = obj.getClass().getDeclaredMethod("set" + StringUtil.initCap(data[0]),field.getType());//定义方法对象(方法名+参数属性)
                    // 利用Object来接收所有类型的数据
                    Object convertValue = BeanUtil.convertAttributeValue(field.getType().getSimpleName(), data[1]);
                    setMethod.invoke(obj, convertValue);//调用类中setter方法来设置内容
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现属性类型的转换的功能
     * @param type ：要转换的属性类型，通过Field属性对象获取
     * @param value ：属性的内容，传入的都是字符串，将其转换为指定类型
     * @return：转换后的数据
     */
    public static Object convertAttributeValue(String type,String value){
        if("long".equals(type)){//转换为Long类型
            return Long.parseLong(value);
        }else if("int".equals(type)){//转换int类型
            return Integer.parseInt(value);
        }else if("Date".equals(type)){//转换为Date类型
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();
            }
        }else {//返回字符串
            return value;
        }
    }

}
