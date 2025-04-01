package com.bjpowernode.thread;

import com.bjpowernode.util.ThreadUtils;

/**
 * Java main线程执行结束后，在main线程中创建的子线程是否也自动结束？
 *
 * 守护线程
 *
 */
public class Test09 {

    /**
     * 写代码
     */
    public static void coding() {
        for (int i=0; i<15; i++) {
            System.out.println("我正在写代码......");
            ThreadUtils.sleep(1);
        }
    }

    /**
     * 播放
     */
    public static void play() {
        for (;;) {
            System.out.println("我正在播放音乐......");
            ThreadUtils.sleep(1);
        }
    }

    public static void main(String[] args) {

        System.out.println("main方法执行start.........");

        Thread t1 = new Thread( () -> coding() ); //通过lambda方式创建线程
        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread( () -> play() ); //通过lambda方式创建线程
        t2.start();

        System.out.println("main方法执行end.........");

        //普通线程（非守护线程、用户线程） 和 守护线程(后台线程)
    }
}