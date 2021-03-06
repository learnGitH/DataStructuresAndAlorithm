package com.haibin.thinking.io.util;

import com.haibin.thinking.io.IOFileBaseName;
import com.haibin.thinking.util.Print;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    public static String read(String fileName){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try{
                String s;
                while((s = in.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
            }finally {
                in.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName,String text){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                out.print(text);
            }finally {
                out.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")){
            remove(0);
        }
    }

    public TextFile(String fileName){
        this(fileName,"\n");
    }

    public void write(String fileName){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                for(String item : this){
                    out.println(item);
                }
            }finally {
                out.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        String file = read(IOFileBaseName.baseName + "TextFile.java");
        write(IOFileBaseName.baseName + "test.txt",file);
        TextFile text = new TextFile(IOFileBaseName.baseName + "test.txt");
        text.write(IOFileBaseName.baseName + "test2.txt");
        TreeSet<String> words = new TreeSet<>(new TextFile(IOFileBaseName.baseName + "TextFile.java","\\W+"));
        Print.print(words.headSet("a"));
    }

}
