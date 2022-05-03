package com.haibin.thinking.thread;

import com.haibin.thinking.util.Print;

public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        Print.print("Waiting for LiftOff");
    }
}
