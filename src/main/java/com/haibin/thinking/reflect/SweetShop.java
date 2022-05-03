package com.haibin.thinking.reflect;

public class SweetShop {

    public static void main(String[] args){
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try{
            Class.forName("com.haibin.thinking.reflect.Gum");
        }catch (ClassNotFoundException e){
            System.out.println("Could't find Gum");
        }
        System.out.println("After Class.forName(Gum)");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
