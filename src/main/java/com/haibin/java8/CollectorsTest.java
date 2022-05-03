package com.haibin.java8;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsTest {

    public static void main(String[] args){
        final List<Student> students = new ArrayList<>();
        students.add(new Student("1", "张三", LocalDate.of(2009, Month.JANUARY, 1),  12,  12.123));
        students.add(new Student("2", "李四", LocalDate.of(2010, Month.FEBRUARY, 2),  11,  22.123));
        students.add(new Student("3", "王五", LocalDate.of(2011, Month.MARCH, 3),  10,  32.123));
    }

    /**
     * 元素数量couting
     */
    public Long count(List<Student> students){
        return students.stream().collect(Collectors.counting());
    }

    /**
     * 元素数量average
     */
    public double average(List<Student> students){
        //return students.stream().collect(Collectors.averagingInt(Student::getAge));
        //return students.stream().collect(Collectors.averagingLong(Student::getAge));
        return students.stream().collect(Collectors.averagingDouble(Student::getScore));
    }

    /**
     * 元素数量summing
     */
    public double sum(List<Student> students){
        return students.stream().collect(Collectors.summingDouble(Student::getScore));
    }

    /**
     * 元素数量max或min
     */
    public Optional<Student> maxOrmin(List<Student> students){
        //return students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        return students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
    }

    /**
     * 元素数量summary
     */
    public DoubleSummaryStatistics summary(List<Student> students){
        return students.stream().collect(Collectors.summarizingDouble(s -> (int) s.getScore()));
    }

    /**
     * 元素数量toList
     */
    public List<String> toList(List<Student> students){
        return students.stream().map(Student::getId).collect(Collectors.toList());

    }

    /**
     * 元素数量toMap
     */
    public Map<String, Student> toMap(List<Student> students){
        return students.stream().collect(Collectors.toMap(Student::getId, Function.identity(),(x,y) -> x));
    }

}
