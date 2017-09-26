package com.jayqqaa12.jdk.func;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * Created by 12 on 2017/9/26.
 */
public class Currying {

    int pow(int i, int j) {
        return (int) Math.pow(i, j);
    }


    int square(int i) {
        return pow(i, 2);
    }



    public  void func(){

        IntFunction<IntFunction<IntUnaryOperator>> f = x -> y -> z -> (x + y) * z;

        IntUnaryOperator f2 = f.apply(3).apply(4);

        System.out.println(f2.applyAsInt(5));
    }

}
