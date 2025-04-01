package com.bjpowernode.thread.state;

import com.bjpowernode.util.ThreadUtils;

/**
 * 线程6种状态
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test02 {

    public static void main(String[] args) throws InterruptedException {

        //TERMINATED 终止状态
        /*Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "运行");
        }, "t1线程");
        t1.start();*/

        Thread t1 = new Thread(() -> {
            while (true) {
                //System.out.println(Thread.currentThread().getName() + "运行");
            }
        }, "t1线程");
        t1.start();

        ThreadUtils.sleep(2);
        System.out.println(t1.getName() + ": " + t1.getState());
    }
}