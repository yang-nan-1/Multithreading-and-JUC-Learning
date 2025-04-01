package com.bjpowernode.thread.synchronize.deadlock2;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName NewMessage
 *
 * @Author Cat
 */
public class NewMessage {

    private static Coordinator coordinator = new Coordinator();

    /**
     * 发送短信
     *
     * @param message
     */
    public void sendMessage(NewMessage message) {
        while (true) {
            boolean lock = coordinator.apply(this, message);
            if (lock) {
                try {
                    synchronized (this) {
                        System.out.println(Thread.currentThread().getName() + "发送消息");
                        message.log();
                    }
                } finally {
                    coordinator.free(this, message);
                }
                break; //退出循环
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 记录日志
     *
     */
    public void log() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "记录消息日志");
        }
    }
}
