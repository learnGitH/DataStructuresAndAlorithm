package com.haibin.concurrency.syn;

public class Juc_LockAppend {
    StringBuffer stb = new StringBuffer();

    private void method(){
        stb.append("杨过");
        stb.append("小龙女");
        stb.append("大雕");
        stb.append("郭靖");
    }
}
