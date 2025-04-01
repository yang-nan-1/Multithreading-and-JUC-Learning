package com.bjpowernode.thread.synchronize.deadlock3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyMessage
 *
 * @Author Cat
 */
public class MyMessage {

    private ReentrantLock lock = new ReentrantLock();

    public void sendMessage(MyMessage message) {
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + "发送消息");
                message.log();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "未获取到锁sendMessage");
        }
    }

    public void log() {
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + "记录消息日志");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "未获取到锁log");
        }
    }
}
