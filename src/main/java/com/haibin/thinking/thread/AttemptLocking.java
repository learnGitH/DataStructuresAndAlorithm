package com.haibin.thinking.thread;

import com.haibin.thinking.util.Print;
import sun.awt.geom.AreaOp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed(){
        boolean captured = lock.tryLock();
        try{
            Print.print("tryLock(): " + captured);
        }finally {
            if (captured){
                lock.unlock();
            }
        }
    }

    public void timed(){
        boolean captured = false;
        try{
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        try{
            Print.print("tryLock(2,TimeUnit.SECONDS): " + captured);
        }finally {
            if (captured){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args){
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread(){
            {setDaemon(true);}
            public void run(){
                al.lock.lock();
                Print.print("acquired");
            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }

}
