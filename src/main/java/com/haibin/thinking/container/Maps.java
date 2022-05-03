package com.haibin.thinking.container;

import com.haibin.thinking.util.CountingMapData;
import com.haibin.thinking.util.Print;
import com.haibin.thinking.util.RandomGenerator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {
    public static void printKeys(Map<Integer,String> map){
        Print.printnb("Size = " + map.size() + ", ");
        Print.printnb("keys: ");
        Print.print(map.keySet());
    }

    public static void test(Map<Integer,String> map){
        Print.print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        map.putAll(new CountingMapData(25));
        printKeys(map);
        Print.printnb("Values: ");
        Print.print(map.values());
        Print.print(map);
        Print.print("map.containsKey(11): " + map.containsKey(11));
        Print.print("map.get(11): " + map.get(11));
        Print.print("map.containsValue(\"FO\"): " + map.containsValue("FO"));
        Integer key = map.keySet().iterator().next();
        Print.print("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        Print.print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        Print.print("map.isEmpty(): " + map.isEmpty());
    }

    public static void main(String[] args){
        test(new HashMap<Integer,String>());
        test(new TreeMap<Integer,String>());
        test(new LinkedHashMap<Integer,String>());
        test(new IdentityHashMap<Integer,String>());
        test(new ConcurrentHashMap<Integer,String>());
        test(new WeakHashMap<Integer,String>());
    }

}
