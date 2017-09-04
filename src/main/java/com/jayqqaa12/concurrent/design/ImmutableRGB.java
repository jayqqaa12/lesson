package com.jayqqaa12.concurrent.design;


import com.jayqqaa12.ThreadSafe;

/**
 * 不可变对象
 *  
 * 创建不可变对象的几条原则
*- 不提供修改可变对象的方法。（包括修改字段的方法和修改字段引用对象的方法）
*- 将类的所有字段定义为final、private的。
*- 不允许子类重写方法。简单的办法是将类声明为final，更好的方法是将构造函数声明为私有的，通过工厂方法创建对象。
*- 如果类的字段是对可变对象的引用，不允许修改被引用对象。
*- 不共享可变对象的引用。当一个引用被当做参数传递给构造函数，而这个引用指向的是一个外部的可变对象时，一定不要保存这个引用。如果必须要保存，那么创建可变对象的拷贝，然后保存拷贝对象的引用。同样如果需要返回内部的可变对象时，不要返回可变对象本身，而是返回其拷贝
 */
@ThreadSafe
final public class ImmutableRGB {

    // Values must be between 0 and 255.
    final private int red;
    final private int green;
    final private int blue;
    final private String name;

    private void check(int red,
                       int green,
                       int blue) {
        if (red < 0 || red > 255
            || green < 0 || green > 255
            || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public ImmutableRGB(int red,
                        int green,
                        int blue,
                        String name) {
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    public int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    public String getName() {
        return name;
    }


}