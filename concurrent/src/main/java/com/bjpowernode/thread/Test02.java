package com.bjpowernode.thread;

import com.bjpowernode.util.ThreadUtils;

/**
 * 能创建多少个线程
 *
 */
public class Test02 {

    public static void main(String[] args) {
        int i = 0;
        while (true) {
            new Thread( () -> ThreadUtils.sleep(60*10) ).start();
            i++;
            System.out.println(i);
        }
    }
}
