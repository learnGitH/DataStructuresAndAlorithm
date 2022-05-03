package com.haibin.thinking.container;

import com.haibin.thinking.util.Print;

import java.util.*;

public class Unsupported {
    static void test(String msg, List<String> list){
        Print.print("--- " + msg + "--- ");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1,8);
        Collection<String> c2 = new ArrayList<String>(subList);
        try{
            c.retainAll(c2);
        }catch (Exception e){
            Print.print("retainAll()" + e);
        }

        try{
            c.clear();
        }catch (Exception e){
            Print.print("clear()" + e);
        }

        try{
            c.retainAll(c2);
        }catch (Exception e){
            Print.print("retainAll()" + e);
        }

        try{
            c.add("X");
        }catch (Exception e){
            Print.print("add(X)" + e);
        }

        try{
            c.addAll(c2);
        }catch (Exception e){
            Print.print("addAll(c2)" + e);
        }

        try{
            c.remove("C");
        }catch (Exception e){
            Print.print("remove(C)" + e);
        }

        try{
            list.set(0,"X");
        }catch (Exception e){
            Print.print("list.set()" + e);
        }
    }

    public static void main(String[] args){
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy",new ArrayList<String>(list));
        test("Arrays.asList()",list);
        test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<String>(list)));
    }
}
