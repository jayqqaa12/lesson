package com.jayqqaa12.jdk.func;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

/**
 * Created by 12 on 2017/9/26.
 */
public class HigherLevelFunction {


    public IntFunction<Integer> addNum(int size, ToIntFunction<List<Integer>> fn) {
        final List<Integer> args = Lists.newArrayList();


        return new IntFunction<Integer>() {
            @Override
            public Integer apply(int value) {
                //  没有达到定义的数量之前，不求值
                int result = -1;
                if(args.size() == size) {
                    result = fn.applyAsInt(args);
                } else {
                    args.add(value);
                }
                //  返回结果
                return result;
            }

        };

    }
}
