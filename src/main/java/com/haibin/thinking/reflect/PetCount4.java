package com.haibin.thinking.reflect;

import com.haibin.thinking.typeinfo.pets.Pet;

public class PetCount4 {
    public static void main(String[] args){
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)){
            System.out.println(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
