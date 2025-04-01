package com.bjpowernode.threadlocal;

/**
 * @ClassName Service
 * @Author Cat
 */
public class Service {

    public void service() {
        String s = TestThreadLocal03.local.get();
        System.out.println("service-->" + s);
        Dao dao = new Dao();
        dao.dao();
    }
}