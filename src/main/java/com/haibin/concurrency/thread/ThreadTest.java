package com.haibin.concurrency.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //通过继承Thread方式
        new TestThread().start();
        //通过实现Runnable的方式
        new Thread(new TestRunnable()).start();
        //通过实现Callable的方式
        FutureTask<String> futureTask = new FutureTask<>(new TestCallable("my callable test!"));
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }


}

class TestThread extends Thread{
    @Override
    public void run() {
        System.out.println("我是继承Thread");
    }
}

class TestRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("我是实现自Runnable");
    }
}

class TestCallable implements Callable<String>{
    private String acceptStr;
    public TestCallable(String acceptStr){
        this.acceptStr = acceptStr;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return this.acceptStr + "append some chars and return it!";
    }
}


