package com.bjpowernode.thread.synchronize.deadlock3;

/**
 * @ClassName Test
 *
 * @Author Cat
 */
public class TestDeadLock3 {

    public static void main(String[] args) {
        MyMessage message1 = new MyMessage();
        MyMessage message2 = new MyMessage();

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
