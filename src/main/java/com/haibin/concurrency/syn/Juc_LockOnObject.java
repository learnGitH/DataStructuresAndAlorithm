package com.haibin.concurrency.syn;

public class Juc_LockOnObject {

    public static Object object = new Object();

    private Integer stock = 10;

    public void decrStock(){
        synchronized (object){
            --stock;
            if (stock<=0){
                System.out.println("库存售窑");
                return;
            }
        }
    }

}
