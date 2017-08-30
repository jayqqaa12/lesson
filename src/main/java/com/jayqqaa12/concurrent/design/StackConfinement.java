package com.jayqqaa12.concurrent.design;

import com.jayqqaa12.ThreadSafe;
import com.jayqqaa12.model.User;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * stack封闭
 * Created by 12 on 2017/8/15.
 */
@ThreadSafe
public class StackConfinement {



    public int load(Collection<User> users) {
        Set<User> userSet = new TreeSet<>(users);
        load2(userSet);

        return userSet.size();
    }


    private void load2(Set<User> userSet) {
        userSet.add(new User("test", "test"));
    }

}
