package com.jayqqaa12.jdk.stream;

import com.jayqqaa12.jbase.util.Ret;
import com.jayqqaa12.model.Clazz;
import com.jayqqaa12.model.User;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;


/**
 * Created by 12 on 2017/9/2.
 *
 * 注意stream 只能运行一次 否则会报错
 */
public class StreamTest {

    // build stream
    private Stream<User> personStream = Arrays.asList(new User("Joe", "Joe", 11), new User("Jim", "Jim", 12), new User("John", "John", 13)).stream();

    private Stream<Integer> integerStream = Stream.of(1, 2, 4, 6, 3, 9, 7, 2, 4, 9, 7);
    private Stream<String> stringStream = Arrays.stream(new String[]{"a", "b", "c"});


    @Test
    public void filter() {
        Stream stream = personStream.filter(p -> p.getAge() > 18);
    }

    @Test
    public void distinct() {
        Stream stream = integerStream.distinct();

    }

    @Test
    public void skipAndLimit() {
        Stream stream = personStream.filter(p -> p.getAge() > 18).skip(1).limit(5);
    }


    @Test
    public void sort() {
        Stream stream = personStream.sorted();

        stream=personStream.sorted(Comparator.naturalOrder());
        stream=personStream.sorted(Comparator.reverseOrder());

    }


    @Test
    public void map() {

        Stream stream = personStream.map(person -> Ret.create("key", person));

//         boxing 和 unboxing 会很耗时，所以特别为这三种基本数值型提供了对应的 Stream

        IntStream intStream = personStream.mapToInt(p -> p.getAge());

    }


    @Test
    public void flatMap() {
        List<User> girlList = new ArrayList<>();
        List<User> boyList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            girlList.add(new User("girl" + i, "passowrd" + i));
            boyList.add(new User("boy" + i, "passowrd" + i));
        }

        //班级1
        Clazz clazz = new Clazz();
        //班级2
        Clazz clazz2 = new Clazz();

        girlList.addAll(boyList);

        clazz.setUsers(girlList);
        clazz2.setUsers(girlList);

        //clazz stream -> user stream 扁平化
        Stream<User> allUserStream = Stream.of(clazz, clazz2).flatMap(c -> c.getUsers().stream());

        out.println("两个班级一共多少人：" + allUserStream.count());

    }


    @Test
    public void reduce() {
        List<User> boyList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            boyList.add(new User("boy" + i, "passowrd" + i));
        }

        Clazz clazz = new Clazz();
        clazz.setUsers(boyList);

        Stream<User> allUserStream = Stream.of(clazz).flatMap(c -> c.getUsers().stream());

        Optional<String> names = allUserStream.
                map(User::getName).sorted((first, second) -> first.compareTo(second))
                .reduce((first, second) -> first + " *** " + second);

        out.println(names.get());

    }



    @Test
    public void calculate() {

        long count = personStream.filter(p -> p.getAge() > 18).count();

        long sum =personStream.filter(p -> p.getAge() > 18).mapToInt(p->p.getAge()).sum();
        int max =personStream.filter(p -> p.getAge() > 18).mapToInt(p->p.getAge()).max().getAsInt();
        int min =personStream.filter(p -> p.getAge() > 18).mapToInt(p->p.getAge()).min().getAsInt();

    }


    @Test
    public void match() {
        boolean flag = integerStream.map(x -> x * x).anyMatch(x -> x == 81);

        flag = integerStream.map(x -> x * x).allMatch(x -> x == 81);
        flag = integerStream.map(x -> x * x).noneMatch(x -> x == 81);


    }

    @Test
    public void find() {

        Optional<User> any = personStream.filter(p -> p.getAge() > 18).findAny();

        Optional<User> first = personStream.filter(p -> p.getAge() > 18).findFirst();


    }


    @Test
    public void parallel() {
        Stream steram = personStream.parallel();
    }


    @Test
    public void peek() {
        Stream steram = personStream.peek(System.out::print);
    }


}
