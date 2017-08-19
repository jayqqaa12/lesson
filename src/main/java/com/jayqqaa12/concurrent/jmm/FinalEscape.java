package com.jayqqaa12.concurrent.jmm;

import com.jayqqaa12.NotThreadSafe;

/**
 * Created by 12 on 2017/8/19.
 */
@NotThreadSafe
public class FinalEscape {

    final int x;
    int y;
    private static FinalEscape f;


    public static FinalEscape obj;

    public FinalEscape() {
        x = 3;
        y = 4;
        obj = this;   // 未构造完成前逸出
    }

    public static void writer() {
        f = new FinalEscape();
    }

    public static void reader() {
        if (f != null) {
            int i = f.x;
            int j = f.y;
        }
    }
}
