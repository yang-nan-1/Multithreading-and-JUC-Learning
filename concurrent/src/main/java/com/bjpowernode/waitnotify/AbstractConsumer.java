package com.bjpowernode.waitnotify;

/**
 * 消费者
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public abstract class AbstractConsumer implements Runnable {

    /**
     * 模板方法
     * 
     */
    @Override
    public final void run() {
        while (true) {
            //消费
            consume();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void consume();

}