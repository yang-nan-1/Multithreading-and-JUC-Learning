package com.bjpowernode.thread.state;

/**
 * 线程6种状态
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Test01 {

    public static void main(String[] args) throws InterruptedException {
        //NEW 状态
        Thread t1 = new Thread("t1线程");
        System.out.println(t1.getName() + ": " + t1.getState());
    }
}