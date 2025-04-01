package com.bjpowernode.thread.synchronize;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁
 *
 */
public class TestBiasedLock {

    private int id = 100;

    private int uid = 1001;

    private long no = 10893230588L;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(6000);

        TestBiasedLock t = new TestBiasedLock();
        System.out.println("------加锁前------");

        String classLayout = ClassLayout.parseInstance(t).toPrintable();
        System.out.println(classLayout);

        //加锁
        synchronized (t) {
            System.out.println("------加锁后------");
            String classLayoutAfter = ClassLayout.parseInstance(t).toPrintable();
            System.out.println(classLayoutAfter);
        }
    }
}