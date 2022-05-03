package com.haibin.concurrency.atomic;

import lombok.Data;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.UnaryOperator;

public class AtomicReferenceFieldUpdaterRunner {

    static AtomicReferenceFieldUpdater atomic = AtomicReferenceFieldUpdater.newUpdater(Document.class,String.class,"name");

    public static void main(String[] args) {
        Document document = new Document("海滨",1);
        System.out.println(atomic.get(document));
        atomic.getAndSet(document,"meinv");
        System.out.println(atomic.get(document));

        UnaryOperator<String> uo = s->{
            System.out.println("UnaryOperator:-->" + s);
            return "美女";
        };
        System.out.println(atomic.getAndUpdate(document,uo));
        System.out.println(atomic.get(document));

    }

    @Data
    static class Document{
        public volatile String name;
        private int version;

        Document(String obj,int v){
            name = obj;
            version = v;
        }

    }

}
