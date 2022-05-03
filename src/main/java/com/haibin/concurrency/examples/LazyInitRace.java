package com.haibin.concurrency.examples;

import com.haibin.concurrency.annotations.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {

    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance(){
        if (instance == null){
            instance = new ExpensiveObject();
        }
        return instance;
    }

}

class ExpensiveObject{}
