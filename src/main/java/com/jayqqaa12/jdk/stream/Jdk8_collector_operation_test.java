package com.jayqqaa12.jdk.stream;

import com.jayqqaa12.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class Jdk8_collector_operation_test {



    public static void main(String[] args) {
        List<User> userList = constructUserList();

        //1.maxBy求最大值
        User user = userList.stream().collect(Collectors.collectingAndThen(
                Collectors.maxBy((t1, t2) ->t1.getPassword().length() - t2.getPassword().length()), Optional::get));

        //2.joining 合并，通过分隔符“,”合并用户名称
        String userName = userList.stream().map(User::getName).collect(Collectors.joining(","));

        //3.summingInt 统计总和
        int totalNameLen = userList.stream().map(User::getName).collect(Collectors.summingInt(String::length));

        //4.counting 集合个数
        Long count = userList.stream().map(User::getName).collect(Collectors.counting());

        //5.groupingBy 分组， counting统计元素个数，按照名字分组，并统计分组元素个数
        Map<String, Long> groupNameCount = userList.stream().collect(Collectors.groupingBy(User::getName, Collectors.counting()));

        //6.partitioningBy 分片 根据Predicate条件分片
        Map<Boolean, List<User>> partitioningMap = userList.stream()
                .collect(Collectors.partitioningBy(u -> u.getPassword().indexOf("1") >= 0, Collectors.toList()));

        //7.summarizingInt 对数据的汇总统计 返回一个统计类IntSummaryStatistics
        IntSummaryStatistics intSummaryStatistics = userList.stream().map(User::getPassword)
                .collect(Collectors.summarizingInt(String::length));


        System.out.println( "password最大长度的：" + user.getName());
        System.out.println("所用用户名：" + userName);
        System.out.println("所有用户名长度：" + totalNameLen);
        System.out.println("集合个数：" + count);
        groupNameCount.forEach((key, val) -> {
            System.out.println(key + " ---打印分组元素个数--- " + val);
        });

        partitioningMap.forEach((key, val) -> {
            System.out.println(key + " ---打印分片元素--- ");
            val.forEach(u -> {
                System.out.println( u.getName() );
            });
        });

        System.out.println("------汇总统计----平均值：" + intSummaryStatistics.getAverage());
        System.out.println("------汇总统计----元素个数：" + intSummaryStatistics.getCount());
        System.out.println("------汇总统计----最小值：" + intSummaryStatistics.getMin());
        System.out.println("------汇总统计----最大值：" + intSummaryStatistics.getMax());
        System.out.println("------汇总统计----累加：" + intSummaryStatistics.getSum());

    }

    /**
     * 构造一个用户列表
     *
     * @return
     */
    private static List<User> constructUserList() {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 4; i++) {
            User u = new User();
            u.setPassword("password" + i);
            u.setName("name" + i);
            userList.add(u);
            userList.add(u);
        }
        return userList;
    }
}