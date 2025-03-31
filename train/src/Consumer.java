public class Consumer extends AbstractConsumer{
    private DataBuffer dataBuffer;

    public Consumer(DataBuffer dataBuffer) {
        this.dataBuffer = dataBuffer;
    }

    @Override
    protected void consume() {
        synchronized (dataBuffer.getDataBuffer()) {
            //如果缓存为空进入等待
            while (dataBuffer.getDataBuffer().size() == 0) {
                try {
                    System.out.println("缓存区为空,消费者等待......");
                    dataBuffer.getDataBuffer().wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            //消费数据
            Integer remove = dataBuffer.getDataBuffer().remove(0);
            System.out.println("消费者消费数据: " + remove);
            //通知生产者继续生产
            dataBuffer.getDataBuffer().notifyAll();
        }
    }
}
