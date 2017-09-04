package com.jayqqaa12.jdk.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahChronology;

/**
 * Created by 12 on 2017/8/31.
 */
public class ChronologyTest {


    @Test
    public void test() {
        //提供对java.util.Calendar的替换，提供对年历系统的支持
        Chronology c = HijrahChronology.INSTANCE;
        ChronoLocalDateTime d = c.localDateTime(LocalDateTime.now());

        System.out.println(d);
    }
}
