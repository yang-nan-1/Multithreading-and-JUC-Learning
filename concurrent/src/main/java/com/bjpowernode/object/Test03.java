package com.bjpowernode.object;

import com.bjpowernode.util.ThreadUtils;

/**
 * Object wait、notify、notifyAll方法
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test03 {

    private static final Object MONITOR = new Object();

    private static int i = 0;

    public static void main(String[] args) {

        //第一个线程 t1
        Thread t1 = new Thread(() -> {
            synchronized (MONITOR) {
                while (i == 0) {
                    try {
                        MONITOR.wait();
                        System.out.println("t1等待结束......");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        ThreadUtils.sleep(1);

        //第二个线程 t2
        Thread t2 = new Thread(() -> {
            synchronized (MONITOR) {
                while (i == 0) {
                    try {
                        MONITOR.wait();
                        System.out.println("t2等待结束......");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();

        ThreadUtils.sleep(1);

        //main线程
        synchronized (MONITOR) {
            //MONITOR.notify(); //notify方法只能通知一个线程
            MONITOR.notifyAll(); //notify方法通知所有线程
            i = 1;
        }
    }
}