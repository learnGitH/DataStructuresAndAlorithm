package com.haibin.thinking.thread;

import com.haibin.thinking.util.Print;

import java.util.concurrent.TimeUnit;

class NeedsCleanup{
    private final int id;
    public NeedsCleanup(int ident){
        id = ident;
        Print.print("NeedsCleanup " + id);
    }
    public void cleanup(){
        Print.print("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable{
    private volatile double d = 0.0;
    public void run(){
        try{
            while(!Thread.interrupted()){
                NeedsCleanup n1 = new NeedsCleanup(1);
                try{
                    Print.print("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try{
                        Print.print("Calculating");
                        for (int i = 1; i < 2500000; i++){
                            d = d + (Math.PI + Math.E) / d;
                        }
                        Print.print("Finished time-consuming operation");
                    }finally {
                        n2.cleanup();
                    }
                }finally {
                    n1.cleanup();
                }
            }
            Print.print("Exiting via while() test");
        }catch (InterruptedException e){
            Print.print("Exiting via InterruptedException");
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args) throws Exception{
       /* if (args.length != 1){
            Print.print("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }*/
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(1100));
        t.interrupt();
    }
}
