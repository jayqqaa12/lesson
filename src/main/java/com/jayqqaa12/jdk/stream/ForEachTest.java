package com.jayqqaa12.jdk.stream;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * lambda forEach
 * <p>
 * Created by 12 on 2017/8/30.
 */
public class ForEachTest {


    @Test
    public void old() {
        //外部循环

        for (int i = 1; i < 4; i++) {
            System.out.print(i + "...");
        }

    }

    @Test
    public void lambda() {

        IntStream.range(1, 4)
                .forEach(i -> System.out.print(i + "..."));

    }

    public void old2() {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            int temp = i;
            executorService.submit(new Runnable() {
                public void run() {

                    System.out.println("Running task " + temp);
                }
            });
        }

        executorService.shutdown();
    }


    public void lambda2() {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 5)
                .forEach(i ->
                        executorService.submit(new Runnable() {
                            public void run() {
                                System.out.println("Running task " + i);
                            }
                        }));

        executorService.shutdown();


    }


}
