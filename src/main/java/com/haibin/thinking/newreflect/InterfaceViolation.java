package com.haibin.thinking.newreflect;

import com.haibin.thinking.util.Print;

interface A {
    void f();
}

class B implements A {
    public void f(){}
    public void g(){}
}

public class InterfaceViolation {
    public static void main(String[] args){
        A a = new B();
        a.f();
        Print.print(a.getClass().getName());
        if (a instanceof B){
            B b = (B)a;
            b.g();
        }
    }
}
