package com.jayqqaa12.jdk.func;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by 12 on 2017/8/30.
 */
public class OptionalTest {

    private static String print(String str) {
        System.out.println(str);
        return str.substring(6);
    }

    boolean checkNotNull(Object obj) {
        return null == obj ? false : true;
    }


    @Test
    public void test() {
        final String text = "Hallo world!";
        Optional.ofNullable(text)//显示创建一个Optional壳
                .map(OptionalTest::print)
                .ifPresent(System.out::println);

        Optional.ofNullable(text)
                .map(OptionalTest::print)
                .map(s -> null)//返回 null
                .ifPresent(System.out::println);
    }
}
