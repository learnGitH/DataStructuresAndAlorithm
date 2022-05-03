package com.haibin.thinking.reflect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part{
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    static {
        partFactories.add(new FuelFilter.Factory());
    }
    private static Random rand = new Random(47);
    public static Part creatRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part{
}

class FuelFilter extends Filter{
    public static class Factory implements com.haibin.thinking.reflect.Factory<FuelFilter>{
        public FuelFilter create(){return new FuelFilter();}
    }
}

public class RegisteredFactories {
    public static void main(String[] args){

    }
}
