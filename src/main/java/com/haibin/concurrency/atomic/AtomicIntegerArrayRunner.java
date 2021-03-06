package com.haibin.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayRunner {

    static int[] value = new int[]{1,2};
    static AtomicIntegerArray aiArray = new AtomicIntegerArray(value);

    public static void main(String[] args){
        aiArray.getAndSet(0,3);
        System.out.println(aiArray.get(0));
        System.out.println(value[0]);
    }

}
