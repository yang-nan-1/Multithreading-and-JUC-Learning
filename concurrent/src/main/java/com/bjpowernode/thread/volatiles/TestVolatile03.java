package com.bjpowernode.thread.volatiles;

import com.bjpowernode.util.ThreadUtils;

/**
 * @ClassName TestVolatile03
 *
 * @Author Cat
 */
public class TestVolatile03 {

    //共享变量
    public volatile int num;

    public int count() {
        ThreadUtils.sleepMilliSeconds(200);
        return num++;
    }

    public static void main(String[] args) throws InterruptedException {
        TestVolatile03 test = new TestVolatile03();

        //t1线程
        Thread t1 = new Thread(() -> {
            test.count();
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            test.count();
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            test.count();
        });
        t3.start();

        //main线程
        ThreadUtils.sleep(3);
        System.out.println(test.num);
    }
}
