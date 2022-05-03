package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    static String file = IOFileBaseName.baseName + "rtest.dat";
    static void display() throws IOException{
        RandomAccessFile rf = new RandomAccessFile(file,"r");
        for (int i = 0; i < 7; i++){
            Print.print("Value " + i + ": " + rf.readDouble());
        }
        Print.print(rf.readUTF());
        rf.close();
    }
    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file,"rw");
        for (int i = 0; i < 7; i++){
            rf.writeDouble(i*1.414);
        }
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file,"rw");
        rf.seek(5*8);
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
