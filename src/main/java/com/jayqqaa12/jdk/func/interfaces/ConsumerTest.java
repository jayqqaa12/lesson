package com.jayqqaa12.jdk.func.interfaces;

import java.util.function.Consumer;

public class ConsumerTest {

    static class PhoneMessage implements Consumer<String> {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        String name = "name";
        String password = "password";

        //java.util.function.Consumer 输入<T>，没有return
        Consumer<String> messageConsumer = message -> System.out.println("----messageConsumer-----" + message);
        Consumer<String> afterConsumer = message -> new PhoneMessage().accept("------afterConsumer----" + message);
        Consumer<String> exceptionConsumer = message -> {
            System.out.println("------exceptionConsumer----" + message);
            throw new NullPointerException();
        };

        int i = 0;
        //1. 直接输入，没有输出
        messageConsumer.accept(name + i++);
        //2. 如果执行messageConsumer.accept(password)，没有异常情况就执行afterConsumer.accept(passowrd)
        messageConsumer.andThen(afterConsumer).accept(password + i++);
        //3. exceptionConsumer.accept(password)，异常情况就不执行afterConsumer.accept(passowrd)
        exceptionConsumer.andThen(afterConsumer).accept(password + i++);
    }
}