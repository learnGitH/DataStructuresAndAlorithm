package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.File;

public class DirectoryDemo {
    public static void main(String[] args){
        PPrint.pprint(Directory.walk(".").dirs);
        for (File file : Directory.local(".","T.*")){
            Print.print(file);
        }
        Print.print("-----------------------------");
        for (File file : Directory.walk(".","T.*\\.java")){
            Print.print(file);
        }
        Print.print("============================");
        for (File file : Directory.walk(".",".*[Zz].*\\.class")){
            Print.print(file);
        }
    }
}
