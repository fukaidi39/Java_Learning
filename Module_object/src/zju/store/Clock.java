package zju.store;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Autor:godfu
 * @Date:2021/11/20-14:11
 */
//定义任务主体
class myTimer extends TimerTask{
    //多线程处理方法
    @Override
    public void run() {
        String clock = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(Thread.currentThread().getName()+"定时任务执行，当前的时间是"+ clock);
    }
}
public class Clock {
    public static void main(String[] args) {
        Timer timer = new Timer();//定时任务
        //定义间隔任务，每秒执行一次
        timer.scheduleAtFixedRate(new myTimer(),1000,1000);
    }
}
