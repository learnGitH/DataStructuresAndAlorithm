package com.haibin.thinking.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal{
    private final int orderNum;
    public Meal(int orderNum){
        this.orderNum = orderNum;
    }
    public String toString(){
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable{
    private Restanrant restanrant;
    public WaitPerson(Restanrant r){
        restanrant = r;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    while(restanrant.meal == null){
                        wait();
                    }
                }
                System.out.println("Waitperson got " + restanrant.meal);
                synchronized (restanrant.chef){
                    restanrant.meal = null;
                    restanrant.chef.notifyAll();
                }
            }
        }catch (InterruptedException e){
            System.out.println("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable{
    private Restanrant restanrant;
    private int count = 0;
    public Chef(Restanrant r){
        restanrant = r;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    while(restanrant.meal != null){
                        wait();
                    }
                }
                if (++count == 10){
                    System.out.println("Out of food,closing");
                    restanrant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                synchronized (restanrant.waitPerson){
                    restanrant.meal = new Meal(count);
                    restanrant.waitPerson.notifyAll();
                }
                TimeUnit.MICROSECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println("Chef interrupted");
        }
    }
}

public class Restanrant {

    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public Restanrant(){
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args){
        new Restanrant();
    }
}
