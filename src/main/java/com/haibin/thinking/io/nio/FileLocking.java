package com.haibin.thinking.io.nio;

import com.haibin.thinking.io.IOFileBaseName;
import com.haibin.thinking.util.Print;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream(IOFileBaseName.baseName + "nio\\file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null){
            Print.print("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            Print.print("Released Lock");
        }
        fos.close();
    }
}
