package com.jayqqaa12.jdk.func;

import java.util.UUID;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        // java.util.function.Supplier 没有输入，返回一个值T
        Supplier<String> supplier = () -> UUID.randomUUID().toString();
        System.out.println("supplier生成的随机串： " + supplier.get());
    }
}