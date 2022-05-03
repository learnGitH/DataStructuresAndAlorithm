package com.haibin.thinking.io.nio;

import com.haibin.thinking.io.IOFileBaseName;
import com.haibin.thinking.util.Print;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream(IOFileBaseName.baseName + "nio\\data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new RandomAccessFile(IOFileBaseName.baseName + "nio\\data.txt","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        fc = new FileInputStream(IOFileBaseName.baseName + "nio\\data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining()){
            Print.print((char)buff.get());
        }
    }
}
