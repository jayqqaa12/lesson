package com.jayqqaa12.jdk.func;

import com.jayqqaa12.model.User;
import org.junit.Test;

import java.util.function.Function;

/**
 * 几种不同的 表达式形态
 * Created by 12 on 2017/8/31.
 */
public class LambdaTest {

    @Test
    public void test() {

        Function<User, Integer> function = (u) -> {
            return u.getAge();
        };

        Function function2 = (User u) -> u.getAge();

        Function function3 =  u -> u.getAge();

        // 方法引用
        Function<User, Integer> function4 = User::getAge;

    }

  
    
    /**
    *- 可以直接在lambda表达式中访问外层的局部变量 但不能修改
    *- lambda方法参数也不能修改
    **/
   @Test
   public void testFinal(){
 
    int num = 1;  
    Converter<Integer, String> s =   (param) -> String.valueOf(param + num);  
    //num = 5; 



   }


   static int myStaticNum;  
    int myNum;  

        /**
    *- Lambda内部对于成员变量以及静态变量是即可读又可写
    **/
   
    @Test 
    public void testScopes() {  
        Converter<Integer, String> s1 = (param) -> {  
            myNum = 33;  
            return String.valueOf(param);  
        };  
   
        Converter<Integer, String> s2 = (param) -> {  
            myStaticNum = 87;  
            return String.valueOf(param);  
        };  
    }  

 
 
     @Test 
     public   void closure(String text,int count){  
        Runnable r = () -> {  
            for(int i = 0; i < count; i++){  
                System.out.println(text);  
                Thread.yield();  
            }  
        };  
        new Thread(r).start();  
    }  

}
