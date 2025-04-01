package com.bjpowernode.thread.safety;

import com.bjpowernode.util.ThreadUtils;

public class Test01 {

    public int num;

    public synchronized int count() {
        ThreadUtils.sleepMilliSeconds(200);
        return num++;
    }

    public static void main(String[] args) throws InterruptedException {
        Test01 test = new Test01();

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

        ThreadUtils.sleep(1);
        System.out.println(test.num);
    }
}
