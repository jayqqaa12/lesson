package com.jayqqaa12.jdk.other;

import org.junit.Test;

/**
 * Created by 12 on 2017/8/31.
 */
public class StringSwitch {

    @Test
    public void test(){

        String  type ="A";


        switch (type){

            case "A":

                System.out.println("A select");
                break;
            case "B":

                System.out.println("B select");
                break;
            case "C":

                System.out.println("B select");
                break;
            default:
                break;
        }
    }

}
