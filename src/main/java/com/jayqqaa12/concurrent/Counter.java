package com.jayqqaa12.concurrent;

/**
 * 计数器
 * <p>
 * Created by 12 on 2017/8/15.
 */
@NotThreadSafe
public class Counter {

    private int c = 0;

    public void incr() {
        c++;
    }

    public int value() {
        return c;
    }


}
