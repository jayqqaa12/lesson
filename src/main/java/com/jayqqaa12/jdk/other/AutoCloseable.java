package com.jayqqaa12.jdk.other;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * try-resource
 *
 * Created by 12 on 2017/8/31.
 */
public class AutoCloseable {

    @Test
    public void test() throws IOException {


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"), "GBK"))) {

            List<String> lines = reader.lines().collect(Collectors.toList());
        }


    }
}
