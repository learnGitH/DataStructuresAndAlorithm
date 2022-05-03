package com.haibin.algorithm2.stack;

import java.util.Stack;

public class MyStack2 {

    Stack<Integer> stackData;
    Stack<Integer> stackMin;

    public MyStack2(){
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int newNumber){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNumber);
        }else if(newNumber < getMin()){
            this.stackMin.push(newNumber);
        }else{
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNumber);
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        this.stackMin.pop();
        return this.stackData.pop();

    }

    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return stackMin.peek();
    }

}
