package com.jayqqaa12.jdk.func;

import com.jayqqaa12.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class FunctionTest {

    public static void main(String[] args) {
        //初始化数据
        List<User> userList = new ArrayList<User>();
        userList.add(new User("name1", "passowrd1"));
        userList.add(new User("name2", "passowrd2"));
        userList.add(new User("name3", "passowrd3"));
        userList.add(new User("name4", "passowrd4"));

        //1.java.util.function.Function<T, R> 有输入R类型、输出类型T
        Function<User, String> function = user -> user.getName();
        Function<String, String> afterFunction = name -> name + " -----锦上添花";

        //2. function.apply(user) 获取到返回值
        userList.forEach(user -> System.out.println(function.apply(user)));
        System.out.println("----------我是一条分割线 1-------------------");

        //3. andThen 的用法
        //function.apply(user) 得到name
        //name成为afterFunction的输入，afterFunction.apply(name) 作为最后输出
        userList.forEach(user -> System.out.println(function.andThen(afterFunction).apply(user)));
        System.out.println("----------我是一条分割线 2-------------------");

        //4. 上述3可以换成compose
        userList.forEach(user -> System.out.println(afterFunction.compose(function).apply(user)));
        System.out.println("----------我是一条分割线 3-------------------");

        //以N开头的String
        Predicate<User> predicate = user -> user.getName().indexOf("4") >= 0;
        //5. user -> user.getName() 等于  Function<User, String> function = user -> user.getName();
        List<String> names = getList(userList, predicate, user -> user.getName());
        names.forEach(System.out::println);
        System.out.println("----------我是一条分割线 4-------------------");

        //6. Function.identity() 等于   Function<User, User> function = user -> user;
        List<User> users = getList(userList, user -> user.getName().equals("name1"), Function.identity());
        users.forEach(user -> System.out.println(user.getPassword()));
        System.out.println("----------我是一条分割线 5-------------------");
    }


    public static <R> List<R> getList(List<User> userList, Predicate<User> filter, Function<User, R> extractor) {

        return userList.stream().filter(user -> filter.test(user)).map(user -> extractor.apply(user)).collect(toList());
    }
}