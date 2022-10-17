package com.example.java8.Lambda;

//Lambda  四大函数式接口

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *   java8内置的四大函数式接口
 *
 *   Consumer<T>: 消费性接口
 *       void  accept(T t);
 *
 *   Supplier<T>: 供给型接口
 *        T  get();
 *
 *   Function(T,R) :函数型接口
 *       R apply(T t)
 *
 *   Predicate<T> :断言型接口
 *        boolean  test(T t);
 */

public class TestLambda2 {
    // Consumer<T> 消费型接口
    @Test
    public void  test1(){
        happy(100,(x)-> System.out.println("我要去消费"+x+"元"));
    }
    public  void happy(Integer num, Consumer<Integer> con){
        con.accept(num);
    }

    //Function(T,R) 函数型接口
    @Test
    public void  test2(){
        String s = strHandler("\t\t\t  用于过滤前后空格  ", (str) -> str.trim());
        System.out.println(s);

    }
    //需求 ：用于处理字符串
    public  String strHandler(String str, Function<String,String> fun){
        return  fun.apply(str);
    }
    //Supplier<T> 供给型接口
    @Test
    public void  test3(){
        List<Integer> lists = getNumList(10, () -> (int) (Math.random()*100));
        for (Integer list : lists) {
            System.out.println(list);
        }
    }
    //需求：添加元素
    public List<Integer>  getNumList(int num, Supplier<Integer> sup){
       List<Integer> lists=  new ArrayList<>();
        for (int i=0;i<num;i++){
            Integer n=sup.get();
            lists.add(n);
        }
        return lists;
    }
    // Predicate<T>  断言型接口
    @Test
    public void  test4(){
           List<String> list= Arrays.asList("hello","i am fine","so  good","i am  chen");
           List<String> strlist = filterStr(list, (s) -> s.length() > 3);
        for (String s : strlist) {
            System.out.println(s);
        }
    }
    //需求：将满足条件的字符串，存入集合中
    public  List<String> filterStr(List<String> list,Predicate<String> pre){
       List<String> strList=  new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)){
                strList.add(s);
            }
        }
        return strList;
    }
}
