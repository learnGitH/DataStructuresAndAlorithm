package com.haibin.thinking.container;

import com.haibin.thinking.generic.Generator;
import com.haibin.thinking.util.CountingGenerator;
import com.haibin.thinking.util.Print;
import com.haibin.thinking.util.RandomGenerator;

import java.util.Iterator;

class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{

    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer,String>(number++,""+letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class MapDataTest {
    public static void main(String[] args){
        Print.print(MapData.map(new Letters(),11));
        Print.print(MapData.map(new Letters(),"Pop"));
    }
}
