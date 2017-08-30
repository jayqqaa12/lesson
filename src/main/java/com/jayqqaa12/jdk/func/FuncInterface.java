package com.jayqqaa12.jdk.func;

/**
 * 函数式接口指只有一个方法的接口
 * <p>
 * Created by 12 on 2017/8/24.
 */
@FunctionalInterface
public interface FuncInterface {
    void exec();


    String toString();
    boolean equals(Object obj);
}
