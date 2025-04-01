package com.bjpowernode.thread.synchronize.codeblock;

import com.bjpowernode.util.ThreadUtils;

public class Test05 {

    //new一个对象作为锁
    private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> eat(), "t1").start();
        new Thread(() -> eat(), "t2").start();
    }

    /*public synchronized static void eat() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }*/

    public static void eat() {

        synchronized (Test05.class) { //类锁
            while (true) {
                System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
                ThreadUtils.sleepMilliSeconds(300);
            }
        }
    }

    public static void eat2() {
        synchronized (Test05.class.getClass()) { //类锁
            while (true) {
                System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
                ThreadUtils.sleepMilliSeconds(300);
            }
        }
    }

    public void eat3() {
        synchronized (lock) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " 吃饭......" + System.currentTimeMillis());
                ThreadUtils.sleepMilliSeconds(300);
            }
        }
    }
}