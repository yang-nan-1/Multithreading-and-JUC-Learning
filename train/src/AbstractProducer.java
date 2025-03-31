public abstract class AbstractProducer implements Runnable{
    @Override
    public final void run() {
    while (true){
//        生产
        produce();
    }
    }

    protected abstract void produce();

}
