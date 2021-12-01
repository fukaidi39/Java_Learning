package zju.com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Autor:godfu
 * @Date:2021/11/16-18:30
 */
class Mythread implements Callable<String>{
    private static boolean flag = false;
    @Override
    public String call() throws Exception {
        synchronized (this){//同步
            while (this.flag == false){
                this.flag = true;
                return Thread.currentThread().getName()+":抢答成功";
            }
                return Thread.currentThread().getName()+":抢答失败";
        }
    }
}
public class Competitor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> fskA = new FutureTask<String>(new Mythread());
        FutureTask<String> fskB = new FutureTask<String>(new Mythread());
        FutureTask<String> fskC = new FutureTask<String>(new Mythread());
        new Thread(fskA,"线程A").start();
        new Thread(fskB,"线程B").start();
        new Thread(fskC,"线程C").start();
        System.out.println(fskA.get());
        System.out.println(fskB.get());
        System.out.println(fskC.get());
    }
}
