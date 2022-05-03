package com.haibin.jvm;

public class ThreadTest2 {

    /**
     * 线程死锁等待演示
     */
    static class SynAddRunnable implements Runnable{
        int a,b;
        public SynAddRunnable(int a,int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread.sleep(6000);
        for (int i = 0; i < 100; i++){
            new Thread(new SynAddRunnable(1,2)).start();
            new Thread(new SynAddRunnable(2,1)).start();
        }
    }

}
