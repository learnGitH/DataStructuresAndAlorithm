package com.haibin.concurrency.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,2,5000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        for(int i = 0; i < 6; i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("i m task : " + Thread.currentThread().getName());
                }
            });
        }
        Thread.sleep(2000);
        threadPoolExecutor.shutdown();
        threadPoolExecutor.shutdownNow();

        //test();

        System.out.println("返回当天小时"+getHour(new Date()));

    }

    /**
     * 功能描述：返回小时
     *
     * @param date
     *            日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 测试跳出循环
     */
    public static void test(){
        int i = 5;
        retry:
        for (;;){
            System.out.println("-------------test--------------");
            if (i == 5){
                continue retry;
                //break retry;
            }
        }
    }

}
