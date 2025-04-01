package com.bjpowernode.thread.synchronize.codeblock;

import com.bjpowernode.util.ThreadUtils;

public class Test01 {

    //new一个对象作为锁
    private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Test01 test01 = new Test01();

        new Thread(() -> test01.eat2(), "t1").start();
        new Thread(() -> test01.eat2(), "t2").start();
    }

    /*public synchronized void eat() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }*/

    public void eat() {
        synchronized (this) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
                ThreadUtils.sleepMilliSeconds(300);
            }
        }
    }

    public void eat2() {
        synchronized (lock) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
                ThreadUtils.sleepMilliSeconds(300);
            }
        }
    }
}
