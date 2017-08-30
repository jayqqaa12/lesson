package com.jayqqaa12.jdk.func;

import java.util.Optional;

/**
 * Created by 12 on 2017/8/30.
 */
public class OptionalTest {

    boolean checkNotNull(Object obj) {
        return null == obj ? false : true;
    }

    // 打印并截取str[5]之后的字符串
    private static String print(String str) {
        System.out.println(str);
        return str.substring(6);
    }

    public static void main(String[] args) {
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
