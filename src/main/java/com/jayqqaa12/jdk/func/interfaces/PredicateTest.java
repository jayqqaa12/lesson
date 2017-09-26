package com.jayqqaa12.jdk.func.interfaces;

import java.util.function.Predicate;

/**
 * Created by 12 on 2017/8/24.
 */
public class PredicateTest {

    public static void main(String[] args) {
        String name = "name";
        String password = "password";

        //1. java.util.function.Predicate 测试object是否符合某些测试条件

        Predicate<String> predicate = str -> str.startsWith("n");
        Predicate<String> predicate2 = str -> str.startsWith("p");

        System.out.println("name     --是否n开头：       " + predicate.test(name));
        System.out.println("password --是否n开头：       " + predicate.test(password));
        System.out.println("name     --是否n and p开头： " + predicate.and(predicate2).test(name));
        System.out.println("password --是否n or p开头：  " + predicate.or(predicate2).test(password));
    }
}
