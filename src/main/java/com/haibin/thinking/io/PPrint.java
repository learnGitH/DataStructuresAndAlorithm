package com.haibin.thinking.io;

import com.haibin.thinking.util.Print;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
    public static String pformat(Collection<?> c){
        if (c.size() == 0){
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        for (Object elem : c){
            if (c.size() != 1){
                result.append("\n ");
            }
            result.append(elem);
        }

        if (c.size() != 1){
            result.append("]");
        }
        result.append("]");
        return result.toString();
    }
    public static void pprint(Collection<?> c){
        Print.print(pformat(c));
    }

    public static void pprint(Object[] c){
        Print.print(pformat((Arrays.asList(c))));
    }
}
