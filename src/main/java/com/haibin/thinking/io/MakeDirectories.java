package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.io.File;

public class MakeDirectories {
    private static void usage(){
        Print.print("Usage:MakeDirectories path1 ...\n" +
                "Creates each path\n" +
                "Usage:MakeDirectories -d path1 ...\n" +
                "Deletes each path\n" +
                "Usage:MakeDirectories -r path1 path2\n" +
                "Renames from path1 to path2");
    }

    private static void fileData(File f){
        Print.print("Absolute path: " + f.getAbsolutePath() +
                "\n Can read: " + f.canRead() +
                "\n Can write: " + f.canWrite() +
                "\n getParent: " + f.getParent() +
                "\n getPath: " + f.getPath() +
                "\n length: " + f.length() +
                "\n lastModified: " + f.lastModified());
        if (f.isFile()){
            Print.print("It's a file");
        }else if(f.isDirectory()){
            Print.print("It's a directory");
        }
    }

    public static void main(String[] args){
        if (args.length < 1){
            usage();
        }
        if (args[0].equals("-r")){
            if (args.length != 3){
                usage();
            }
            File old = new File(args[1]),rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
        int count = 0;
        boolean del = false;
        if (args[0].equals("-d")){
            count++;
            del = true;
        }
        count--;
        while(++count < args.length){
            File f = new File(args[count]);
            if (f.exists()){
                Print.print(f + " exists");
                if (del){
                    Print.print("deleting..." + f);
                    f.delete();
                }
            }else {
                if (!del){
                    f.mkdirs();
                    Print.print("created " + f);
                }
            }
            fileData(f);
        }
    }

}
