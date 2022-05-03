package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(IOFileBaseName.baseName + "Data.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(IOFileBaseName.baseName + "Data.txt")));
        Print.print(in.readDouble());
        Print.print(in.readUTF());
        Print.print(in.readDouble());
        Print.print(in.readUTF());
    }
}
