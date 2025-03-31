package com.bjpowernode.threadpool.size;

public class IOTask2 {

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            new Thread(() -> {
                for (long j = 0; j < 50000000000L; j++) {
                    if (j % 5000000 == 0) {
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}