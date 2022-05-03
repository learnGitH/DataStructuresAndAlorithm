package com.haibin.thinking.reflect;

import com.haibin.thinking.typeinfo.pets.Mutt;
import com.haibin.thinking.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "com.haibin.thinking.typeinfo.pets.Mutt",
            "com.haibin.thinking.typeinfo.pets.Pug",
            "com.haibin.thinking.typeinfo.pets.EgyptianMau",
            "com.haibin.thinking.typeinfo.pets.Manx",
            "com.haibin.thinking.typeinfo.pets.Cymric",
            "com.haibin.thinking.typeinfo.pets.Rat",
            "com.haibin.thinking.typeinfo.pets.Mouse",
            "com.haibin.thinking.typeinfo.pets.Hamster"
    };

    private static void loader(){
        try{
            for (String name : typeNames){
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
