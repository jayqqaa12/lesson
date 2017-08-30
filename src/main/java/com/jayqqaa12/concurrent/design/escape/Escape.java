package com.jayqqaa12.concurrent.design.escape;

import com.google.common.collect.Lists;
import com.jayqqaa12.NotThreadSafe;
import com.jayqqaa12.model.User;

import java.util.List;

/**
 * 逸出
 *
 * Created by 12 on 2017/8/15.
 */
@NotThreadSafe
public class Escape {
  
   private List<User> users = Lists.newArrayList();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
