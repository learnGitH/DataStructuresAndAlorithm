package com.haibin.thinking.generic;

import com.haibin.thinking.util.Print;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args){
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0);
        Print.print(flist.contains(new Apple()));
        Print.print(flist.indexOf(new Apple()));
    }
}
