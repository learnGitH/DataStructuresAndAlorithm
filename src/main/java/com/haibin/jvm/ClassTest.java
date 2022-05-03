package com.haibin.jvm;

public class ClassTest {

    class innerClass{
        private int i = 1;
    }

    @Deprecated
    private String username = "shenhaibin";
    private Integer age = 18;
    private final String country = "China";
    private int count;
    public static String b;

    public void printInfo(){
        String a = "test";
        System.out.println("姓名：" + username + "年纪：" + age);
    }

}
