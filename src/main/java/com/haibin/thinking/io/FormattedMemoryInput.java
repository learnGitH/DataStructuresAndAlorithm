package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try{
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(
                    BufferedInputFile.read("D:\\projectPath\\git\\DataStructuresAndAlgorithm\\src\\main\\java\\com\\haibin\\thinking\\io\\FormattedMemoryInput.java").getBytes()
            ));
            while(true){
                Print.print((char)in.readByte());
            }
        }catch (EOFException e){
            Print.print("End of stream");
        }
    }
}
