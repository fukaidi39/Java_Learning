package zju.com.service;

import zju.com.util.InputUtil;

/**
 * @Autor:godfu
 * @Date:2021/11/28-22:31
 */
public class NumberServiceImpl implements INumberService{
    @Override
    public int[] statics(int count) {
        int result[] = new int[2];//保存结果
        int data[] = new int[count];//保存键入的数
        for (int i = 0; i < count; i++) {
            data[i] = InputUtil.getInt("请输入数字：");
        }
        result[0] = data[0];//最大值
        result[1] = data[0];//最小值
        for (int i = 0; i < count; i++) {
            if (data[i] >= result[0]){
                result[0] = data[i];
            }
            if(data[i] < result[1]){
                result[1] = data[i];
            }
        }
        return result;
    }

    @Override
    public int[] even_odd() {
        int result[] = new int[]{0,0};
        String str = InputUtil.getString("请输入一个数字字符串：");
        if(str.matches("\\d+")){
            String data[] = str.split("");//按照每个字符拆分
            for (int i = 0; i < data.length; i++) {
                int temp = Integer.parseInt(data[i]);
                if(temp % 2 == 1){//奇数
                    result[0] ++;
                }else{
                    result[1] ++;
                }
            }
        }else{
            result = this.even_odd();
        }
        return result;
    }
}
