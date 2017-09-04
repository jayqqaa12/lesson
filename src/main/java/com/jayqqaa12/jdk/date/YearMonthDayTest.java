package com.jayqqaa12.jdk.date;

import org.junit.Test;

import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

/**
 * Created by 12 on 2017/8/31.
 */
public class YearMonthDayTest {


    @Test
    public void test() {

        Year year = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay monthDay = MonthDay.now();

        System.out.println(year);//年
        System.out.println(yearMonth); //年-月
        System.out.println(monthDay); // 月-日


    }
}
