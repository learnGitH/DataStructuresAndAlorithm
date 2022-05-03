package com.haibin.thinking.string;

import com.haibin.thinking.util.Print;

public class Immutable {
    public static String upcase(String s){
        return s.toUpperCase();
    }

    public static void main(String[] args){
        String q = "hobby";
        Print.print(q);
        String qq = upcase(q);
        Print.print(qq);
        Print.print(q);
    }
}
