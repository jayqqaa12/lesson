package com.jayqqaa12.concurrent.design;

import com.jayqqaa12.ThreadSafe;
import com.jayqqaa12.model.User;

import java.util.concurrent.ThreadLocalRandom;


@ThreadSafe
public class ThreadLocalTest implements Runnable {

    ThreadLocal<User> studentLocal = new ThreadLocal();

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        new Thread(t, "t1").start();
        new Thread(t, "t2").start();
    }


    @Override
    public void run() {
        User s = this.getStudent();

        int age = ThreadLocalRandom.current().nextInt(100);

        System.out.println("current thread set age " + Thread.currentThread() + ":" + age);
        s.setAge(age);

        System.out.println("current thread first get age " + Thread.currentThread() + ":" + s.getAge());

        System.out.println("current thread second get age " + Thread.currentThread() + ":" + s.getAge());

        studentLocal.remove();  // thread local 使用完就释放 防止泄漏
    }


    public User getStudent() {
        User s = studentLocal.get();
        if (s == null) {
            s = new User();
            studentLocal.set(s);
        }
        return s;
    }
}  