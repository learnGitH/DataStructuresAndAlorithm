package com.haibin.thinking.io.nio;

import com.haibin.thinking.io.IOFileBaseName;
import com.haibin.thinking.util.Print;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024;
    public  static void main(String[] args) throws Exception{
        FileChannel fc = new FileOutputStream(IOFileBaseName.baseName + "nio\\data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new FileInputStream(IOFileBaseName.baseName + "nio\\data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        Print.print(buff.asCharBuffer());
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        Print.print("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));
        fc = new FileOutputStream(IOFileBaseName.baseName + "nio\\data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();
        fc = new FileInputStream(IOFileBaseName.baseName + "nio\\data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        Print.print(buff.asCharBuffer());
        fc = new FileOutputStream(IOFileBaseName.baseName + "nio\\data2.txt").getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
        fc = new FileInputStream(IOFileBaseName.baseName + "nio\\data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        Print.print(buff.asCharBuffer());
    }
}
