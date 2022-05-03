package com.haibin.thinking.string;

import com.haibin.thinking.util.Print;
import com.haibin.thinking.util.RandomGenerator;

import java.util.Random;

public class UsingStringBuilder {
    public static Random rand = new Random();
    public String toString(){
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < 25; i++){
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2,result.length());
        result.append("]");
        return result.toString();
    }
    public static void main(String[] args){
        UsingStringBuilder usb = new UsingStringBuilder();
        Print.print(usb);
    }
}
