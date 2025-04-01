package com.bjpowernode.thread.synchronize;

import com.bjpowernode.util.ThreadUtils;

/**
 * 两个线程同时访问同一个对象的同步方法，会互斥；
 *
 */
public class Test01 {

    public static void main(String[] args) throws InterruptedException {
        Test01 test01 = new Test01();

        new Thread(() -> test01.eat(), "t1").start();
        new Thread(() -> test01.eat(), "t2").start();
    }

    //对象锁
    public synchronized void eat() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }
}
