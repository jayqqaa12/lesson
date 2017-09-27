package com.jayqqaa12.jdk.date;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by 12 on 2017/8/31.
 */
public class ZoneTest {

    @Test
    public  void test(){

        //即带有时区的date-time 存储纳秒、时区和时差（避免与本地date-time歧义）。
//API和LocalDateTime类似，只是多了时差(如2013-12-20T10:35:50.711+08:00[Asia/Shanghai])
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        ZonedDateTime now2= ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println(now2);

        ZonedDateTime z1 = ZonedDateTime.parse("2013-12-31T23:59:59Z[Europe/Paris]");
        System.out.println(z1);
    }
}
