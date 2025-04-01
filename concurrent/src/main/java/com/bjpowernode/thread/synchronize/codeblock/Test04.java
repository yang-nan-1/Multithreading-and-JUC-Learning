package com.bjpowernode.thread.synchronize.codeblock;

import com.bjpowernode.util.ThreadUtils;

public class Test04 {

    //new一个对象作为锁
    private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Test04 t1 = new Test04();
        Test04 t2 = new Test04();

        new Thread(() -> t1.eat(), "t1").start();
        new Thread(() -> t1.work(), "t1").start();

        new Thread(() -> t2.eat(), "t2").start();
        new Thread(() -> t2.work(), "t2").start();
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

    public void work() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 工作......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }
}
