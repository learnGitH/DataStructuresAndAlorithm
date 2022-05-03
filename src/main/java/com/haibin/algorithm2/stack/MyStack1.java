package com.haibin.algorithm2.stack;

import java.util.Stack;

public class MyStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MyStack1(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newNumber){
        if (this.stackMin.isEmpty()){
            stackMin.push(newNumber);
        }else if(newNumber <= this.getMin()){
            this.stackMin.push(newNumber);
        }
        this.stackData.push(newNumber);
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        int value = this.stackData.pop();
        if (value == getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }

}
