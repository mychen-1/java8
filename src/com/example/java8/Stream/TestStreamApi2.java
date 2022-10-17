package com.example.java8.Stream;

import com.example.java8.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 *  一、Stream的筛选与切片
 *  filter--接收Lambda，从流中筛选元素
 *  limit--
 *  skip(n)--跳过前n个元素，
 *  distinct--去重
 *
 *
 *  二、映射
 *      map-接收lambda，将元素转换成其他形式或提取信息，将函数作为一个参数，
 *      该函数会被应用到每个元素上，并将其映射成一个新的元素
 *      flatmap--接收一个函数作为参数，将流中每个值都换成另外一个流，然后将所有的流连接成一个类
 *
 */
public class TestStreamApi2 {

    List<Employee> employees= Arrays.asList(
            new Employee("陈陈",20,4000),
            new Employee("李李",25,5555),
            new Employee("王王",15,6666),
            new Employee("颜颜",30,2222),
            new Employee("伟伟",35,8888),
            new Employee("陈陈",21,5000)
    );

    //筛选和切片
    @Test
    public void test1(){
        employees.stream()
                //中间操作
                .filter((e)->e.getAge()>=25)
                .limit(2)
                //最终操作。只有实现最后操作，中间操作才能执行
                .forEach(System.out::println);
    }
    //映射  map
    @Test
    public  void  test2(){
        List<String> lists=Arrays.asList("aaa","bbb","ccc");
        lists.stream()
                //toUpperCase 转换为大写
                .map((str)->str.toUpperCase())
                .forEach(System.out::println);
    }

}
