package com.lutong.test;

import com.lutong.bean.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lutong
 * @date 2021/1/18
 **/
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);
        list.sort((Integer a,Integer b)->{
            return a -b;
        });
        list.stream().distinct().forEach(a-> System.out.println(a));
        System.out.println("集合最大值："+list.stream().max(Integer::compareTo).get());
        System.out.println(list.stream().anyMatch(e -> e == 1));
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"zhangsan"));
        students.add(new Student(2,"lisi"));
        students.add(new Student(3,"wangwu"));
        List<Integer> collect = students.stream().map(Student::getId).collect(Collectors.toList());
        collect.stream().forEach(e-> System.out.println("组合："+e));
        Map<Integer, Student> collect1 = students.stream().collect(Collectors.toMap(Student::getId, student -> student));
        for(int key : collect1.keySet()){
            System.out.println(key+":"+collect1.get(key));
        }
    }
}
