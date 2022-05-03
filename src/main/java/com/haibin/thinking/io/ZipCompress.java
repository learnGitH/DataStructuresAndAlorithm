package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipCompress {
    public static void main(String[] args) throws IOException{
        FileOutputStream f = new FileOutputStream(IOFileBaseName.baseName + "test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f,new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");
        for(String arg : args){
            Print.print("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while((c = in.read()) != -1){
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();
        Print.print("Checksum: " + csum.getChecksum().getValue());
        Print.print("Reading file");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi,new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while((ze = in2.getNextEntry()) != null){
            Print.print("Reading file " + ze);
            int x;
            while((x = bis.read()) != -1){
                System.out.write(x);
            }
        }
        if (args.length == 1){
            Print.print("Checksum: " + csumi.getChecksum().getValue());
        }
        bis.close();
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while(e.hasMoreElements()){
            ZipEntry ze2 = (ZipEntry)e.nextElement();
            Print.print("File: " + ze2);
        }

    }
}
