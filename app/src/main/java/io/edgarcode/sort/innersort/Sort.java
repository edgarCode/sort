package io.edgarcode.sort.innersort;

import java.util.Random;

/**
 * Created by zhangjifeng on 16/8/15.
 */
public abstract class Sort {
    public int[] data;
    public static final int COUNT = 10000;
    public Sort() {
        data = new int[COUNT];
        for (int i = 0; i < COUNT; i++) {
            data[i] = new Random().nextInt(COUNT);
        }
    }

    public abstract void exec();
}
