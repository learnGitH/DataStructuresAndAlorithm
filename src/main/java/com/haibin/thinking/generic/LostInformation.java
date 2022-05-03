package com.haibin.thinking.generic;

import com.haibin.thinking.util.Print;

import java.util.*;

class Frob{}
class Fnorkle{}
class Quark<Q>{}
class Particle<POSITION,MOMENTUM>{}

public class LostInformation {
    public static void main(String[] args){
        List<Frob> list = new ArrayList<Frob>();
        Map<Frob,Fnorkle> map = new HashMap<Frob,Fnorkle>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();
        Particle<Long,Double> p = new Particle<Long,Double>();
        Print.print(Arrays.toString(list.getClass().getTypeParameters()));
        Print.print(Arrays.toString(map.getClass().getTypeParameters()));
        Print.print(Arrays.toString(quark.getClass().getTypeParameters()));
        Print.print(Arrays.toString(p.getClass().getTypeParameters()));
    }
}
