package com.haibin.thinking.newreflect;

import com.haibin.thinking.util.Print;

public class SweetShop {
    public static void main(String[] args){
        Print.print("inside main");
        new Candy();
        Print.print("Candy");
        try{
            Class.forName("com.haibin.thinking.newreflect.Gum");
        }catch (ClassNotFoundException e){
            Print.print("Couldn't find Gum");
        }
        Print.print("After Class.forName(\"Gum\")");
        new Cookie();
        Print.print("After creating Cookie");
    }
}

class Candy{
    static {
        Print.print("Loading Candy");
    }
}

class Gum{
    static {
        Print.print("Loading Gum");
    }
}

class Cookie{
    static {
        Print.print("Loading Cookie");
    }
}