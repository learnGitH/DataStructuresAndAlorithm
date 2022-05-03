package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import javax.xml.crypto.Data;
import java.io.*;

public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("D:\\projectPath\\git\\DataStructuresAndAlgorithm\\src\\main\\java\\com\\haibin\\thinking\\io\\TestEOF.java")
                )
        );
        while(in.available() != 0){
            Print.print((char)in.readByte());
        }
    }
}
