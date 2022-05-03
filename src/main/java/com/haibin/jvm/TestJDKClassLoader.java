package com.haibin.jvm;

public class TestJDKClassLoader {

    public static void main(String[] args){
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        System.out.println();

        //通过ClassLoader的getSystemClassLoader获取系统默认类加载器 默认是sun.misc.Launcher$AppClassLoader 应用类加载器
       /* ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("the appClassLoader:" + appClassLoader);

        //获取应用类加载器的父加载器
        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println("the extClassLoader:" + extClassLoader);

        //获取扩展类加载器的父加载器
        ClassLoader bootstrapLoader = extClassLoader.getParent();
        System.out.println("the bootstrapLoader : " + bootstrapLoader);*/
    }

}
