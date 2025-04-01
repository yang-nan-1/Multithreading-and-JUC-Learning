package com.bjpowernode.thread;

import com.bjpowernode.util.ThreadUtils;

/**
 * 线程join
 *
 */
public class Test10 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main线程执行...start..." + Thread.currentThread().getName());

        Thread t = new Thread( () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("VIP线程来了......" + i);
                ThreadUtils.sleep(1);
            }
        });
        t.start();

        //线程加入，线程插队，线程合并
        //当t执行完成，才会把cpu执行权交出来，main线程才会继续往下执行，如果t没有执行完，main就不会往下执行，相当于t线程强行插队了
        //join方法就是等待这个线程执行结束
        //常用于 一个线程需要另一个线程的结果时
        //thread.join();

        //main线程
        for (int i = 0; i < 20; i++) {
            System.out.println("main线程执行：" + i);
            if (i == 10) {
                t.join(); //强行插队
            }
        }

        System.out.println("main线程执行...end..." + Thread.currentThread().getName());
    }
}