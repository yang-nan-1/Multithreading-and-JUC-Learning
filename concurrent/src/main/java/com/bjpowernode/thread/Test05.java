package com.bjpowernode.thread;

import com.bjpowernode.util.ThreadUtils;

/**
 * 线程不能二次启动
 *
 */
public class Test05 {

    /**
     * 写代码
     */
    public static void logging() {
        System.out.println("记录日志......");
    }

    public static void main(String[] args) {

        System.out.println("main方法执行.........");

        //通过lambda方式创建线程
        Thread thread = new Thread(() -> logging());
        thread.start();

        ThreadUtils.sleep(2);

        //再次start （不允许）
        thread.start();
    }
}