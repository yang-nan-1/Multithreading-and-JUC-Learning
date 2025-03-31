package com.bjpowernode.threadpool.size;

public class CpuTask1 {

    public static void main(String[] args) {
        // 会将2核的CPU交替出现其中一个CPU使用率达到100%
        for (long i = 0; i < 50000000000L; i++) {

        }
    }
}