package com.jayqqaa12.jdk.func;

/**
 * 默认方法和 静态的方法
 * <p>
 * Created by 12 on 2017/8/24.
 */
public interface DefaultMethod {

    static void testStaticMethod() {

        System.out.println("static method call");
    }

    default void testDefaultMethod() {
        System.out.println("default method call");
    }


    public static void main(String[] args) {

        DefaultMethod.testStaticMethod();

    }

}
