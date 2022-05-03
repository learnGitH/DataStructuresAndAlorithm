package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        Print.print(read("BufferedInputFile.java"));
    }
}
