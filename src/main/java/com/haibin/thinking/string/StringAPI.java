package com.haibin.thinking.string;

import com.haibin.thinking.util.Print;

import java.util.ArrayList;

public class StringAPI {
    public static void main(String[] args){
        String a = "testgsldhgslhgj123";
        Print.print(a.startsWith("test"));
        Print.print(a.endsWith("test"));
        Print.print(a.indexOf("s"));
        Print.print(a.concat("bbb"));
        Print.print(a.toLowerCase());
    }
}
