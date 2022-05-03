package com.haibin.concurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

public class Juc01_Thread_LockSupport {

    public static void main(String[] args){
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread current = Thread.currentThread();
                System.out.println("{},开始执行!"+current.getName());
                for(;;){//spin 自旋
                    System.out.println("准备park住当前线程：{}...."+current.getName());
                    LockSupport.park();
                    System.out.println("当前线程{}已经被唤醒...."+current.getName());
                }
            }
        },"t0");
        t0.start();
        try {
            Thread.sleep(5000);
            System.out.println("准备唤醒{}线程!"+t0.getName());
            t0.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
