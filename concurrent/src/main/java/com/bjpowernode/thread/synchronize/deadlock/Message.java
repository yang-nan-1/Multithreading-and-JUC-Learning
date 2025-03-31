package com.bjpowernode.thread.synchronize.deadlock;

/**
 * @ClassName Message
 *
 * @Author Cat
 */
public class Message {

    public void sendMessage(Message message) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "发送消息");
            message.log();
        }
    }

    public void log() {
        synchronized (this) {
            System.out.println("记录消息日志");
        }
    }
}
