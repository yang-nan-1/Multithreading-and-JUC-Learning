package com.bjpowernode.thread.synchronize.deadlock4;

/**
 * @ClassName OurMessage
 *
 * @Author Cat
 */
public class OurMessage {

    public void sendMessage(OurMessage message) {
        //通过hash值比较，得到一个顺序，
        // message1: 1598924227
        // message2: 1144748369
        OurMessage lock = this.hashCode()>message.hashCode() ? this : message;

        synchronized (lock) {
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
