package zju.reflection.autoset.util;

/**
 * @Autor:godfu
 * @Date:2021/12/2-14:17
 */
public class StringUtil {
    private StringUtil(){}//构造方法私有化

    /**
     * 实现字符串首字母转大写
     * @param str ：传入的字符串
     * @return：首字母大写的字符串
     */
    public static String initCap(String str){
        if(str == null || "".equals(str)){
            return str;
        }
        if(str.length() == 1){
            return str.toUpperCase();
        }else{
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
    }


}
