package com.bjpowernode.thread.state;

import com.bjpowernode.util.ThreadUtils;

/**
 * 线程6种状态
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test07 {

    public static void main(String[] args) throws InterruptedException {

        //BLOCKED 阻塞
        /*Thread t1 = new Thread(() -> {
            synchronized (Test07.class) {
                ThreadUtils.sleep(300);
            }
        }, "t1线程");
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (Test07.class) {
                ThreadUtils.sleep(300);
            }
        }, "t2线程");
        t2.start();
        ThreadUtils.sleep(1);
        System.out.println(t2.getName() + ": " + t2.getState());*/

        //------------------------------------------------------

        Test07 test07 = new Test07();

        Thread t3 = new Thread(() -> {
            test07.sync1();
        }, "t3线程");
        t3.start();
        System.out.println(t3.getName() + ": " + t3.getState());

        ThreadUtils.sleep(1);

        Thread t4 = new Thread(() -> {
            test07.sync2();
        }, "t4线程");
        t4.start();
        ThreadUtils.sleep(1);
        System.out.println(t4.getName() + ": " + t4.getState());
    }

    public synchronized void sync1() {
        System.out.println("正在执行sync方法...........");
        ThreadUtils.sleep(30);
    }

    public synchronized void sync2() {
        System.out.println("正在执行sync2方法...........");
        ThreadUtils.sleep(300);
    }
}