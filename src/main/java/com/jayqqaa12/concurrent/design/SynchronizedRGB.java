package com.jayqqaa12.concurrent.design;

import com.jayqqaa12.concurrent.ThreadSafe;


/**
 * 同步
 */
@ThreadSafe
public class SynchronizedRGB {

    // Values must be between 0 and 255.
    private int red;
    private int green;
    private int blue;
    private String name;

    private void check(int red, int green, int blue) {
        if (red < 0 || red > 255
                || green < 0 || green > 255
                || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public SynchronizedRGB(int red, int green, int blue, String name) {
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    public void set(int red, int green, int blue, String name) {
        check(red, green, blue);
        synchronized (this) {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.name = name;
        }
    }

    public synchronized int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    public synchronized String getName() {
        return name;
    }


    public static void main(String[] args) {

        SynchronizedRGB color = new SynchronizedRGB(0, 0, 0, "Pitch Black");
        int myColorInt = color.getRGB();      // 1
        String myColorName = color.getName(); // 2

//如果其他线程在1执行后调用set方法 就会导致 getName 跟getRGB的值不匹配

        synchronized (color) {
            myColorInt = color.getRGB();
            myColorName = color.getName();
        }
    }
}