package com.haibin.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Student {

    private String id;
    private String name;
    private LocalDate birthday;
    private int age;
    private double score;

}
