package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.*;

public class BasicFileOutput{
    static String file = IOFileBaseName.baseName + "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(IOFileBaseName.baseName + "BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        Print.print(BufferedInputFile.read(file));
    }
}
