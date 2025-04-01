package com.bjpowernode.thread.synchronize;

import com.bjpowernode.util.ThreadUtils;

/**
 * 两个线程同时访问不同类的静态同步方法，不互斥；
 *
 */
public class Test06 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> eat(), "t1").start();
        new Thread(() -> Cat.eat(), "t2").start();
    }

    public synchronized static void eat() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }
}