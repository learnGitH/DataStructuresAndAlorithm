package com.haibin.concurrency.syn;

public class Juc_LockOnClass {
    static int stock;

    public static synchronized void decrStock(){
        System.out.println(--stock);
    }

    public static synchronized void cgg(){
        System.out.println();
    }

    public static void main(String[] args) {
        Juc_LockOnClass.decrStock();
    }
}
