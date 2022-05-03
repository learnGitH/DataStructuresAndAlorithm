package com.haibin.thinking.array;

import com.haibin.thinking.util.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerComparison {
    public static void main(String[] args){
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++){
            spheres[i] = new BerylliumSphere();
        }
        Print.print(Arrays.toString(spheres));
        Print.print(spheres[4]);
        List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
        for (int i = 0; i < 5; i++){
            sphereList.add(new BerylliumSphere());
        }
        Print.print(sphereList);
        Print.print(sphereList.get(4));

        int[] integers = {0,1,2,3,4,5};
        Print.print(Arrays.toString(integers));
        Print.print(integers[4]);

        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5));
        intList.add(97);
        Print.print(intList);
        Print.print(intList.get(4));
    }
}

class BerylliumSphere{
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return "Sphere " + id;
    }
}