package com.bjpowernode.waitnotify;

/**
 * 生产者 (模板方法模式实现)
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public abstract class AbstractProducer implements Runnable {

    /**
     * 模板方法
     *
     */
    @Override
    public final void run() {
        while (true) {
            //生产
            produce();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void produce();
}
