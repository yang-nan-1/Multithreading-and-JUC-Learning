package com.bjpowernode.thread.synchronize;

import org.openjdk.jol.info.ClassLayout;

/**
 * JOL
 *
 */
public class TestJOL {

    private int id = 100;

    private int uid = 1001;

    private long no = 10893230588L;

    public static void main(String[] args) throws InterruptedException {
        TestJOL t = new TestJOL();

        String classLayout = ClassLayout.parseInstance(t).toPrintable();
        System.out.println(classLayout);
    }
}