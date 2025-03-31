package com.bjpowernode.thread.synchronize;

import com.bjpowernode.util.ThreadUtils;

public class Cat {

    public synchronized static void eat() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " Cat吃饭......" + System.currentTimeMillis());
            ThreadUtils.sleepMilliSeconds(300);
        }
    }
}
