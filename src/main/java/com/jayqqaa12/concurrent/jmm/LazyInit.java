package com.jayqqaa12.concurrent.jmm;

import com.jayqqaa12.NotThreadSafe;
import com.jayqqaa12.ThreadSafe;

/**
 * Created by 12 on 2017/8/19.
 * <p>
 * http://www.javaworld.com/article/2074979/java-concurrency/double-checked-locking--clever--but-broken.html
 * <p>
 * <p>
 * memory = allocate();   //1：分配对象的内存空间
 * ctorInstance(memory);  //2：初始化对象
 * instance = memory;     //3：设置instance指向刚分配的内存地址
 */
public class LazyInit {
    private static LazyInit instance = null;


    @NotThreadSafe
    public static LazyInit getInstanceByDoubleCheck() {
        if (instance == null) {
            synchronized (LazyInit.class) {
                if (instance == null)
                    instance = new LazyInit();
            }
        }
        return instance;
    }


    @ThreadSafe
    public static LazyInit getInstanceByHolder() {
        return LazyHolder.something;
    }


    //    static holder pattern
    private static class LazyHolder {
        public static LazyInit something = new LazyInit();
    }
}
