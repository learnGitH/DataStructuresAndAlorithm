package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.*;

public class Redirecting{
    public static void main(String[] args) throws IOException{
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(IOFileBaseName.baseName + "Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(IOFileBaseName.baseName + "test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null){
            Print.print(s);
        }
        out.close();
        Print.print(console);
    }
}
