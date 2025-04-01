package com.bjpowernode.thread.synchronize;

import com.bjpowernode.util.ThreadUtils;

/**
 * 两个线程同时访问同一个类的静态同步方法和静态非同步方法，不互斥；
 *
 */
public class Test07 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> eat(), "t1").start();
        new Thread(() -> work(), "t2").start();
    }

    public synchronized static void eat() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }

    public static void work() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 工作......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }
}