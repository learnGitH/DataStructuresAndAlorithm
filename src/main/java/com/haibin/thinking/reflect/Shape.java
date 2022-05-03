package com.haibin.thinking.reflect;

public abstract class Shape {
    void draw(){
        System.out.println(this + ".draw()");
    }
    abstract public String toString();
}
