package com.haibin.thinking.string;

import com.haibin.thinking.util.Print;

public class StringBuilderAPI {
    public static void main(String[] args){
        String a = "abcdefg";
        StringBuilder sb = new StringBuilder(a);
        Print.print(sb.toString());
        Print.print(sb.reverse());
        Print.print(sb.append("h").toString());
        Print.print(sb.insert(1,12).toString());
        Print.print(sb.replace(0,1,"0").toString());
        Print.print(sb.substring(0,5).toString());
    }
}
