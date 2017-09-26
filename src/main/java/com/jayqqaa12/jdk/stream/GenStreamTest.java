package com.jayqqaa12.jdk.stream;

import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenStreamTest {


    @Test
    public void gen() {

        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);

        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);

    }


    @Test
    public void iterate() {

        Stream.iterate(0, n -> n + 3).limit(10).forEach(x -> System.out.print(x + " "));

    }


}