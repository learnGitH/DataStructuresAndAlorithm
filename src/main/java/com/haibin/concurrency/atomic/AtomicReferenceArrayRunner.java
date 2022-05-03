package com.haibin.concurrency.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayRunner {

    static Haibin[] ovalue = new Haibin[]{new Haibin(1),new Haibin(2)};
    static AtomicReferenceArray<Haibin> objarray = new AtomicReferenceArray<>(ovalue);

    public static void main(String[] args){
        System.out.println(objarray.get(0).getSequence());

        objarray.set(0,new Haibin(3));
        System.out.println(objarray.get(0).getSequence());
    }

}
