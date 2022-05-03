package com.haibin.refactoring.re;

import java.util.Date;

public class Param {

    public static void main(String[] args){
        Date d1 = new Date("1 Apr 98");
        nextDateUpdate(d1);
        System.out.println("d1 after nextDay: " + d1);

        Date d2 = new Date("1 Apr 98");
        nextDateReplace(d2);
        System.out.println("d2 after nextDay: " + d2);
    }

    private static void nextDateUpdate(Date arg){
        arg.setDate(arg.getDate() + 1);
        System.out.println("arg  in nextDay: " + arg);
    }

    private static void nextDateReplace(Date arg){
        arg = new Date(arg.getYear(),arg.getMonth(),arg.getDate() + 1);
        System.out.println("arg in nextDay: " + arg);
    }


}
