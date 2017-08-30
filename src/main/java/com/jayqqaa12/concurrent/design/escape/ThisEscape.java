package com.jayqqaa12.concurrent.design.escape;


import com.jayqqaa12.NotThreadSafe;


/**
 *构造函数this 逸出
 *
 */
@NotThreadSafe
public class ThisEscape {
    private Thread t;

    public ThisEscape() {

        System.out.println(this);

        t = new Thread() {
            public void run() {
                System.out.println(ThisEscape.this);
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        ThisEscape a = new ThisEscape();
    }
}  