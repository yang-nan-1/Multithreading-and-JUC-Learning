package com.bjpowernode.thread.synchronize.deadlock;

/**
 * @ClassName TestDeadLock2
 *
 * @Author Cat
 */
public class TestDeadLock2 {

    public static void main(String[] args) {
        Message message1 = new Message();
        Message message2 = new Message();

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
