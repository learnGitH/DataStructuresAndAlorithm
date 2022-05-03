package com.haibin.jvm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestClass {
    private final static int m = 1;
    private static final String a = "rfhoi";
    public int inc() throws IOException {
        InputStream io = new FileInputStream("test.txt");
        io.read();
        return m + 1;
    }
}
