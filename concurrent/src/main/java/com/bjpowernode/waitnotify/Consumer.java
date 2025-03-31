package com.bjpowernode.waitnotify;

/**
 * 消费者
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class Consumer extends  AbstractConsumer {

    private DataBuffer dataBuffer;

    /**
     * 通过构造方法把dataBuffer初始化
     *
     * @param dataBuffer
     */
    public Consumer(DataBuffer dataBuffer) {
        this.dataBuffer = dataBuffer;
    }

    @Override
    protected void consume() {

        synchronized (dataBuffer.getDataBuffer()) {
            //如果缓存区是空的，就需要等待
            while (dataBuffer.getDataBuffer().isEmpty()) {
                try {
                    System.out.println("缓存区空了，消费者阻塞等待......");
                    dataBuffer.getDataBuffer().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //消费数据
            Integer number = dataBuffer.getDataBuffer().remove(0);
            System.out.println("消费者消费了一条数据......" + number);

            //通知一下生产者，可以继续生产
            dataBuffer.getDataBuffer().notifyAll();
        }
    }
}
