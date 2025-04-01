package com.bjpowernode.threadlocal;

/**
 * @ClassName TestThreadLocal
 * @Author Cat
 */
public class TestThreadLocal {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    private static final ThreadLocal<Integer> local2 = ThreadLocal.withInitial(() -> {
        return 123;
    });

    private static final ThreadLocal<String> local3 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "cat";
        }
    };

    public static void main(String[] args) {
        local.set("abc");
        local.set("xyz");
        local.remove();
        String s = local.get();
        System.out.println(s);

        System.out.println("------------------------");
        System.out.println(local2.get());
        System.out.println(local3.get());
    }
}