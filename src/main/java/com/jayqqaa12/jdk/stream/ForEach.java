package com.jayqqaa12.jdk.stream;

import com.jayqqaa12.model.User;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * lambda forEach
 *
 * Created by 12 on 2017/8/30.
 */
public class ForEach {

    private List<User> persons = asList(new User("Joe"), new User("Jim"), new User("John"));


    @Test
    public void old() {
        //外部循环
        for (User p : persons) {
            p.setPassword("Doe");
        }
    }


    @Test
    public void lambda() {
        persons.forEach(p -> p.setPassword("Doe"));
    }





}
