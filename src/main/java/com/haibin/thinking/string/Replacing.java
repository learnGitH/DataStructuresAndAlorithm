package com.haibin.thinking.string;

import com.haibin.thinking.util.Print;

public class Replacing {
    static String s = Splitting.knights;
    public static void main(String[] args){
        Print.print(s.replaceFirst("f\\w+","located"));
        Print.print(s.replaceAll("shrubbery|tree|herring","banana"));
    }
}
