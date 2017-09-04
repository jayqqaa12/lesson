package com.jayqqaa12.jdk.date;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by 12 on 2017/8/31.
 */
public class DurationTest {

    @Test
    public void test(){

        Duration d1 = Duration.between(Instant.ofEpochMilli(System.currentTimeMillis() - 12323123), Instant.now());
//得到相应的时差
        System.out.println(d1.toDays());
        System.out.println(d1.toHours());
        System.out.println(d1.toMinutes());
        System.out.println(d1.toMillis());
        System.out.println(d1.toNanos());

//1天时差 类似的还有如ofHours()
        Duration d2 = Duration.ofDays(1);
        System.out.println(d2.toDays());
    }


}

