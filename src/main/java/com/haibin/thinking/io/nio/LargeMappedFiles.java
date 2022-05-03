package com.haibin.thinking.io.nio;

import com.haibin.thinking.io.IOFileBaseName;
import com.haibin.thinking.util.Print;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {
    static int length = 0x8FFFFFF;
    public static void main(String[] args) throws Exception{
        MappedByteBuffer out = new RandomAccessFile(IOFileBaseName.baseName + "nio\\test.dat","rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE,0,length);
        for (int i = 0; i < length; i++){
            out.put((byte)'x');
        }
        Print.print("Finished writing");
        for (int i = length / 2; i < length/2+6; i ++){
            Print.printnb((char)out.get(i));
        }
    }
}
