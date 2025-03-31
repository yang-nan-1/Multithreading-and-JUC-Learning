package com.bjpowernode.threadlocal;

/**
 * @ClassName Dao
 * @Author Cat
 */
public class Dao {

    public void dao() {
        new Thread(() -> {
            String s = TestThreadLocal03.local.get();
            System.out.println("dao-->" + s);
        }).start();
    }
}