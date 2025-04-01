package com.bjpowernode.thread.synchronize;

import com.bjpowernode.util.ThreadUtils;

/**
 * 两个线程同时访问两个对象的同步方法，不互斥；
 *
 */
public class Test03 {

    public static void main(String[] args) throws InterruptedException {
        Test03 t1 = new Test03();
        Test03 t2 = new Test03();

        new Thread(() -> t1.eat(), "t1").start();
        new Thread(() -> t2.eat(), "t2").start();
    }

    //同步方法
    public synchronized void eat() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }
}
