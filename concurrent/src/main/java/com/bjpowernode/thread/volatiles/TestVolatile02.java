package com.bjpowernode.thread.volatiles;

/**
 * @ClassName TestVolatile02
 *
 * @Author Cat
 */
public  class TestVolatile02 {

    //类变量
    volatile private   static     int a = 10;
    //实例变量
    volatile private   int b = 10;

    /*static {
        volatile int x = 10;
    }*/

    /*{
        volatile int y = 10;
    }*/

    //类常量
    public static final int m = 10;
    //实例常量
    public final int n = 10;

    public void doSomeThing(int x) {
        String str = "Java";
    }
}
