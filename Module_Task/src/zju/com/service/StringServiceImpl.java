package zju.com.service;

/**
 * @Autor:godfu
 * @Date:2021/11/29-16:42
 */
public class StringServiceImpl implements IStringService{
    private StringBuffer sbf = new StringBuffer();

    @Override
    public void append(String str) {
        this.sbf.append(str).append("|");
    }

    @Override
    public String[] reverse() {
        String result[] = sbf.toString().split("\\|");
        //反转操作
        int center = result.length/2;
        int head = 0;
        int tail = result.length - 1;
        for (int i = 0; i < center; i++) {
            String temp = result[head];
            result[head] = result[tail];
            result[tail] = temp;
            head ++ ; tail --;
        }
        return result;
    }
}
