package com.bjpowernode.thread;

import com.bjpowernode.util.ThreadUtils;

/**
 * 认识一下Java线程：Java线程是开启了一条新的执行路径
 */
public class Test03 {

    /**
     * 写代码
     */
    public static void coding() {
        //for (;;) {
        for (int i = 0; i < 3; i++) {
            System.out.println("我正在写代码......");
            ThreadUtils.sleep(1);
        }
    }

    /**
     * 播放音乐
     */
    public static void playMusic() {
        //for (;;) {
        for (int i = 0; i < 3; i++) {
            System.out.println("我正在播放音乐......");
            ThreadUtils.sleep(1);
        }
    }


    public static void main(String[] args) { //main线程的虚拟机栈

        System.out.println("main方法执行开始.........");

        //coding();
        //playMusic();

        //我们想要让 “写代码” 和 “播放音乐” 同时执行，那么需要使用多线程
        new Thread( () -> coding() ).start(); //通过lambda方式创建线程  Thread-0线程的虚拟机栈

        new Thread( Test03 :: playMusic ).start(); //通过方法引用创建线程  第二期 源码分析专题 java8 Thread-1线程的虚拟机栈

        System.out.println("main方法执行结束.........");
    }
}