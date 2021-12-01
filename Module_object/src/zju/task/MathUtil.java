package zju.task;

import java.util.Random;

/**
 * @Autor:godfu
 * @Date:2021/11/22-10:02
 */
public class MathUtil {
    private static Random random = new Random();//定义静态常量属性
    /**
     * @param num:创建的随机数个数
     *       border:随机数的界限
     * @return:返回不为0的随机数组
     */
    public static int[] createRandom(int num, int border) {
        int data[] = new int[num];
        int foot = 0;
        while(foot < num){//不确定循环次数时用while
            int number = random.nextInt(border);
            if(number != 0){
                data[foot++] = number;
            }
        }
        return data;
    }

}
