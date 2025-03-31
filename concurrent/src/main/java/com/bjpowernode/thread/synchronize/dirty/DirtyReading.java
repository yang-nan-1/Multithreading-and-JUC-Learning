package com.bjpowernode.thread.synchronize.dirty;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DirtyReading
 *
 * @Author Cat
 */
public class DirtyReading {

    public static void main(String[] args) throws InterruptedException {
        //账户
        Account account = new Account();

        //3个线程
        new Thread(() -> account.transfer("zhangsan",100.0)).start();
        new Thread(() -> account.transfer("zhangsan",100.0)).start();
        new Thread(() -> account.transfer("zhangsan",100.0)).start();

        //1个main线程
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //100ms之后查看余额为0，main线程
        System.out.println(account.showBalance("zhangsan")); //脏读  0.0

        /*if ( <= 0) {
            //执行业务。那业务就出错了
        }*/

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //3000ms即3秒之后查看余额
        System.out.println(account.showBalance("zhangsan")); //300.0
    }

    /**
     * 用户账户
     */
    static class Account {

        //卡的持有人
        private String name;

        //卡的余额
        private volatile double balance;

        /**
         * 转账
         *
         * @param name
         * @param balance
         */
        public synchronized void transfer(String name, double balance){
            this.name = name;
            try {
                //模拟转账耗时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.balance += balance;
        }

        /**
         * 显示余额
         *
         * @param name
         * @return
         */
        public synchronized double showBalance(String name){
            return this.balance;
        }
    }
}