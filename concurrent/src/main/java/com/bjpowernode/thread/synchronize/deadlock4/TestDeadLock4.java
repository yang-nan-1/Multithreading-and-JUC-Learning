package com.bjpowernode.thread.synchronize.deadlock4;

/**
 * @ClassName Test
 *
 * @Author Cat
 */
public class TestDeadLock4 {

    public static void main(String[] args) {
        OurMessage message1 = new OurMessage();
        OurMessage message2 = new OurMessage();

        Thread t1 = new Thread(() -> {
            message1.sendMessage(message2);
        }, "t1");

        Thread t2 = new Thread(() -> {
            message2.sendMessage(message1);
        }, "t2");

        t1.start();
        t2.start();
    }
}
