package com.bjpowernode.threadlocal;

/**
 * @ClassName TestThreadLocal
 * @Author Cat
 */
public class  TestThreadLocal02 {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {

        //main线程
        //local.set("abc");

        //t1线程
        Thread t1 = new Thread(() -> {
            local.set("t1 data");
            System.out.println(Thread.currentThread().getName() + local.get());
        }, "t1线程");
        t1.start();

        //t2线程
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + local.get());
        }, "t2线程");
        t2.start();

        //System.out.println(Thread.currentThread().getName() + local.get());
    }
}