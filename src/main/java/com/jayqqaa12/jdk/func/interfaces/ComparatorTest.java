package com.jayqqaa12.jdk.func.interfaces;

import com.jayqqaa12.model.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 12 on 2017/8/31.
 */
public class ComparatorTest {


    @Test
    public void test() {
        List<User> students = Arrays.asList(new User("test1", "test", 12));

        Comparator<User> byAge = Comparator.comparing(User::getAge);

        // 升序
        students.stream().sorted(byAge).collect(Collectors.toList());
        // 降序
        students.stream().sorted(byAge.reversed()).collect(Collectors.toList());

        // 如果相同再用name排序
        byAge.thenComparing(User::getName);

        students.stream().sorted(byAge).collect(Collectors.toList());

        //如果有null的排在后面
        Comparator<User> allowNullComparator = Comparator.nullsLast(byAge);

    }

}
