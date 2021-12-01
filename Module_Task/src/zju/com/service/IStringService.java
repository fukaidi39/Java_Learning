package zju.com.service;

/**
 * @Autor:godfu
 * @Date:2021/11/29-16:40
 */
public interface IStringService {
    /**
     * 实现追加数据
     * @param str 附加的字符串
     */
    public void append(String str);

    /**
     * 对字符串进行反转
     * @return 反转后的结果
     */
    public String[] reverse();
}
