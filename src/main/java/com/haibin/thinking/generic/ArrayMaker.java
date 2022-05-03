package com.haibin.thinking.generic;

import com.haibin.thinking.util.Print;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }
    T[] create(int size){
        return (T[]) Array.newInstance(kind,size);
    }
    public static void main(String[] args){
        ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        Print.print(Arrays.toString(stringArray));
    }
}
