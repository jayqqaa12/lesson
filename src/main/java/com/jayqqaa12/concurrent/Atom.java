package com.jayqqaa12.concurrent;

import com.jayqqaa12.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class Atom {

    AtomicInteger atomicInteger = new AtomicInteger();

    private  int numThreads;


    public void inc() {

        for (int b = 0; b < numThreads; b++) {
            new Thread(() -> {
                    atomicInteger.incrementAndGet();
            }).start();
        }
    }


}