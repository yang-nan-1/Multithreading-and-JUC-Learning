package com.bjpowernode.thread.state;

import com.bjpowernode.util.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程6种状态
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test06 {

    private final static Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        //TIMED_WAITING 超时等待
        /*Thread t = new Thread(() -> {
            ThreadUtils.sleep(3);
        }, "t线程");
        t.start();

        ThreadUtils.sleep(1);
        System.out.println(t.getName() + ": " + t.getState());*/

        //-----------------------------------

        /*Thread t2 = new Thread(() -> {
            synchronized (MONITOR) {
                try {
                    MONITOR.wait(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2线程");
        t2.start();

        ThreadUtils.sleep(1);
        System.out.println(t2.getName() + ": " + t2.getState());*/

        //-----------------------------------------

        /*Thread t3 = new Thread(() -> {
            while (true) {

            }
        }, "t3线程");
        t3.start();
        ThreadUtils.sleep(1);

        //WAITING 等待
        Thread t4 = new Thread(() -> {
            try {
                //等待t3线程完成
                t3.join(3000L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t4线程");
        t4.start();
        ThreadUtils.sleep(1);
        System.out.println(t4.getName() + ": " + t4.getState());*/

        //---------------------------------------

        Thread t5 = new Thread(() -> {
            //LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(3));
            LockSupport.parkUntil(System.currentTimeMillis() + 3000);
        }, "t5线程");
        t5.start();
        ThreadUtils.sleep(1);
        System.out.println(t5.getName() + ": " + t5.getState());
    }
}