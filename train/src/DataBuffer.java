import java.util.LinkedList;
import java.util.List;

public class DataBuffer {
    private final List<Integer> dataBuffer=new LinkedList<>();
    protected static final int maxSize=65535;

    public List<Integer> getDataBuffer() {
        return dataBuffer;
    }
}
