package zju.task;

import java.util.Random;

/**
 * @Autor:godfu
 * @Date:2021/11/22-10:51
 */
class Coin {
    private int front;//正面朝上次数
    private int back ;//反面朝上次数
    private static Random random = new Random();

    /**
     * 模拟抛硬币
     * @param num：总共抛硬币的次数
     */
    public void throwCoin(int num){
        int count = 0;
        while(count < num){
            int data = random.nextInt(2);
            if(data == 0){
                front ++;
                count ++;
            }else{
                back ++;
                count ++;
            }
        }
    }
    public int getFront(){
        return front;
    }
    public int getBack(){
        return back;
    }
}
