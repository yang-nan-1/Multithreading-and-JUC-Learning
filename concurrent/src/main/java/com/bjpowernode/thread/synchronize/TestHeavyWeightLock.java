package com.bjpowernode.thread.synchronize;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class TestHeavyWeightLock {

    public static void main(String[] args) throws InterruptedException {
        TestHeavyWeightLock t = new TestHeavyWeightLock();
        System.out.println("------加锁前------");

        String classLayout = ClassLayout.parseInstance(t).toPrintable();
        System.out.println(classLayout);

        //创建一个线程
        Thread t1 = new Thread(() -> {
            synchronized (t) {
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1线程执行......");
            }
        });
        t1.start();

        //main线程休眠500毫秒，确保t1线程已经开始执行
        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println("t1线程已经抢占到了t对象的锁，输出t对象的内存布局：");
        String syncClassLayout = ClassLayout.parseInstance(t).toPrintable();
        System.out.println(syncClassLayout);

        //main线程抢占t对象的锁
        synchronized (t) {
            System.out.println("------main线程抢占到了t对象的锁------");

            String classLayoutAfter = ClassLayout.parseInstance(t).toPrintable();
            System.out.println(classLayoutAfter);
        }
    }
}
