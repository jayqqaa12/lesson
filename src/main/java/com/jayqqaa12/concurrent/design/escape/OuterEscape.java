package com.jayqqaa12.concurrent.design.escape;

import com.jayqqaa12.NotThreadSafe;

/**
 * 内部类的this 逸出
 */
@NotThreadSafe
public class OuterEscape {
    private String str = "Outer's string";


    public class Inner {
        public void write() {
            System.out.println(OuterEscape.this.str);
        }
    }


    public static void main(String[] args) {
        OuterEscape out = new OuterEscape();
        OuterEscape.Inner in = out.new Inner();
        in.write();

    }
}  