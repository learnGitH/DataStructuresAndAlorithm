package com.haibin.thinking.io.nio;

import com.haibin.thinking.util.Print;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class AvailableCharSets {
    public static void main(String[] args){
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Iterator<String> it = charsets.keySet().iterator();
        while(it.hasNext()){
            String csName = it.next();
            Print.printnb(csName);
            Iterator aliases = charsets.get(csName).aliases().iterator();
            if (aliases.hasNext()){
                Print.printnb(": ");
            }
            while(aliases.hasNext()){
                Print.printnb(aliases.next());
                if (aliases.hasNext()){
                    Print.printnb(", ");
                }
            }
            Print.print();
        }
    }
}
