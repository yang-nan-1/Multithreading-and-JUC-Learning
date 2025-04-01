package com.bjpowernode.thread.safety;

import com.bjpowernode.util.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test02 {

    public int num;

    public int count() {
        ThreadUtils.sleepMilliSeconds(50);
        return num++;
    }

    public static void main(String[] args) throws InterruptedException {
        Test02 test = new Test02();
        //ExecutorService executorService = Executors.newFixedThreadPool(16);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                test.count();
            });
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("--" + test.num);
        }
        System.out.println("最终--" + test.num);
        System.out.println("执行结束");
    }
}
