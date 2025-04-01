package com.bjpowernode.thread.synchronize;

import com.bjpowernode.util.ThreadUtils;

/**
 * 两个线程同时访问同一个对象的同步方法和非同步方法，不互斥；
 */
public class Test02 {

    public static void main(String[] args) throws InterruptedException {
        Test02 t = new Test02();

        new Thread(() -> t.eat(), "t1").start();
        new Thread(() -> t.work(), "t2").start();
    }

    //同步方法
    public synchronized void eat() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }

    //非同步方法
    public void work() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 工作......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }
}
