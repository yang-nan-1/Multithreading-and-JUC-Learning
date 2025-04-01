package com.bjpowernode.thread.synchronize.codeblock;

import com.bjpowernode.util.ThreadUtils;

public class Test02 {

    //new一个对象作为锁
    private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Test02 t = new Test02();

        new Thread(() -> t.eat2(), "t1").start();
        new Thread(() -> t.eat2(), "t2").start();
    }

    //同步方法
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

    //非同步方法
    public void work() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 工作......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }
}
