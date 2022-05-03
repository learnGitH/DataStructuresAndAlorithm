package com.haibin.thinking.string;

import com.haibin.thinking.util.Print;

public class IntegerMatch {
    public static void main(String[] args){
        Print.print("-1233".matches("-?\\d+"));
        Print.print("5678".matches("-?\\d+"));
        Print.print("+911".matches("-?\\d+"));
        Print.print("+911".matches("(-|\\+)?\\d+"));
    }
}
