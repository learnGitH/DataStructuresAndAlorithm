package com.haibin.thinking.thread;

import com.haibin.thinking.util.Print;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{
    public void run(){
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                Print.print(Thread.currentThread() + " " + this);
            }
        }catch (InterruptedException e){
            Print.print("sleep() interrupted");
        }
    }
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        Print.print("All daemon started");
        TimeUnit.MILLISECONDS.sleep(1750);
    }
}
