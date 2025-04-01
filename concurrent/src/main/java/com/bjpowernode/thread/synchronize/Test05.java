package com.bjpowernode.thread.synchronize;

import com.bjpowernode.util.ThreadUtils;

/**
 * 两个线程同时访问同一个类的静态同步方法，会互斥；
 *
 */
public class Test05 {

    //Test05.class --> Class

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> eat(), "t1").start();
        new Thread(() -> eat(), "t2").start();
    }

    public synchronized static void eat() { //静态方法+synchronized=类锁
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }
}