package com.jayqqaa12.jdk.func;

/**
 * Created by 12 on 2017/9/26.
 */
public class Immutable {

    public String reverse(String string) {

        if (string.length() == 0) {
            return string;
        } else {
            return reverse(string.substring(1, string.length())) + string.substring(0, 1);
        }
    }
}
