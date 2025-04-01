package com.bjpowernode.threadlocal;

/**
 * @ClassName TestThreadLocal
 * @Author Cat
 */
public class TestThreadLocal03 {

    public static final ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        //main线程
        local.set("main data");
        Service service = new Service();
        service.service();
    }
}