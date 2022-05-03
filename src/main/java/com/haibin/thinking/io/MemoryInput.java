package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("D:\\projectPath\\git\\DataStructuresAndAlgorithm\\src\\main\\java\\com\\haibin\\thinking\\io\\MemoryInput.java"));
        int c;
        while((c=in.read()) != -1){
            Print.print((char)c);
        }
    }
}
