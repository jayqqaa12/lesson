package com.jayqqaa12.concurrent.design.escape;


import com.jayqqaa12.NotThreadSafe;


/**
 *构造函数this 逸出
 *
 */
@NotThreadSafe
public class ConstructorEscape {
    private Thread t;

    public ConstructorEscape() {

        System.out.println(this);

        t = new Thread() {
            public void run() {
                System.out.println(ConstructorEscape.this);
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        ConstructorEscape a = new ConstructorEscape();
    }
}  