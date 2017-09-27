package com.jayqqaa12.jdk.func.lambda;

import com.jayqqaa12.model.User;
import org.junit.Test;

import java.util.function.Function;

/**
 * 几种不同的 表达式形态
 * Created by 12 on 2017/8/31.
 */
public class LambdaTest {

    @Test
    public void test() {

        Function<User, Integer> function = (u) -> {
            return u.getAge();
        };

        Function<User, Integer> function2 = (User u) -> u.getAge();

        Function<User, Integer> function3 = u -> u.getAge();


    }


    /**
     * - 可以直接在lambda表达式中访问外层的局部变量 但不能修改
     **/
    @Test
    public void testFinal() {

        final int num = 1;
        Function<Integer, String> converter = (param) -> {
            System.out.println(this);
            return String.valueOf(num + param);
        };

        converter.apply(1);
    }


    static int myStaticNum;
    int myNum;

    /**
     * - Lambda内部对于成员变量以及静态变量是即可读又可写
     **/
    @Test
    public void testScopes() {
        Function<Integer, String> s1 = (param) -> {
            myNum = 33;
            return String.valueOf(param);
        };

        Function<Integer, String> s2 = (param) -> {

            myStaticNum = 87;
            return String.valueOf(param);
        };
    }


    /**
     * 不能访问接口默认方法
     */
    @Test
    public void testDefault() {

        Function<Integer, String> s3 = (param) -> {
//            A.foo(); 不能访问
            A.foo2();
            return String.valueOf(param);
        };

    }


    interface A {

        default void foo() {
            System.out.println("Calling A.foo()");
        }

        static void foo2() {
            System.out.println("Calling A.foo2()");
        }
    }


    /**
     * 'this'关键字及其引用在lambda表达式内部和外部也拥有相同的语义
     */
    @Test
    public void testThis() {
        new LambdaTest().r1.run();
        new LambdaTest().r2.run();
    }



    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());


    public String toString() {
        return "Hello, world";
    }



//    @Test
//    public void closure(String text, int count) {
//        Runnable r = () -> {
//            for (int i = 0; i < count; i++) {
//                System.out.println(text);
//                Thread.yield();
//            }
//        };
//        new Thread(r).start();
//    }

}
