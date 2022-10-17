package com.example.java8.Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的介绍：
 * Stream API ( java.util.stream) 把真正的函数式编程风格引入到Java中。
 * Stream 是 Java8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。
 * 使用Stream API 对集合数据进行操作，就类似于使用 SQL 执行的数据库查询。也可以使用 Stream API 来并行执行操作。
 * 简言之，Stream API 提供了一种高效且易于使用的处理数据的方式。

 *
 * 一、Stream的三个操作步骤：
 *   1.创建Stream
 *
 *   2.中间操作
 *
 *   3.终止操作
 */

public class TestStreamApi {
    //创建Stream
    @Test
    public  void test1(){
        //1.通过Collection系列集合提供的stream或parallelstream()
        List<String> list= new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2通过Arrays中的静态方法stream()获取数组
        Integer[] ints = new Integer[10];
        Stream<Integer> stream2= Arrays.stream(ints);

        //3.通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10)
                .forEach(System.out::println);
    }
}
