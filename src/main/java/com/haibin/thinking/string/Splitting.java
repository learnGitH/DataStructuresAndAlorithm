package com.haibin.thinking.string;

import com.haibin.thinking.util.Print;

import java.util.Arrays;

public class Splitting {
    public static String knights = "Then, when you have found the shrubbery,";
    public static void split(String regex){
        Print.print(Arrays.toString(knights.split(regex)));
    }
    public static void main(String[] args){
        split(" ");
        split("\\w+");
        split("n\\w+");
    }

}
