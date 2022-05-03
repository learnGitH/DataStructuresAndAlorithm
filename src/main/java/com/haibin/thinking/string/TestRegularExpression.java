package com.haibin.thinking.string;

import com.haibin.thinking.util.Print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
    public static void main(String[] args){
        if (args.length < 2){
            Print.print("111");
            System.exit(0);
        }
        Print.print("Input:\"" + args[0] + "\"");
        for(String arg : args){
            Print.print("Regular expressioin: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while(m.find()){
                Print.print("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
            }
        }
    }
}
