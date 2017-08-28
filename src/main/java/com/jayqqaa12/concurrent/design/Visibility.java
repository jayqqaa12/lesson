package com.jayqqaa12.concurrent.design;

import com.jayqqaa12.concurrent.NotThreadSafe;

/**
 * 可见性问题
 * Created by 12 on 2017/8/15.
 */
@NotThreadSafe
public class Visibility {

    private static boolean status;

    private static int i;


    public static void exec() {

        while (!status) {
            Thread.yield();
        }

        System.out.println(i);

    }


    public static void main(String[] args) {

        new Thread(() -> exec()).start();

        status = true;
        i = 99;
    }


}
