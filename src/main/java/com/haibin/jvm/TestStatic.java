package com.haibin.jvm;

public class TestStatic {

    static {
        System.out.println("static");
    }

    public TestStatic(){
        System.out.println("contruct");
    }

    public static void  main(String[] args){
        new TestStatic();
    }

}
