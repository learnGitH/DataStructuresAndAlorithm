package com.haibin.concurrency.syn;

import org.openjdk.jol.info.ClassLayout;

public class Juc_PrintMarkWord {

    public static void main(String[] args) throws InterruptedException{
        Thread.sleep(5000);
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
        synchronized (t){
            // 获取一次锁之后
            System.out.println(ClassLayout.parseInstance(t).toPrintable());
        }
        // 输出hashcode
        System.out.println(t.hashCode());
        // 计算了hashcode之后，将导致锁的升级
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
        synchronized (t){
            // 再次获取锁
            System.out.println(ClassLayout.parseInstance(t).toPrintable());
        }
    }

}

class T{
    int i = 0;
}
