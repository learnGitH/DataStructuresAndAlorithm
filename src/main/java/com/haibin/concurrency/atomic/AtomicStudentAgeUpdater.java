package com.haibin.concurrency.atomic;

import com.haibin.concurrency.jmm.util.UnsafeInstance;
import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

public class AtomicStudentAgeUpdater {

    private String name;
    private volatile int age;

    public AtomicStudentAgeUpdater(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public static void main(String[] args){
        AtomicStudentAgeUpdater updater = new AtomicStudentAgeUpdater("海滨",18);
        System.out.println(ClassLayout.parseInstance(updater).toPrintable());
        updater.compareAndSwapAge(18,88);
        System.out.println("真实的海滨年龄--->"+updater.getAge());
    }

    private static final Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();
    private static final long valueOffset;

    static {
        try{
            valueOffset = unsafe.objectFieldOffset(AtomicStudentAgeUpdater.class.getDeclaredField("age"));
            System.out.println("valueOffset:--->"+valueOffset);
        }catch (Exception e){
            throw new Error(e);
        }
    }

    public void compareAndSwapAge(int old,int target){
        unsafe.compareAndSwapInt(this,valueOffset,old,target);
    }

}
