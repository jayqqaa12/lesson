package com.jayqqaa12.jdk.func;

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

        Function<Object, Integer> function = (u) -> {
            return new User().getAge();
        };

        Function function2 = (Object u) -> new User().getAge();

        Function function3 =  u -> new User().getAge();

        // 方法引用
        Function<User, Integer> function4 = User::getAge;

    }
}
