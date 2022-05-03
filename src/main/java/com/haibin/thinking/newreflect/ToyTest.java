package com.haibin.thinking.newreflect;

import com.haibin.thinking.util.Print;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc){
        Print.print("Class name:" + cc.getName() + "is interface?[" + cc.isInterface() + "]");
        Print.print("Simple name: " + cc.getSimpleName());
        Print.print("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args){
        Class c = null;
        try{
            c = Class.forName("com.haibin.thinking.newreflect.FancyToy");
        }catch (ClassNotFoundException e){
            Print.print("Can't find FancyToy");
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
            Print.print("Cannot instantiate");
            System.exit(1);
        }catch (IllegalAccessException e){
            Print.print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }

}

