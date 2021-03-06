package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        /*if (args.length == 0){
            Print.print("Usage: \nGZIPcompress file\n" +
                    "\tUses GZIP compression to compress " +
                    "the file to test.gz");
            System.exit(1);
        }*/
        BufferedReader in = new BufferedReader(new FileReader(IOFileBaseName.baseName + "test.txt"));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        Print.print("Writing file");
        int c;
        while((c = in.read()) != -1){
            out.write(c);
        }
        in.close();
        out.close();
        Print.print("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while((s = in2.readLine()) != null){
            Print.print(s);
        }
    }
}
