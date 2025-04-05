package com.bjpowernode.object;

import com.bjpowernode.util.ThreadUtils;

/**
 * Object wait、notify、notifyAll方法
 *
 */
public class Test06 {

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            toWait();
        }).start();

        ThreadUtils.sleep(2);

        new Thread(() -> {
            toNotify();
        }).start();
    }

    public synchronized static void toWait() {
        while (i == 0) {
            try {
                System.out.println("等待开始......");
                Test06.class.wait();
                System.out.println("等待结束......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void toNotify() {
        System.out.println("唤醒它start......");
        Test06.class.notify();
        i = 1;
        System.out.println("唤醒它finished......");
    }
}