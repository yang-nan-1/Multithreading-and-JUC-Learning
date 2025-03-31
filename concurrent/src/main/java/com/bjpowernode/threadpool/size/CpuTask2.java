package com.bjpowernode.threadpool.size;

public class CpuTask2 {

    public static void main(String[] args) throws InterruptedException {
        //会将2核的CPU使用率达到100%
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                //循环，什么都不做
                for (long j = 0; j < 50000000000L; j++) {

                }
            }).start();
        }
    }
}