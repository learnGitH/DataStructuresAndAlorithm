package com.haibin.design.visitor;

public interface Element {
    public abstract void accept(Visitor v);
}
