package zju.com.service;

/**
 * @Autor:godfu
 * @Date:2021/11/28-22:31
 */
public interface INumberService {
    /**
     * 返回键入数的最大值与最小值
     * @param count：键入的总数
     * @return 最大值与最小值
     */
    public int[] statics(int count);

    /**
     * 统计键入字符串中数字的奇数与偶数个数
     * @return 奇数与偶数个数
     */
    public int[] even_odd();
}
