package com.haibin.concurrency.examples;

import com.haibin.design.visitor.Main;

public class LoggingWidget extends Widget{
    public synchronized void doSomething(){
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}
