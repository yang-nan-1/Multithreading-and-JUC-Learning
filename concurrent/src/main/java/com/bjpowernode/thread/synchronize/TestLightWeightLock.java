package com.bjpowernode.thread.synchronize;

import org.openjdk.jol.info.ClassLayout;

public class TestLightWeightLock {

    private int id = 100;

    private int uid = 1001;

    private long no = 10893230588L;

    public static void main(String[] args) throws InterruptedException {
        TestLightWeightLock t = new TestLightWeightLock();
        System.out.println("------加锁前------");

        String classLayout = ClassLayout.parseInstance(t).toPrintable();
        System.out.println(classLayout);

        //加锁
        synchronized (t) {
            System.out.println("------加锁后------");

            String classLayoutAfter = ClassLayout.parseInstance(t).toPrintable();
            System.out.println(classLayoutAfter);

            System.out.println("------再次加锁后------");
            synchronized (t) {
                String classLayoutAgain = ClassLayout.parseInstance(t).toPrintable();
                System.out.println(classLayoutAgain);
            }
        }

        //synchronized释放锁了
        System.out.println("------synchronized执行完了，释放锁后------");
        String classLayoutFinal = ClassLayout.parseInstance(t).toPrintable();
        System.out.println(classLayoutFinal);
    }
}
