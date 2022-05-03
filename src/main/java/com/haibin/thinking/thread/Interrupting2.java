package com.haibin.thinking.thread;

import com.haibin.thinking.util.Print;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutex{
    private Lock lock = new ReentrantLock();
    public BlockedMutex(){
        lock.lock();
    }
    public void f(){
        try{
            lock.lockInterruptibly();
            Print.print("lock acquired in f()");
        }catch (InterruptedException e){
            Print.print("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable{
    BlockedMutex blockedMutex = new BlockedMutex();
    public void run(){
        Print.print("Waiting for f() in BlockedMutex");
        blockedMutex.f();
        Print.print("Broken out of blocked call");
    }
}

public class Interrupting2 {
    public static void main(String[] args) throws Exception{
        Thread t  = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        Print.print("Issuing t.interrupt()");
        t.interrupt();
    }
}
