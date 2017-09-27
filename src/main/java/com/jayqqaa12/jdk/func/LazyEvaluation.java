package com.jayqqaa12.jdk.func;

/**
 * Created by 12 on 2017/9/26.
 */
public class LazyEvaluation {
    
    
    public  void main(){

        String s1 = somewhatLongOperation1();
        String s2 = somewhatLongOperation2();

        String s3 = maxLength(s1, s2);
    }




    private String maxLength(String s1, String s2) {
        if(s1.length()>5)return s1;
        else return s2;
    }


    private String somewhatLongOperation1() {
        return "a"+"a";
    }

    private String somewhatLongOperation2() {
        return "b"+"b";
    }


}
