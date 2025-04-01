package com.bjpowernode.thread;

/**
 * 线程Priority
 *
 */
public class Test15 {

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "......" + i);
            }
        }, "t1线程");
        t1.setPriority(2); // 取值是 1 - 10；
        t1.start();

        Thread t2 = new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "......" + i);
            }
        }, "t2线程");
        t2.setPriority(8);
        t2.start();
    }
}