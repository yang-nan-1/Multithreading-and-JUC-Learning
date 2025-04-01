package com.bjpowernode.thread.synchronize.deadlock2;

/**
 * @ClassName Test
 *
 * @Author Cat
 */
public class TestDeadLock2 {

    public static void main(String[] args) {
        NewMessage message1 = new NewMessage();
        NewMessage message2 = new NewMessage();

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
