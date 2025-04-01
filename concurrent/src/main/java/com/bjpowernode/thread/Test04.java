package com.bjpowernode.thread;

public class Test04 {

    public static void main(String[] args) {
        //线程start()后，具体要运行什么业务逻辑呢？
        //线程Thread，有一个run()方法，要覆盖这个run方法
        //start()方法就会新建一个线程并让这个线程执行run()方法
        Thread thread = new Thread(); //没有覆盖run方法，什么事情都不会做
        thread.start();

        //下面的代码也能正常执行。但是不能新建一个线程，而是在当前线程中调用run()方法，只是作为一个普通的方法调用而已
        Thread t2 = new Thread();
        t2.run(); //没有启动线程
    }
}
