package com.haibin.thinking.newreflect;

import com.haibin.thinking.util.Print;

public interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    public void doSomething(){
        Print.print("doSomething");
    }
    public void somethingElse(String arg){
        Print.print("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;
    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }
    public void doSomething(){
        Print.print("SimpleProxy doSomething");
        proxied.doSomething();
    }
    public void somethingElse(String arg){
        Print.print("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

class SimpleProxyDemo{
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args){
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}