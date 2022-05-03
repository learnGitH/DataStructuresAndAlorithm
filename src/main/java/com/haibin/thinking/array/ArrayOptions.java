package com.haibin.thinking.array;

import com.haibin.thinking.util.Print;

import java.util.Arrays;

public class ArrayOptions {
    public static void main(String[] args){
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];
        Print.print("b: " + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++){
            if (c[i] == null){
                c[i] = new BerylliumSphere();
            }
        }
        BerylliumSphere[] d = {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        a = new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};
        Print.print("a.length = " + a.length);
        Print.print("b.length = " + b.length);
        Print.print("c.length = " + c.length);
        Print.print("d.length = " + c.length);
        a = d;
        Print.print("d.length = " + d.length);

        int[] e;
        int[] f = new int[5];
        Print.print("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++){
            g[i] = i*i;
        }
        int[] h = {11,47,93};
        Print.print("f.length = " + f.length);
        Print.print("g.length = " + g.length);
        Print.print("h.length = " + h.length);
        e = h;
        Print.print("e.length = " + e.length);
        e = new int[]{1,2};
        Print.print("e.length = " + e.length);
    }
}
