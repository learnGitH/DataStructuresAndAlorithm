package com.haibin.thinking.reflect;

import com.haibin.thinking.typeinfo.pets.Pet;
import com.haibin.thinking.util.MapData;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount3 {

    static class PetCounter extends LinkedHashMap<Class<? extends Pet>,Integer>{

        public PetCounter(){
            super(MapData.map(LiteralPetCreator.allTypes,0));
        }

        public void count(Pet pet){
            for (Map.Entry<Class<? extends Pet>,Integer> pair : entrySet()){
                if (pair.getKey().isInstance(pet)){
                    put(pair.getKey(),pair.getValue() + 1);
                }
            }
        }

        public String toString(){
            StringBuilder result = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>,Integer> pari : entrySet()){
                result.append(pari.getKey().getSimpleName());
                result.append("=");
                result.append(pari.getValue());
                result.append(", ");
            }
            result.delete(result.length() - 2,result.length());
            result.append("}");
            return result.toString();
        }
    }

    public static void main(String[] args){
        PetCounter petCounter = new PetCounter();
        for (Pet pet : Pets.createArray(20)){
            System.out.println(pet.getClass().getSimpleName() + " ");
            petCounter.count(pet);
        }
        System.out.println();
        System.out.println(petCounter);
    }
}
