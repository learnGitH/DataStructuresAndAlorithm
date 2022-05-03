package com.haibin.thinking.reflect;

import java.util.Random;

public class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.random.nextInt(10000);
    static {
        System.out.println("Initializing Initable");
    }
}
