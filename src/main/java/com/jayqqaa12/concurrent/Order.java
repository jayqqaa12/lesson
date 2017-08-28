package com.jayqqaa12.concurrent;

/**
 * 有序性问题
 * <p>
 * Created by 12 on 2017/8/15.
 */
@NotThreadSafe
public class Order {

    private volatile int c = 0;

    public void incr() {
        c++;
    }

    public int value() {
        return c;
    }


}
