package com.jayqqaa12.jdk.func.interfaces;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by 12 on 2017/8/30.
 */
public class OptionalTest {


// if (person != null) {
//     Country country = person.getCountry();
//     if (country != null) {
//         Province province = country.getProvince();
//         if (province != null) {
//             address = province.getCity();
//         }
//     }
// }

    @Test
     public void test() {
        final String text = "Hallo world!";
        Optional.ofNullable(text)//显示创建一个Optional壳
                .map(t->t.substring(5))
                .ifPresent(System.out::println);

        Optional.ofNullable(text)
                .filter((str)->str.contains("s"))
                .map(s -> null)//返回 null
//                .orElse("is empty")
                .orElseThrow(IllegalArgumentException::new);
    }

      
 

}
