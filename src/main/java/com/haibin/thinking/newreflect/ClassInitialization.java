package com.haibin.thinking.newreflect;

import com.haibin.thinking.util.Print;

import java.util.Random;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        Print.print("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        Print.print("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        Print.print("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        Print.print("After creating Initable ref");
        Print.print(Initable.staticFinal);
        Print.print(Initable.staticFinal2);
        Print.print(Initable2.staticNonFinal);
        Class initable3 = Class.forName("com.haibin.thinking.newreflect.Initable3");
        Print.print("After creating Initable3 ref");
        Print.print(Initable3.staticNonFinal);
    }
}
