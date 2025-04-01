package com.bjpowernode.thread.state;

import com.bjpowernode.util.ThreadUtils;

/**
 * 线程6种状态
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test05 {

    private final static Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            synchronized (MONITOR) {
                try {
                    MONITOR.wait();
                    while (true) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t线程");
        t.start();

        ThreadUtils.sleep(1);
        System.out.println(t.getName() + ": " + t.getState()); //waiting


        //main线程
        synchronized (MONITOR) {
            MONITOR.notify();
        }
        ThreadUtils.sleep(1);
        System.out.println(t.getName() + ": " + t.getState()); //runnable

        //-------------------------------------------------------

        //RUNNABLE （包括 “就绪” 和 “运行” 两种状态）
        /*Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("执行: " + i);
                ThreadUtils.sleep(1);
            }
        }, "t1线程");
        t1.start();
        ThreadUtils.sleep(1);

        //WAITING 等待
        Thread t2 = new Thread(() -> {
            try {
                //等待t1线程完成
                t1.join();
                System.out.println(Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2线程");
        t2.start();
        ThreadUtils.sleep(6);
        System.out.println(t2.getName() + ": " + t2.getState());*/

        //-------------------------------------------------------

        /*Thread t3 = new Thread(() -> {
            LockSupport.park();
            System.out.println(Thread.currentThread().getState());
        }, "t3线程");
        t3.start();
        ThreadUtils.sleep(1);
        LockSupport.unpark(t3);
        ThreadUtils.sleep(1);
        System.out.println(t3.getName() + ": " + t3.getState());*/
    }
}