package com.jayqqaa12.jdk.func;


/**
 * Created by 12 on 2017/9/26.
 */
public class Expression {

    int a, b, r;

    void statement() {
        r = abs(a) + abs(b);
        System.out.println(r);
    }

    int express(int a, int b) {
        return abs(a) + abs(b);
    }


    private int abs(int b) {
        return Math.abs(b);
    }
}
