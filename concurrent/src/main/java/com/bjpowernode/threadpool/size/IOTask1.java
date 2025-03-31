package com.bjpowernode.threadpool.size;

public class IOTask1 {

    public static void main(String[] args) {
        for (long i = 0; i < 50000000000L; i++) {
            if (i % 5000000 == 0) {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
