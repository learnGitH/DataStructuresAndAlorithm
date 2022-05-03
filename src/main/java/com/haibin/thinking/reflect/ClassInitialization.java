package com.haibin.thinking.reflect;

import java.util.Random;

public class ClassInitialization {
    public static Random random = new Random(47);
    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticFinal);

        Class initial3 = Class.forName("com.haibin.thinking.reflect.Initable3");
        System.out.println("After creatring Initable3 ref");
        System.out.println(Initable3.staticFinal);

    }
}
