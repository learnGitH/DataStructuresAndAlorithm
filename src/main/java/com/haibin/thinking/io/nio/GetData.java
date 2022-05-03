package com.haibin.thinking.io.nio;

import com.haibin.thinking.util.Print;

import java.nio.ByteBuffer;

public class GetData {
    private static final int BSIZE = 1024;
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while(i++ < bb.limit()){
            if (bb.get() != 0){
                Print.print("nonzero");
            }
        }
        Print.print("i = " + i);
        bb.rewind();
        bb.asCharBuffer().put("Howdy!");
        char c;
        while((c = bb.getChar()) != 0){
            Print.printnb(c + " ");
        }
        Print.print();
        bb.rewind();
        bb.asShortBuffer().put((short)471142);
        Print.print(bb.getShort());
        bb.rewind();
        bb.asIntBuffer().put(99471142);
        Print.print(bb.getInt());
        bb.rewind();
        bb.asLongBuffer().put(99471142);
        Print.print(bb.getLong());
        bb.rewind();
        bb.asFloatBuffer().put(99471142);
        Print.print(bb.getFloat());
        bb.rewind();
        bb.asDoubleBuffer().put(99471142);
        Print.print(bb.getDouble());
        bb.rewind();
    }
}
