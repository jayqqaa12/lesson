package com.jayqqaa12.jdk.func.def;

interface A {
    default void foo() {
        System.out.println("Calling A.foo()");
    }
}

interface B {
    default void foo() {
        System.out.println("Calling B.foo()");
    }
}

public class Clazz implements A {

//    public void foo() {
//        System.out.println("Calling class.foo()");
//
////        A.super.foo();
////        B.super.foo();
//    }

    public static void main(String[] args) {
        Clazz clazz = new Clazz();
        clazz.foo();
    }

}