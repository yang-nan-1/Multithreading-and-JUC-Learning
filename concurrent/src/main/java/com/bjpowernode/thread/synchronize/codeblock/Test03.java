package com.bjpowernode.thread.synchronize.codeblock;

import com.bjpowernode.util.ThreadUtils;

public class Test03 {

    //new一个对象作为锁
    private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Test02 t1 = new Test02();
        Test02 t2 = new Test02();

        new Thread(() -> t1.eat2(), "t1").start();
        new Thread(() -> t2.eat2(), "t2").start();
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
}
