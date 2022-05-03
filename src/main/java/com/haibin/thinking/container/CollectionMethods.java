package com.haibin.thinking.container;

import com.haibin.thinking.util.Countries;
import com.haibin.thinking.util.Print;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionMethods {
    public static void main(String[] args){
        Collection<String> c = new ArrayList<String>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        Print.print(c);
        Object[] array = c.toArray();
        String[] str = c.toArray(new String[0]);
        Print.print("Collections.max(c) = " + Collections.max(c));
        Print.print("Collections.min(c) + " + Collections.min(c));
        Collection<String> c2 = new ArrayList<String>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        Print.print(c);
        c.remove(Countries.DATA[0][0]);
        Print.print(c);
        c.remove(Countries.DATA[1][0]);
        Print.print(c);
        c.removeAll(c2);
        Print.print(c);
        c.addAll(c2);
        Print.print(c);
        Print.print("-----------------------------------");
        String val = Countries.DATA[3][0];
        Print.print("c.contains(" + val + ") = " + c.contains(val));
        Print.print("c.containsAll(c2)" + c.containsAll(c2));
        Collection<String> c3 = ((List<String>)c).subList(3,5);
        c2.retainAll(c3);
        Print.print(c2);
        c2.removeAll(c3);
        Print.print("c2.isEmpty() = " + c2.isEmpty());
        c = new ArrayList<String>();
        ((ArrayList<String>) c).addAll(Countries.names(6));
        Print.print(c);
        c.clear();
        Print.print("after c.clear():" + c);
    }
}
