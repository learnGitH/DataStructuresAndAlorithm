package com.haibin.thinking.reflect;

public class ToyTest {

    public static void main(String[] args){
        Class c = null;
        try{
            c = Class.forName("com.haibin.thinking.reflect.FancyToy");
        }catch (ClassNotFoundException e){
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);

        for (Class face : c.getInterfaces()){
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;
        try{
            obj = up.newInstance();
        }catch (InstantiationException e){
            System.out.println("Can't i");
            System.exit(1);
        }catch (IllegalAccessException e){
            System.out.println("Can't access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }

    public static void printInfo(Class cc){
        System.out.println("Class name:" + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
}
