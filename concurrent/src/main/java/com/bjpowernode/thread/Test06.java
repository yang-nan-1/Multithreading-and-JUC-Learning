package com.bjpowernode.thread;

/**
 * 当前线程
 *
 */
public class Test06 {

    /**
     * 写代码
     */
    public static void logging() {
        System.out.println("记录日志......" + Thread.currentThread().getName()); // this
    }

    public static void main(String[] args) {
        System.out.println("main方法........." + Thread.currentThread().getName());

        //通过lambda方式创建线程
        Thread thread = new Thread(() -> logging());
        thread.start();

        Thread thread2 = new Thread(() -> logging());
        thread2.start();
    }
}