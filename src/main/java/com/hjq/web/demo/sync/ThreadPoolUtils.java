package com.hjq.web.demo.sync;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author hjq
 * @Date 2019/4/12 15:04
 **/
public class ThreadPoolUtils {


    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static ExecutorService singlethreadPool = Executors.newSingleThreadExecutor();
    private static ExecutorService scheduledthreadPool = Executors.newScheduledThreadPool(20);
    private static ExecutorService threadPool = Executors.newFixedThreadPool(20);

    private static int ticket = 0;

    public static void main(String[] args) {


        //信号量
        final Semaphore semaphore = new Semaphore(5);
        //障碍点，即必须等到指定的线程执行后，才可下一步执行
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        //计数器
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        //交换
        final Exchanger<String> exchanger = new Exchanger<String>();


        for (int i = 1; i <= 10; ++i) {
            final int num = i;
            cachedThreadPool.execute(new SemaphoreTest(semaphore,num));
        }

        cachedThreadPool.shutdown();

    }

    private static void add() {
        ticket++;
    }


}

/**
 * semaphore
 */
class SemaphoreTest implements Runnable {


    private int userNo;

    private Semaphore semaphore;

    public SemaphoreTest(Semaphore semaphore, int userNo) {
        this.userNo = userNo;
        this.semaphore = semaphore;
    }


    @Override
    public void run() {

        try {
            //获取许可证
            semaphore.acquire();
            System.out.println("用户" + userNo + "进入");
            System.out.println("用户" + userNo + "正在办理业务------");
            Thread.sleep(3000);

            System.out.println("用户" + userNo + "离开");
            //释放锁
            semaphore.release();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
