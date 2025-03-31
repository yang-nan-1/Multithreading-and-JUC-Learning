public abstract class AbstractConsumer implements Runnable{
    public final void run()
    {
        while(true)
        {
//            消费
            consume();
        }
    }
    protected abstract void consume();
}
