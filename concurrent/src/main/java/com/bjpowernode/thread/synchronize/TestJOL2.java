package com.bjpowernode.thread.synchronize;

import org.openjdk.jol.info.ClassLayout;

/**
 * JOL
 *
 */
public class TestJOL2 {

    private int id = 100;

    private int uid = 1001;

    private long no = 10893230588L;

    public static void main(String[] args) throws InterruptedException {
        TestJOL2 t = new TestJOL2();
        //加锁
        synchronized (t) {
            String classLayout = ClassLayout.parseInstance(t).toPrintable();
            System.out.println(classLayout);
        }
    }
}