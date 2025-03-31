package com.bjpowernode.waitnotify;

import java.util.LinkedList;
import java.util.List;

/**
 * 数据缓存区
 *
 * @author Cat老师，关注我，抖音搜索：java512
 */
public class DataBuffer {

    private final List<Integer> dataBuffer = new LinkedList<>();

    protected static final int MAX_SIZE = 1024;

    public List<Integer> getDataBuffer() {
        return dataBuffer;
    }
}
