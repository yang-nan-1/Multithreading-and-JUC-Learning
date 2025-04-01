package com.bjpowernode.thread.state;

import com.bjpowernode.util.ThreadUtils;

/**
 * 线程6种状态
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test03 {

    public static void main(String[] args) throws InterruptedException {
        //RUNNABLE （包括 “就绪” 和 “运行” 两种状态）
        Thread t = new Thread(() -> {
            while (true) {
                //Thread.yield();
                //System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
            }
        }, "t线程");
        t.start();
        ThreadUtils.sleep(1);
        System.out.println(t.getName() + ": " + t.getState());
    }
}