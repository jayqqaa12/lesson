package com.jayqqaa12.jdk.date;

import org.junit.Test;

import java.time.Period;

/**
 * Created by 12 on 2017/8/31.
 */
public class PeriodTest {

    @Test
    public void test(){
        //周期，如表示10天前  3年5个月钱

        Period period1 = Period.ofDays(10);
        System.out.println(period1);
        Period period2 = Period.of(3, 5, 0);
        System.out.println(period2);
    }
}
