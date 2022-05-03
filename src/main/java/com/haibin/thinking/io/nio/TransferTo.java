package com.haibin.thinking.io.nio;

import com.haibin.thinking.util.Print;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransferTo {
    public static void main(String[] args) throws Exception{
        if (args.length != 2){
            Print.print("arguments:sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0,in.size(),out);
        //out.transferFrom(in,0,in.size());
    }
}
