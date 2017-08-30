package com.jayqqaa12.jdk.stream;

import com.jayqqaa12.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Jdk8_collector_reduce_test {


    public static void main(String[] args) {
        List<User> userList = constructUserList();

        //使用JDK8 提取所有名字
        List<String> userStrList = userList.stream().map(User::getName).collect(Collectors.toList());
        //把名字提取出来，并转化成name set
        Set<String> userNameSet = userList.stream().map(User::getName).collect(Collectors.toSet());

        //转化成<name, password> 结构的map，注意： key 不能重复，使用distinct去重复
        Map<String, String> userNameMap = userList.stream().distinct().collect(Collectors.toMap(u -> u.getName(), u -> u.getPassword()));

        //提取成 Map<name, User>
        Map<String, User> userMap = userList.stream().distinct().collect(Collectors.toMap(u -> u.getName(), Function.identity()));

        //提取成 Map<name, String> 合并
        Map<String, String> userMergeDulicateMap = userList.stream()
                .collect(Collectors.toMap(User::getName, User::getPassword, (t1, t2) ->{
                    return t1 + "," + t2;
                }));

        System.out.println("---------------打印 list -------------");
        userStrList.forEach(System.out::println);

        System.out.println("---------------打印 set -------------");
        userNameSet.forEach(System.out::println);

        System.out.println("---------------打印 map -------------");
        userNameMap.forEach((key, val) -> {
            System.out.println(key + "---" + val);
        });

        System.out.println("---------------打印 user map -------------");
        userMap.forEach((key, val) -> {
            System.out.println(key + "---" + val.getPassword());
        });

        System.out.println("---------------打印 userMergeDulicateMap -------------");
        userMergeDulicateMap.forEach((key, val) -> {
            System.out.println(key + "---" + val);
        });

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