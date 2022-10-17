package com.example.java8.Lambda;

import java.util.*;
import java.util.function.Consumer;

import com.example.java8.Lambda.MyFun;
import org.junit.Test;

/**
 *  1.Lambda 表达式的基础语法：java8引入Lambda表达式，使用的操作符是“->”，该箭头是
 *  Lambda操作符。作用是将表达式分为两个部分。
 *  左侧：Lambda的参数列表
 *  右侧：Lambda表达式执行的功能，即是Lambda体。
 *
 *  语法格式1：
 *     无参数 无返回值  ：Runnable
 *  语法格式2
 *     有一个参数，无返回值: Consumer
 *   语法格式3
 *      有多个参数，有返回值，Lambda体只有一个数据，省略return
 *          Comparator<Integer> com=(x,y) -> Integer.compare(x,y);
 *   语法格式4
 *   有多个参数，有返回值，并且Lambda体有多个语句
 *        Comparator<Integer> com=(x,y) ->{
 *            System.out.println("函数式接口");
 *            return  Integer.compare(x,y);
 *        };
 *
 *
 *   二、Lambda 表达式需要”函数式接口“的支持
 *          函数式接口：接口中只有一个抽象方法的接口，称为函数式接口
 *          可以使用注解  @FunctionalInterface 修饰  并检查是否为函数式接口
 *
 */

public class TestLambda {
    //语法格式一
    @Test
    public void  test1(){
        //1.匿名内部类实现
         Runnable r= new Runnable() {
            @Override
            public void run() {
                System.out.println("hello   runnable");
            }
        };
         r.run();
         //2.Lambda表达式实现
        Runnable r1=() -> System.out.println("hello  Lambda");
        r1.run();
    }

    //语法格式2
    @Test
    public  void  test2(){
        Consumer<String> con=(x) -> System.out.println(x);
        con.accept("这是一个参数!");
    }
    //语法格式3
    @Test
    public  void  test3(){
        Comparator<Integer> com=(x,y) -> Integer.compare(x,y);
    }
    //语法格式4
    @Test
    public  void  test4(){
       Comparator<Integer> com=(x,y) ->{
           System.out.println("函数式接口");
//           return  Integer.compare(x,y);
           return  Integer.compare(x,y);
       };
    }

    //需求  对一个数进行操作
    @Test
    public  void  test5(){
        Integer integer = operation(100, (x) -> x * x);
        System.out.println(integer);

    }

    public  Integer operation(Integer num, MyFun my){
        return  my.getValue(num);
    }
}
