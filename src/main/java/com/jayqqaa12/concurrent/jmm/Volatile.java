package com.jayqqaa12.concurrent.jmm;

import com.jayqqaa12.ThreadSafe;


/**
 * 使用volatile 保证内存可见性
 */
@ThreadSafe
public class Volatile {
    private int x = 0;
    private volatile boolean visable = false;

    public void writer() {
        x = 42;
        visable = true;
    }

    public void reader() {
        if (visable) {
            System.out.println(x);

        }
    }
}